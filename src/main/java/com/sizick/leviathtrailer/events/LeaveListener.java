package com.sizick.leviathtrailer.events;

import com.sizick.leviathtrailer.utils.Logger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

/**
 * The MIT License (MIT)
 * Created on 27/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class LeaveListener extends ListenerAdapter {

    @Override
    public void onGuildMemberLeave(GuildMemberLeaveEvent e) {
        EmbedBuilder leaveLog = new EmbedBuilder();
        leaveLog.setTitle("Leviath - Logs")
                .setColor(0xFF0000)
                .setDescription(e.getMember().getAsMention() + " a quitté le serveur !")
                .setFooter("Leviath Corporation", "https://cdn.discordapp.com/attachments/294527468608552961/567413089356611584/logo_leviath_style.png");
        Logger.getLogTextChannel().sendMessage(leaveLog.build()).queue();
    }
}
