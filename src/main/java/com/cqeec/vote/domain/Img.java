package com.cqeec.vote.domain;

import javax.xml.crypto.Data;

public class Img {
    private int id;
    private String img_addr;
    private String author;
    private Data create_at;
    //这个属性用来保存author属性关联的用户信息
    private User user;
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }
    public Img(){};

    public void setId(int id) {
        this.id = id;
    }

    public String getImg_addr() {
        return img_addr;
    }

    public void setImg_addr(String img_addr) {
        this.img_addr = img_addr;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Data getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Data create_at) {
        this.create_at = create_at;
    }
}
