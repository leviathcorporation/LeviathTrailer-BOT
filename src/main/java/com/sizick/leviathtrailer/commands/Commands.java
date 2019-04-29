package com.sizick.leviathtrailer.commands;

/**
 * The MIT License (MIT)
 * Created on 12/04/2019.
 * Copyright (c) 2019 @author Sizick
 */
public enum Commands {

    HELP(new HelpCommand()),
    PROMOTE(new PromoteCommand()),
    NEW(new NewCommand()),
    CLOSE(new CloseCommand()),
    SETUPDISCORD(new SetupDiscordCommand()),
    ;

    private Command command;

    Commands(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
