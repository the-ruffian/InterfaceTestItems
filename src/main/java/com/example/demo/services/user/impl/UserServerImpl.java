/*
 * @Description:UserServerImpl
 * @CreatedBy:IntelliJ IDEA
 * @Author: the-ruffian
 * @Date: 2022-05-29 14:06
 * @LastEditTime: 2022-05-29 14:06
 * @LastEditors: the-ruffian
 */
package com.example.demo.services.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserDao;
import com.example.demo.model.dto.RegisterDto;
import com.example.demo.services.user.server.UserService;
import com.example.demo.utils.Common;
import com.example.demo.utils.HmacUtil;
import com.example.demo.utils.model.OpenResponse;
import org.springframework.stereotype.Service;

/**
 * @author the-ruffian
 */
@Service("UserServer")

public class UserServerImpl implements UserService {
    final
    UserDao userDao;

    public UserServerImpl(UserDao userDao) {
        this.userDao = userDao;
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
            user.setPassword(HmacUtil.getSsa256Str(registerDto.getPassword()));
            user.setEmail(registerDto.getEmail());
            user.setCreateTime(Common.getNowTime());
            userDao.insert(user);
            return OpenResponse.ok("尊敬的" + registerDto.getUsername() + ",恭喜你注册成功");
        } else {
            return OpenResponse.fail("未知错误");
        }

    }
}
