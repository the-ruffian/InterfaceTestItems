package com.example.demo.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author the-ruffian
 * @date 2022-06-08 13:41
 */
@Data
public class UserUpdateVo {
    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "邮箱")
    private String email;
}
