/*
 * @Description:RegisterDto
 * @CreatedBy:IntelliJ IDEA
 * @Author: the-ruffian
 * @Date: 2022-05-29 13:45
 * @LastEditTime: 2022-05-29 13:45
 * @LastEditors: the-ruffian
 */
package com.example.demo.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author the-ruffian
 */

public class RegisterDto {
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "密码(md5加密)")
    private String password;
    @ApiModelProperty(value = "性别(0女，1男，2保密)")
    private Integer gender;
    @ApiModelProperty(value = "邮箱")
    private String email;

}
