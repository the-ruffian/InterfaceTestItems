/*
 * @Description:UserDao
 * @CreatedBy:IntelliJ IDEA
 * @Author: the-ruffian
 * @Date: 2022-05-29 14:08
 * @LastEditTime: 2022-05-29 14:08
 * @LastEditors: the-ruffian
 */
package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends BaseMapper<User> {

}
