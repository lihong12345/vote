package com.cqeec.vote.domain;

import javax.xml.crypto.Data;
import java.util.Date;

public class VoteRed {
    private  int id;
    private int img_id;
    private String voter;
    private String today;

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public VoteRed(int img_id, String voter) {
        this.img_id = img_id;
        this.voter = voter;
    }

    private Data create_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    public Data getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Data create_at) {
        this.create_at = create_at;
    }
}
