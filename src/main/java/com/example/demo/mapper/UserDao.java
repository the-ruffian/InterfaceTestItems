package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import com.example.demo.model.dto.UpdateDto;
import com.example.demo.model.vo.UserUpdateVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author the-ruffian
 */
@Component
public interface UserDao extends BaseMapper<User> {
    /**
     * 修改个人信息
     * @param updateDto phone e_mali gender username
     */
    @Update("<script>" +
            "update " +
            "user " +
            "set phone=CONCAT(#{updateDto.phone})" +
            "<if test=\"updateDto.gender!=null\">, gender=CONCAT(#{updateDto.gender})</if>" +
            "<if test=\"updateDto.username!=null\">, username=CONCAT(#{updateDto.username})</if>" +
            "<if test=\"updateDto.email!=null\">, email=CONCAT(#{updateDto.email})</if>" +
            " where phone=#{updateDto.phone}" +
            "</script>")
    void userUpdateSelf(@Param("updateDto")UpdateDto updateDto);


    /**
     * 修改信息后的返回
     * @param updateDto phone e_mali gender username
     * @return after fix
     */
    @Select("<script>" +
            "select " +
            "phone, gender, email, username " +
            "from user " +
            "where phone=#{updateDto.phone}" +
            "</script>")
    List<UserUpdateVo> userUpdateReturn(@Param("updateDto")UpdateDto updateDto);
}
