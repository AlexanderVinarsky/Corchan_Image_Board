package ru.corchan.models;

import jakarta.validation.constraints.NotNull;

public class Post {
    @NotNull
    private Integer id;

    @NotNull
    private String txt;

    private Integer inThread;

    private String image1;

    public Post() {
    }

    public Post(Integer id, String text) {
        this.id = id;
        this.txt = text;
        this.inThread = inThread;
    }

    public Integer getId() {
        return id;
    }

    public String getTxt() {
        return txt;
    }

    public Integer getInThread() {
        return inThread;
    }

    public String getImage1() {
        return image1;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setInThread(Integer inThread) {
        this.inThread = inThread;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }
}
