package com.example.demo.services.user.server;

import com.example.demo.model.dto.LoginDto;
import com.example.demo.model.dto.RegisterDto;
import com.example.demo.model.dto.UpdateDto;
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

    /**
     * 登录接口
     * @param loginDto phone,password
     * @return token
     */
    OpenResponse<Object> login(LoginDto loginDto);

    /**
     *
     * @param updateDto phone
     * @return new_information
     */
    OpenResponse<Object> update(UpdateDto updateDto);
}
