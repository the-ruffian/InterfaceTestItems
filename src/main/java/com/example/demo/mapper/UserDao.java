package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author the-ruffian
 */
@Component
public interface UserDao extends BaseMapper<User> {

}
