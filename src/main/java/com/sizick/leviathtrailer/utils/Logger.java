package com.sizick.leviathtrailer.utils;

import com.sizick.leviathtrailer.LeviathTrailerBot;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * The MIT License (MIT)
 * Created on 27/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class Logger {

    public static TextChannel getLogTextChannel() {
        return LeviathTrailerBot.getInstance().getJda().getGuildById("564849580139872257").getTextChannelById("566231691337662476");
    }
}
