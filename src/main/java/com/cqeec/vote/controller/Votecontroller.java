package com.cqeec.vote.controller;

import com.cqeec.vote.domain.Img;
import com.cqeec.vote.mapper.ImgMapper;
import com.cqeec.vote.service.VoteRdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("vote")
public class Votecontroller {
    @Autowired
    private VoteRdService voteRdService;
    @PostMapping("byid")
    @ResponseBody
    public Object byId(int id, HttpServletRequest request){
        HttpSession session=request.getSession();
        System.out.println(id);
        System.out.println(session.getAttribute("email"));


        voteRdService.pp(id,(String) session.getAttribute("email"));

        return null;
    }

}
