/*
 * @Description:UserController
 * @CreatedBy:IntelliJ IDEA
 * @Author: the-ruffian
 * @Date: 2022-05-29 15:25
 * @LastEditTime: 2022-05-29 15:25
 * @LastEditors: the-ruffian
 */
package com.example.demo.controller;

import com.example.demo.model.dto.LoginDto;
import com.example.demo.model.dto.RegisterDto;
import com.example.demo.model.dto.UpdateDto;
import com.example.demo.services.user.server.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author bugpz
 */
@Api(value = "用户模块", tags = "User")
@RestController
@RequestMapping("api/user")
@Validated public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register", produces = "application/json; charset=UTF-8")
    public Object create(@Validated @RequestBody RegisterDto registerDto){
        return userService.register(registerDto);
    }

    @ApiOperation(value = "登录")
    @PostMapping(value = "/login", produces = "application/json; charset=UTF-8")
    public Object login(@Validated @RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

    @ApiOperation(value = "修改个人信息")
    @PostMapping(value = "/update",produces = "application/json; charset=UTF-8")
    public Object update(@Validated @RequestBody UpdateDto updateDto){
        return userService.update(updateDto);
    }
}
