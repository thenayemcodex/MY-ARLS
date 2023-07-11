package com.aimsgroup.arls.Models;

public class GetBIdsDataModel {
    // myDB.execSQL("create table myBids(id int primary key, username text, name text , tag text, amount int, additional text, mobile text, gmail text,  time text, approval text )");
    private int id;
    private String username;
    private String name;
    private String tag;
    private int amount;
    private String additional;
    private String mobile;
    private String gmail;
    private String time;
    private String approval;


    public GetBIdsDataModel(int id, String username, String name, String tag, int amount, String additional, String mobile, String gmail, String time, String approval) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.tag = tag;
        this.amount = amount;
        this.additional = additional;
        this.mobile = mobile;
        this.gmail = gmail;
        this.time = time;
        this.approval = approval;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }




}
