package com.sizick.leviathtrailer.events;

import com.sizick.leviathtrailer.utils.LeviathRole;
import com.sizick.leviathtrailer.utils.Logger;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * The MIT License (MIT)
 * Created on 26/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class JoinListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
          e.getGuild().getController().addRolesToMember(e.getMember(), LeviathRole.Newbie.getRoleById()).queue();
        EmbedBuilder joinLog = new EmbedBuilder();
        joinLog.setTitle("Leviath - Logs")
                .setColor(0xFF0000)
                .setDescription(e.getMember().getAsMention() + " a rejoint le serveur !")
                .setFooter("Leviath Corporation", "https://cdn.discordapp.com/attachments/294527468608552961/567413089356611584/logo_leviath_style.png");
        Logger.getLogTextChannel().sendMessage(joinLog.build()).queue();
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {

    }
}
