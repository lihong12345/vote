package com.cqeec.vote.service.impl;

import com.cqeec.vote.domain.Img;
import com.cqeec.vote.mapper.ImgMapper;
import com.cqeec.vote.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    private ImgMapper imgMapper;

    @Override
    public int inertImg(Img img) {
        imgMapper.Insert1(img);
        return 0;
    }

    @Override
    public List<Img> in() {
        return imgMapper.f();
    }
}
