package com.cqeec.vote.service.impl;

import com.cqeec.vote.domain.Img;
import com.cqeec.vote.domain.User;
import com.cqeec.vote.mapper.UserMapper;
import com.cqeec.vote.service.UserService;
import org.apache.ibatis.type.NStringTypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Service/*才能加载这个类这个类是写逻辑的*/
public class UserserviceImp implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean login( User user) {
        User userInMysql= userMapper.finAll1(user);
        try{
            if (user.getPwd().equals(userInMysql.getPwd())){

//                map.put("ti",userMapper.f(new Img()));
//                HttpSession session=request.getSession();
//                session.setAttribute("email",email);
                return true;
            }else {
                return false;
            }
        }catch (NullPointerException e){
            return false;

    }
}}
