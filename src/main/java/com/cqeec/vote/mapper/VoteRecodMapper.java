package com.cqeec.vote.mapper;

import com.cqeec.vote.domain.VoteRed;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface VoteRecodMapper {
    @Insert("insert into vote_log(img_id,voter) values(#{img_id},#{voter}) ")
    public int insert12(VoteRed voteRed);
    @Select("SELECT COUNT(*) FROM vote_log where img_id=#{img_id} AND voter=#{voter} AND DATE_FORMAT(create_at,'%Y-%m-%d')=#{today}")
    public int hj(VoteRed voteRed);
    @Select("SELECT COUNT(*) FROM vote_log where voter=#{voter} AND DATE_FORMAT(create_at,'%Y-%m-%d')=#{today}")
    public int hj1(VoteRed voteRed);
    @Select("select count(*) as num from vote_log where img_id=#{img_id}")
    public int ddf(int img_id);
}
