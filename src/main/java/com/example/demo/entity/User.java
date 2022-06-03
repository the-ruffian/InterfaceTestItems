package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author the-ruffian
 */

@Data
@TableName(value = "user")
@ApiModel(value = "用户表")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "性别")
    private Integer gender;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "身份证号")
    private String idNumber;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp loginTime;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "邮箱")
    private String email;
}
