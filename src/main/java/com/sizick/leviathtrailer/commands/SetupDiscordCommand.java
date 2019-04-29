package com.sizick.leviathtrailer.commands;

import com.sizick.leviathtrailer.utils.setup.Informations;
import com.sizick.leviathtrailer.utils.setup.Order;
import com.sizick.leviathtrailer.utils.setup.Rules;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

/**
 * The MIT License (MIT)
 * Created on 26/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class SetupDiscordCommand implements Command {

    @Override
    public void execute(Message message, Member member) {
        String[] args = message.getContentRaw().split(" ");
        if(message.getContentRaw().startsWith("-setup")) {
            message.delete().queue();
            Guild guild = message.getGuild();
            if(args.length == 2) {
                if(args[1].equalsIgnoreCase("rules")) {
                    Rules.setupRules(guild.getTextChannelById("566382229048131594"));
                } else if(args[1].equalsIgnoreCase("infos")) {
                    Informations.setupInformations(guild);
                } else if(args[1].equalsIgnoreCase("order")) {
                    Order.setupOrder(guild.getTextChannelById("566381218107752449"));
                }
            }
        }
    }
}
