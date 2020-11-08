package fr.kaitomomota.discordbotbase.core.commands;

import java.util.ArrayList;
import java.util.List;

import fr.kaitomomota.discordbotbase.core.commands.impl.fun.HeyCommand;
import fr.kaitomomota.discordbotbase.core.commands.impl.utils.PrefixCommand;

public class CommandManager {
	
	private List<ICommand> commands = new ArrayList<>();
	
	public void registerCommands() {
		// Commands goes here:
			// FUNS
				commands.add(new HeyCommand());
			// UTILS
				commands.add(new PrefixCommand());
			// MOD
				
			// ADMIN
				
			// NSFW	
				
	}
	
	public List<ICommand> getCommands() {
		return commands;
	}

}
