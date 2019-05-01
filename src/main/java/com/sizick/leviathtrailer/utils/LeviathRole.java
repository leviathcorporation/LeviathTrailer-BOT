package com.sizick.leviathtrailer.utils;

import com.sizick.leviathtrailer.LeviathTrailerBot;
import net.dv8tion.jda.core.entities.Role;

/**
 * The MIT License (MIT)
 * Created on 15/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public enum LeviathRole {

    Gerant("566231917176029191"),
    Administrateur("566233975224533002"),
    ResponsablePartenariat("566237252599152641"),
    ResponsableCommandes("566234828601688114"),
    Bot("566235646058954753"),
    MembreLeviath("566231658819223552"),
    Partenaire("566234683537489940"),
    ClientRegulier("566234749220421645"),
    Client("566233845326807040"),
    Ami("566235023204810752"),
    Newbie("566231661080215582");

    private String id;

    LeviathRole(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Role getRoleById() {
        return LeviathTrailerBot.getInstance().getJda().getRoleById(id);
    }
}
