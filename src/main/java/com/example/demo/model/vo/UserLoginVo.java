package com.example.demo.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author the-ruffian
 */

@Data
public class UserLoginVo {
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "token")
    private String token;
}
