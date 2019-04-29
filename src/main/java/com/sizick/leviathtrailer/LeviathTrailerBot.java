package com.sizick.leviathtrailer;

import com.sizick.leviathtrailer.events.CommandsListener;
import com.sizick.leviathtrailer.events.JoinListener;
import com.sizick.leviathtrailer.utils.OrderObject;
import com.sizick.leviathtrailer.utils.sql.SQL;
import com.sizick.leviathtrailer.utils.sql.SQLManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.HashMap;

/**
 * The MIT License (MIT)
 * Created on 12/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class LeviathTrailerBot {

    /**
     * TODO:  -new -close;
     * TODO: ReactionRole un channel et un message pour avoir un grade notif-promote
     * TODO: Envoyé un message privé au resp commande lors de la création des tickets
     */

    private static LeviathTrailerBot instance;
    private static SQL sql = null;
    private JDA jda;
    private HashMap<Integer, OrderObject> orderObjectMap;

    public LeviathTrailerBot(String token) {
        instance = this;
        sql = new SQL("localhost", "leviathtrailer", "leviathtrailer", "0716");

        orderObjectMap = new HashMap<>();

        System.out.println(SQLManager.getLastID());

        try {
            jda = new JDABuilder(token).build();
            jda.getPresence().setActivity(Activity.streaming("leviath.fr | -help", "https://twitch.tv/SizickOfficial"));

            jda.addEventListener(new CommandsListener());
            jda.addEventListener(new JoinListener());

            jda.awaitReady();
            System.out.println("[BOT] Leviath Trailer Maker started !");

        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static LeviathTrailerBot getInstance() {
        return instance;
    }

    public JDA getJda() {
        return jda;
    }

    public void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static SQL getSQL() {
        return sql;
    }

    public HashMap<Integer, OrderObject> getOrderObjectMap() {
        return orderObjectMap;
    }

    public static void main(String[] args) {
        new LeviathTrailerBot("NTY2MzIwOTQ4NzAyMDg1MTMw.XLDRyg.zrFrUrgYbMAK1xUIjwks01VPdmE");
    }
}
