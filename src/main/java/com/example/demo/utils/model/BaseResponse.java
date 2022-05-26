package com.example.demo.utils.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("响应对象数据")
public class BaseResponse {
    @ApiModelProperty("是否成功")
    protected boolean success;
    @ApiModelProperty("返回编码")
    protected int code;
    @ApiModelProperty("返回具体业务子编码")
    protected int subCode;
    @ApiModelProperty("返回信息")
    protected String message;
}