package dev.kataray.discord.commands;

import dev.jsinco.discord.framework.console.ConsoleCommand;

public class TestCommand implements ConsoleCommand {

    @Override
    public String name() {
        return "testcommand";
    }

    @Override
    public void execute(String[] strings) {
        System.out.println("hi");
    }
}