package com.example.demo.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @date 2022-06-05 13:18:16
 * @author the-ruffian
 */
@Data
public class UpdateDto implements Serializable {

    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "手机号不能为空")
    @Pattern(regexp = "1[3456789][0-9]{9}", message = "手机号错误，请重新输入")
    private String phone;

    @ApiModelProperty(value = "性别(0女，1男，2保密)")
    @Min(0)
    @Max(2)
    private Integer gender;

    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "邮箱")
    @NotEmpty(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;
}
