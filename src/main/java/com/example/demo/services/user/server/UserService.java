package com.example.demo.services.user.server;

import com.example.demo.model.dto.RegisterDto;
import com.example.demo.utils.model.OpenResponse;

public interface UserService {
    OpenResponse register(RegisterDto registerDto);
}
