package com.example.demo.enums;



import lombok.Getter;

/**
 * @author the-ruffian
 */

@Getter
public enum Status{
    /**
     * SUCCESS 成功
     */
    SUCCESS(200,"成功"),
    /**
     * FAIL 失败
     */
    FAIL(400,"失败");


    private int code;
    private String message;
    Status(int code, String message){
        this.code=code;
        this.message=message;
    }


}