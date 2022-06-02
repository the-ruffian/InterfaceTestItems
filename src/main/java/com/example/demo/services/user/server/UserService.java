package com.example.demo.services.user.server;

import com.example.demo.model.dto.RegisterDto;
import com.example.demo.utils.model.OpenResponse;

/**
 * @author the-ruffian
 */
public interface UserService {
    /**
     *  注册接口
     * @param registerDto RegisterDto
     * @return 注册信息
     */
    OpenResponse<Object> register(RegisterDto registerDto);
}
