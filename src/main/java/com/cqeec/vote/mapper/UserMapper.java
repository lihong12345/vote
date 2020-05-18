package com.cqeec.vote.mapper;

import com.cqeec.vote.domain.Img;
import com.cqeec.vote.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select *  from user")
    public List<User> finAll(User user);
    @Select("select *  from user where email=#{email}")
    public  User finAll1(User user);
    @Select("select *  from user where email=#{email}")
    public  User finAll2(String email);
    @Insert("INSERT INTO user(email,nickname,pwd)VALUES(#{email},#{nickname},#{pwd}) ")
//    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")/*返回自增ID到实体类
//     */
    public Integer insert(User user);

}
