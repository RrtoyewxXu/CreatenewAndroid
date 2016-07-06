package com.youku.rrtoyewx.newandroid.bean;

/**
 * Created by Rrtoyewx on 16/7/6.
 */
public class SplashImageBean {
    private String text;
    private String img;

    public SplashImageBean() {
    }

    public SplashImageBean(String text, String img) {
        this.text = text;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
