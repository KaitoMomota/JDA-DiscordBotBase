package fr.kaitomomota.discordbotbase.core.commands.listeners;

import fr.kaitomomota.discordbotbase.DiscordBot;
import fr.kaitomomota.discordbotbase.core.commands.finder.CommandFinder;
import fr.kaitomomota.discordbotbase.core.consts.Consts;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter {
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if (event.getMessage().getContentStripped().startsWith(Consts.instance.prefix) && !(event.getAuthor().equals(DiscordBot.getInstance().getJDA().getSelfUser()))) {
			CommandFinder.instance.findCommandAndExecute(event.getChannel(), event.getMessage(), event.getMember().getUser(), event.getMember(), event.getGuild());
		}
	}
	

}
