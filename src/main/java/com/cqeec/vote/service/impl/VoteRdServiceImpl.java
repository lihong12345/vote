package com.cqeec.vote.service.impl;

import cn.hutool.core.date.DateUtil;
import com.cqeec.vote.domain.MyException;
import com.cqeec.vote.domain.VoteRed;
import com.cqeec.vote.mapper.VoteRecodMapper;
import com.cqeec.vote.service.VoteRdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteRdServiceImpl implements VoteRdService {
    @Autowired
    private VoteRecodMapper voteRecodMapper;

    @Override
    public int pp(int imgid, String email) {
        String today= DateUtil.today();
        VoteRed voteRed=new VoteRed(imgid,email);
        voteRed.setToday(today);
        int num=voteRecodMapper.hj(voteRed);
        System.out.println(num);
        int num1=voteRecodMapper.hj1(voteRed);
        if(num1>2){
return -1;
//            throw new MyException(-1,"每天只能投3次票");
        }
        if(num>0){
            return 1;
//            throw new MyException(-2,"每张图片只能投1次");
        }
        return voteRecodMapper.insert12(voteRed);
    }

}
