package com.sizick.leviathtrailer.utils.setup;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * The MIT License (MIT)
 * Created on 25/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class Rules {

    public static void setupRules(TextChannel textChannel) {
        EmbedBuilder RULES_EMBED = new EmbedBuilder();
        RULES_EMBED.setTitle("Règlement - Leviath")
                .setColor(0xFF0000)
                .setDescription("Voici une liste de règles non exhaustive à respecter afin de garder une bonne entente.\n\n" +
                        "Le respect mutuel est une valeur importante.\n\n" +
                        "La provocation, la haine, et la discrimination d'une personnes sera suivi d'un bannissement de façon permanent du discord.\n\n" +
                        "Le spam, la pub pour d'autres serveurs discord peut être sanctionnable par la suppression du message jusqu'au bannissement de l'utilisateur.")
                .setFooter("Leviath Corporation", "https://cdn.discordapp.com/attachments/294527468608552961/567413089356611584/logo_leviath_style.png");
        textChannel.sendMessage(RULES_EMBED.build()).queue();
    }
}
