package com.sizick.leviathtrailer.commands;


import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;

/**
 * The MIT License (MIT)
 * Created on 15/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class HelpCommand implements Command {

    @Override
    public void execute(Message message, Member member) {
        if(message.getContentRaw().equalsIgnoreCase("-help")) {

            // On delete la commande envoyée
            message.delete().queue();

            // On créer l'embed du message help
            EmbedBuilder help_embed = new EmbedBuilder();
            help_embed.setTitle("Leviath - Trailer Makers")
                    .setColor(0xFF0000)
                    .setDescription("Voici la liste des commandes disponibles :")
                    .addField("-help", "Affiche la liste des commandes disponibles", false)
                    .addField("-new", "Permet de passer une commande de Trailer ou autre", false)
                    .setFooter("Leviath Corporation", "https://cdn.discordapp.com/attachments/294527468608552961/567413089356611584/logo_leviath_style.png");

            // On envoit le message dans le channel ou a été envoyé la commande.
            message.getChannel().sendMessage(help_embed.build()).queue();
        }
    }
}
