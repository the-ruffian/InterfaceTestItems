/*
 * @Description:UserServerImpl
 * @CreatedBy:IntelliJ IDEA
 * @Author: the-ruffian
 * @Date: 2022-05-29 14:06
 */
package com.example.demo.services.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserDao;
import com.example.demo.model.dto.LoginDto;
import com.example.demo.model.dto.RegisterDto;
import com.example.demo.model.dto.UpdateDto;
import com.example.demo.model.vo.UserLoginVo;
import com.example.demo.services.user.server.UserService;
import com.example.demo.utils.Common;
import com.example.demo.utils.HmacUtil;
import com.example.demo.utils.JWTUtils;
import com.example.demo.utils.RedisUtils;
import com.example.demo.utils.model.OpenResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author the-ruffian
 */
@Service("UserServer")

public class UserServerImpl implements UserService {
    final
    UserDao userDao;

    final
    RedisUtils redisUtils;

    public UserServerImpl(UserDao userDao, RedisUtils redisUtils) {
        this.userDao = userDao;
        this.redisUtils = redisUtils;
    }

    @Override
    public OpenResponse<Object> register(RegisterDto registerDto){
        Integer gender = registerDto.getGender();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        Integer integer = userDao.selectCount(userQueryWrapper.select("phone")
                .eq("phone", registerDto.getPhone()));

        if (integer == 1) {
            return OpenResponse.fail("手机号已存在");
        } else if (integer == 0) {
            User user = new User();
            user.setPhone(registerDto.getPhone());
            user.setUsername(registerDto.getUsername());
            user.setGender(gender);
            user.setPassword(HmacUtil.getSha256Str(registerDto.getPassword()));
            user.setEmail(registerDto.getEmail());
            user.setCreateTime(Common.getNowTime());
            userDao.insert(user);
            return OpenResponse.ok("尊敬的" + registerDto.getUsername() + ",恭喜你注册成功");
        } else {
            return OpenResponse.fail("未知错误");
        }

    }

    @Override
    public OpenResponse<Object> login(LoginDto loginDto){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        if (userDao.selectCount(userQueryWrapper
                .eq("phone",loginDto.getPhone())) != 0 ){
            User user = userDao.selectOne(userQueryWrapper.select("password")
                    .eq("phone", loginDto.getPhone()));
            if (HmacUtil.getSha256Str(loginDto.getPassword()).equals(user.getPassword())){
                user.setLoginTime(Common.getNowTime());
                userDao.update(user, userQueryWrapper.eq("phone", loginDto.getPhone()));
                UserLoginVo userLoginVo = new UserLoginVo();
                String userToken = "user_"+loginDto.getPhone();
                if (!redisUtils.exists(userToken)){
                    HashMap<String, String> payload = new HashMap<>(255);
                    payload.put("phone", loginDto.getPhone());
                    payload.put("password",HmacUtil.getSha256Str(loginDto.getPassword()));
                    String token = JWTUtils.getToken(payload);
                    userLoginVo.setToken(token);

                    HashMap<Object, Object> objectObjectHashMap = new HashMap<>(255);
                    objectObjectHashMap.put("username", user.getUsername());
                    objectObjectHashMap.put("token",token);
                    redisUtils.hmSet("user_"+ loginDto.getPhone(), objectObjectHashMap);
                    redisUtils.setTimeOfDay(userToken,7);

                }else {
                    redisUtils.setTimeOfDay(userToken,7);
                    String token = redisUtils.hmGet(userToken, "token").toString();
                    userLoginVo.setToken(token);
                }
                userLoginVo.setUsername(user.getUsername());
                return OpenResponse.ok("登录成功",userLoginVo);
            }else {
                return OpenResponse.fail("密码错误");
            }
        }else {
            return OpenResponse.fail("账号不存在");
        }
    }

    @Override
    public OpenResponse<Object> update(UpdateDto updateDto){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        Integer existUser = userDao.selectCount(userQueryWrapper.eq("phone", updateDto.getPhone()));
        if (existUser != 0){
            try {
                userDao.userUpdateSelf(updateDto);
                return OpenResponse.ok("信息修改成功", userDao.userUpdateReturn(updateDto));
            }catch (Exception e){
                return OpenResponse.fail("修改失败",e);
            }
        }else {
            return OpenResponse.fail("用户不存在");
        }
    }
}
