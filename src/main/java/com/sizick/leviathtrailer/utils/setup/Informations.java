package com.sizick.leviathtrailer.utils.setup;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;

/**
 * The MIT License (MIT)
 * Created on 25/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class Informations {

    public static void setupInformations(Guild guild) {
        EmbedBuilder informationEmbed = new EmbedBuilder();
        informationEmbed.setTitle("Leviath - Informations")
                .setColor(0xFF0000)
                .setDescription("Présentation de l'équipe Leviath:\n\n" +
                        "**Gérant**: " + guild.getMemberById("294496473469550594").getAsMention() +
                        "\n**Responsable Commandes**: " + guild.getMemberById("310115568810328066").getAsMention() + " , "
                        + guild.getMemberById("198373554344034305").getAsMention() +
                        "\n**Responsable Partenaires**: " + guild.getMemberById("305310485992177665").getAsMention() + " , "
                        + guild.getMemberById("170281988056547329").getAsMention() +
                        "\n**Responsable Technique**: " + guild.getMemberById("282676542017110026").getAsMention() +
                        "\n\nVoici quelques informations importantes et/ou utiles à savoir:\n")
                .addField("Site web", "En construction", false)
                .addField("Youtube (Nos créations)", "https://youtube.com/c/LeviathCréations", false)
                .addField("Twitter (Annonces)", "https://twitter.com/LeviathCorp", false)
                .addField("Discord", "https://discord.gg/8nenbtS", false)
                .setFooter("Leviath Corporation", "https://cdn.discordapp.com/attachments/294527468608552961/567413089356611584/logo_leviath_style.png");
        guild.getTextChannelById("566382252993413120").sendMessage(informationEmbed.build()).queue();
    }
}
