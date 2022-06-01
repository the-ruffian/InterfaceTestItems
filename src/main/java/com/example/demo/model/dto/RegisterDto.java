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
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

import java.io.Serializable;


/**
 * @author the-ruffian
 */
@Data
public class RegisterDto implements Serializable {
    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "用户名不能为空")
    @ApiModelProperty(value = "手机号")
    @Pattern(regexp = "1[3456789][0-9]{9}",message = "手机号不符合格式")
    private String phone;

    @ApiModelProperty(value = "密码(md5加密)")
    @Length(min = 32, max = 32, message = "密码必须经过md5加密，32位")
    private String password;

    @ApiModelProperty(value = "性别(0女，1男，2保密)")
    @Min(0)
    @Max(2)
    private Integer gender;

    @ApiModelProperty(value = "邮箱")
    @NotEmpty(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

}
