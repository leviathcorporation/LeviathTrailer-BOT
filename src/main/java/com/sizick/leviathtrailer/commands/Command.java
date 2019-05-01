package com.sizick.leviathtrailer.commands;


import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;

/**
 * The MIT License (MIT)
 * Created on 12/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public interface Command {
    void execute(Message message, Member member);
}
