package com.sizick.leviathtrailer.events;

import com.sizick.leviathtrailer.commands.Commands;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * The MIT License (MIT)
 * Created on 12/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public class CommandsListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        for(Commands commands : Commands.values()) {
            commands.getCommand().execute(e.getMessage(), e.getMember());
        }

    }
}
