package com.sizick.leviathtrailer.utils.sql;

import com.sizick.leviathtrailer.LeviathTrailerBot;
import com.sizick.leviathtrailer.utils.OrderObject;

import java.sql.*;

/**
 * The MIT License (MIT)
 * Created on 25/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class SQLManager {

    private static void open() {
        LeviathTrailerBot.getSQL().open();
    }

    public static void createOrder(String discord_client) {
        open();
        Date date = new Date(System.currentTimeMillis());
        SQL.set("INSERT INTO commandes (discord_client, start_date) VALUES ('" + discord_client + "', '" + date + "')");
    }

    public static int getLastID() {
        open();
        try {
            ResultSet rs = SQL.get("SELECT * FROM commandes ORDER BY id DESC");
            while(rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static OrderObject getOrder(int id) {
        open();
        OrderObject order;
        try {
            ResultSet rs = SQL.get("SELECT * FROM commandes WHERE id = '" + id + "'");
            if(rs.next()) {
                /*
                if(rs.getString("discord_editor") == null) {
                    order = new OrderObject(rs.getString("discord_client"), rs.getDate("start_date"));
                } else {
                    order = new OrderObject(rs.getString("discord_client"), rs.getDate("start_date"), rs.getString("discord_editor"));
                }
                */
                order = new OrderObject(rs.getString("discord_client"), rs.getDate("start_date"), rs.getDate("end_date"),
                        rs.getString("discord_editor"), rs.getInt("tarif"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
