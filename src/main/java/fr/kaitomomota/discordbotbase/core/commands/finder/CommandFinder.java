package fr.kaitomomota.discordbotbase.core.commands.finder;

import java.util.Arrays;
import java.util.stream.Collectors;

import fr.kaitomomota.discordbotbase.DiscordBot;
import fr.kaitomomota.discordbotbase.core.commands.ICommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public class CommandFinder {
	
	// Instance
	public static CommandFinder instance = new CommandFinder();
			
	public void findCommandAndExecute(MessageChannel channel, Message message, User user, Member member, Guild guild) {
		
		// Parts of command
		String[] split = message.getContentRaw().split(" ");
			
		// Name command String
		String cmd = split[0].substring(1).toLowerCase();
			
		// Arguments
		StringBuilder sb = new StringBuilder(); 
		for(String str : split) {
			if (str.equals(split[0])) { continue; }
			sb.append(str + " ");
		}
		
		String[] args = new String[0];
		
		if (!(sb.toString().isEmpty())) {
			args = sb.toString().split(" ");
		}
		
		// Search of the command:
		 
		ICommand command = DiscordBot.getInstance().getCommandManager().getCommands().stream().filter((commande) -> Arrays.asList(commande.getNames()).stream().map(String::toLowerCase).collect(Collectors.toList()).contains(cmd)).findFirst().orElse(null);
		if (command == null) { return; }	
		
		// Command Execution
		command.execute(channel, args, user, member, message, guild);
	
	}

}
