package com.cqeec.vote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("filter")

public class Filercontroller {
    @RequestMapping("t1")
    public Object fd(){
        return "2";
    }


}
