package com.sizick.leviathtrailer.commands;

import com.sizick.leviathtrailer.LeviathTrailerBot;
import com.sizick.leviathtrailer.utils.LeviathRole;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

/**
 * The MIT License (MIT)
 * Created on 15/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class PromoteCommand implements Command {

    @Override
    public void execute(Message message, Member member) {
        if(member.getRoles().contains(LeviathRole.Gerant.getRoleById()) || member.getRoles().contains(LeviathRole.Administrateur.getRoleById()) ||
                member.getRoles().contains(LeviathRole.ResponsableCommandes.getRoleById())) {
            String[] args = message.getContentRaw().split(" ");
            if(args[0].equalsIgnoreCase("-promote")) {
                if(args.length == 2) {
                    if(args[1].contains("youtube.com/") || args[1].contains("youtu.be/")) {
                        message.delete().queue();
                        message.getGuild().getTextChannelById("566382391162044447").sendMessage("" + args[1]).complete();
                    } else {
                        message.delete().queue();
                        Message msg = message.getChannel().sendMessage(member.getAsMention() + " - Utilisez :\n -promote <lien de votre vidéo>").complete();
                        LeviathTrailerBot.getInstance().setTimeout(() -> {
                            msg.delete().complete();
                        }, 3000);
                    }
                } else {
                    message.delete().queue();
                    Message msg = message.getChannel().sendMessage(member.getAsMention() + " - Utilisez :\n -promote <lien de votre vidéo>").complete();
                    LeviathTrailerBot.getInstance().setTimeout(() -> {
                        msg.delete().complete();
                    }, 3000);
                }
            }

        }
    }
}
