package dev.kataray.discord.commands;

import dev.jsinco.discord.framework.commands.CommandModule;
import dev.jsinco.discord.framework.commands.DiscordCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

@DiscordCommand(name = "hello", description = "Says hello back :)", permission = Permission.ADMINISTRATOR, guildOnly = true)
public class HelloCommand implements CommandModule {

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("Hello ").queue();
    }

    @Override
    public List<OptionData> getOptions() {
        return List.of(
                new OptionData(OptionType.MENTIONABLE, "name", "The name to say hello to.", false)
        );
    }

}
