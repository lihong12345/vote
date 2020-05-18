package com.cqeec.vote.mapper;

import com.cqeec.vote.domain.Img;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface ImgMapper {
    @Insert("INSERT INTO img(img_addr,author)VALUES(#{img_addr},#{author})")
    public void Insert1(Img img);
    //单表查询的方法无法查询到昵称 使用mybatis注解方式实现关联查询
    @Select("select * from img ")
    @Results({
            @Result(column = "author",property = "author"),/*@Select("select * from img ")的结果放到Img后再分别把author的值
            作为参数放到com.cqeec.vote.mapper.UserMapper.finAll1这个地址里 分别把查询的结果放到img的user对象里
            */
            @Result(column = "author",property = "user",one = @One(select = "com.cqeec.vote.mapper.UserMapper.finAll2",fetchType = FetchType.EAGER)),//fetchType = FetchType.EAGER懒加载可以提高效率
            @Result(column = "id",property = "id"),
            @Result(column = "id",property = "num",one = @One(select = "com.cqeec.vote.mapper.VoteRecodMapper.ddf"))
    })
    public List<Img> f();
    public List<Img> ff();

}
