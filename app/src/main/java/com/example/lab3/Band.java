package com.example.lab3;

import java.util.Date;

public class Band {
    private String name;
    private String date;
    private String ganre;
    private String long_info;
    private int avatarID;

    public Band(String name, String date, String ganre, String long_info, int avatarID) {
        this.name = name;
        this.date = date;
        this.ganre = ganre;
        this.long_info = long_info;
        this.avatarID = avatarID;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getAvatarID() {
        return avatarID;
    }

    public String getGanre() {
        return ganre;
    }

    public String getLong_info() {
        return long_info;
    }
}
