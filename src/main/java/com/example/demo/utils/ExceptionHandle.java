/*
 * @Description:ExceptionHandle
 * @CreatedBy:IntelliJ IDEA
 * @Author: the-ruffian
 * @Date: 2022-06-01 10:42
 * @LastEditTime: 2022-06-01 10:42
 * @LastEditors: the-ruffian
 */
package com.example.demo.utils;

import com.example.demo.enums.Status;
import com.example.demo.utils.model.OpenResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实体对象校验统一处理异常
 * @author  the-ruffian
 */

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Object handleBindException(BindException ex){
        List<String> defaultMsg = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        OpenResponse<Object> objectOpenResponse = new OpenResponse<>();
        objectOpenResponse.setCode(Status.FAIL.getCode());
        objectOpenResponse.setMessage(defaultMsg.get(0));
        return objectOpenResponse;
    }
}
