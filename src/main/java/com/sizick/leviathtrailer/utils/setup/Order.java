package com.sizick.leviathtrailer.utils.setup;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * The MIT License (MIT)
 * Created on 27/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class Order {

    public static void setupOrder(TextChannel textChannel) {
        EmbedBuilder orderEmbed = new EmbedBuilder();
        orderEmbed.setTitle("Leviath - Passer commande")
                .setColor(0xFF0000)
                .setDescription("Afin de passer une commande, veuillez avant tout vous renseigner sur nos tarifs via le lien suivant:\n\n" +
                        "https://docs.google.com/document/d/1jbuDBwiCOoLEhW5V-5UAJHhMFj4Gpn4dD_HBr3TBYYA/edit?usp=sharing\n\n" +
                        "Après consultation de nos tarifs, créez un ticket avec la commande `-new`, puis rendez-vous dans le channel qui a été créer.\n\n" +
                        "Veuillez Remplir le formulaire suivant:\n\n" +
                        "  - Type : Trailer/teaser/Montage PvP\n" +
                        "  - Durée : 30s/1m/1m30s/2m/+\n" +
                        "  - 3D : Oui/Non\n" +
                        "  - 2D : Oui/Non\n" +
                        "  - Séquence PvP : Oui/Non\n" +
                        "  - Musique imposée : Oui/Non\n\n" +
                        "Vous n'avez plus qu'à attendre un responsable commande qui va s'occuper de vous.")
                .setFooter("Leviath Corporation", "https://cdn.discordapp.com/attachments/294527468608552961/567413089356611584/logo_leviath_style.png");
        textChannel.sendMessage(orderEmbed.build()).queue();
    }
}
