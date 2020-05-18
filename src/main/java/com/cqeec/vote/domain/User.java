package com.cqeec.vote.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {
    private int id;
    private String nickname;
    private String email;
    private String pwd;
    @JsonFormat(pattern = "yy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date create_at;

    public User() {

    }

    public User( String nickname, String email, String pwd, Object create_at) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public User(int id, String nickname, String email, String pwd, Date create_at) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.pwd = pwd;
        this.create_at = create_at;
    }
}
