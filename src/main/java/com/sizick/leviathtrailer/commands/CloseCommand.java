package com.sizick.leviathtrailer.commands;

import com.sizick.leviathtrailer.utils.LeviathRole;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;

/**
 * The MIT License (MIT)
 * Created on 16/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class CloseCommand implements Command {

    @Override
    public void execute(Message message, Member member) {
        // Vérification si l'utilisateur qui envoie la commande est Gérant/Administrateur/Resp.Commandes
        if(member.getRoles().contains(LeviathRole.Gerant.getRoleById()) || member.getRoles().contains(LeviathRole.Administrateur.getRoleById()) ||
                member.getRoles().contains(LeviathRole.ResponsableCommandes.getRoleById())) {
            String[] args = message.getContentRaw().split(" ");
            if(args.length == 1) {

            } else if(args.length >= 2) {

            }
        }
    }
}
