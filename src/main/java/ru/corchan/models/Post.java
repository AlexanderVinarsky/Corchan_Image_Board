package ru.corchan.models;

import jakarta.validation.constraints.NotNull;

public class Post {
    @NotNull
    private Integer id;

    @NotNull
    private String txt;

    public Post() {
    }

    public Post(Integer id, String text) {
        this.id = id;
        this.txt = text;
    }

    public Integer getId() {
        return id;
    }

    public String getTxt() {
        return txt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
