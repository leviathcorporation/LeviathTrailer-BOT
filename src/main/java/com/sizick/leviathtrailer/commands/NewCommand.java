package com.sizick.leviathtrailer.commands;

import com.sizick.leviathtrailer.utils.LeviathRole;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

/**
 * The MIT License (MIT)
 * Created on 16/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class NewCommand implements Command {

    @Override
    public void execute(Message message, Member member) {
        if(message.getContentRaw().equalsIgnoreCase("-new")) {
            message.delete().queue();
            Guild guild = message.getGuild();

            // On log l'ouverture d'un ticket de commande.
            EmbedBuilder logOrderEmbed = new EmbedBuilder();
            logOrderEmbed.setTitle("Leviath - Trailer Makers")
                    .setColor(0xFF0000)
                    .setDescription(member.getAsMention() + " à lancé une procédure pour passé commande.")
                    .setFooter("Leviath Corporation", "https://cdn.discordapp.com/attachments/294527468608552961/567413089356611584/logo_leviath_style.png");
            guild.getTextChannelById("566231691337662476").sendMessage(logOrderEmbed.build()).queue();

            // On créer le channel.
            guild.getController().createTextChannel("commande-" + member.getUser().getName()).setParent(guild.getCategoryById("566401662193893427")).queue(textChannel -> {
                // On attribu les permission WRITE/READ à l'utilisateur qui à ouvert le ticket
                textChannel.putPermissionOverride(member).setAllow(Permission.MESSAGE_WRITE, Permission.MESSAGE_READ).queue();
                // On envoit un message automatique dans le channel créer afin d'informé l'utilisateur.
                EmbedBuilder orderEmbed = new EmbedBuilder();
                orderEmbed.setTitle("Leviath - Trailer Makers")
                        .setColor(0xFF0000)
                        .setDescription("Bonjour " + member.getAsMention() + " - ceci est une réponse automatique : \n" +
                                "S'il vous plait, veuillez nous communiquer toutes les informations de votre commande afin que nous puissions la traiter dans les plus bref délais.")
                        .setFooter("Leviath Corporation", "https://cdn.discordapp.com/attachments/294527468608552961/567413089356611584/logo_leviath_style.png");
                textChannel.sendMessage(orderEmbed.build()).queue();
            });

            // On ajoute le grade Client à l'utilisateur.
            message.getGuild().getController().addRolesToMember(member, LeviathRole.Client.getRoleById()).queue();

            // On sauvegarde la date de création dans la bdd pour la cloture de la commande.
        }
    }
}
