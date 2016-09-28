package com.gcy.universal_adapter;

/**
 * Created by gcy71 on 2016/9/26.
 */

public class Bean {

    private String title;
    private String info;
    private String time;

    public Bean(String title, String info, String time) {
        this.title = title;
        this.info = info;
        this.time = time;
    }

    public Bean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
