package com.cqeec.vote.controller;

import com.cqeec.vote.domain.JsonData;
import com.cqeec.vote.domain.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice/*异常处理类*/
public class MyHandercontroller extends RuntimeException {
    @ExceptionHandler(value = MyException.class)/*捕获异常的范围Exception捕获所有异常*/
    public Object myFirstExceptionHandler(MyException e){

        return new JsonData(e.getCode(),e.getMsg());
    }

}
