package com.sizick.leviathtrailer.utils;

import com.sizick.leviathtrailer.LeviathTrailerBot;

import java.sql.Date;

/**
 * The MIT License (MIT)
 * Created on 27/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class OrderObject {

    private String discord_client;
    private Date start_date;
    private Date end_date;
    private String discord_editor;
    private int tarif;

    public OrderObject(String discord_client, Date start_date) {
        this.discord_client = discord_client;
        this.start_date = start_date;
    }

    public OrderObject(String discord_client, Date start_date, String discord_editor) {
        this.discord_client = discord_client;
        this.start_date = start_date;
        this.discord_editor = discord_editor;
    }

    public OrderObject(String discord_client, Date start_date, Date end_date, String discord_editor, int tarif) {
        this.discord_client = discord_client;
        this.start_date = start_date;
        this.end_date = end_date;
        this.discord_editor = discord_editor;
        this.tarif = tarif;
    }

    public String getDiscord_client() {
        return discord_client;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public String getDiscord_editor() {
        return discord_editor;
    }

    public int getTarif() {
        return tarif;
    }
}
