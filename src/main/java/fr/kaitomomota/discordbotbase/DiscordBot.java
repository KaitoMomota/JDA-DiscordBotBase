package fr.kaitomomota.discordbotbase;

import java.io.File;
import java.io.IOException;
import java.util.EnumSet;

import javax.security.auth.login.LoginException;

import fr.kaitomomota.discordbotbase.api.data.JSONConfig;
import fr.kaitomomota.discordbotbase.api.logger.Logger;
import fr.kaitomomota.discordbotbase.core.commands.CommandManager;
import fr.kaitomomota.discordbotbase.core.commands.listeners.CommandListener;
import fr.kaitomomota.discordbotbase.core.consts.Consts;
import fr.kaitomomota.discordbotbase.core.listeners.ListenerManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class DiscordBot {
	
	// Instance of this class
	private static DiscordBot instance;
	
	// Logger
	private static Logger logger = new Logger();
	
	// JDA
	private JDA jda;
	
	// CommandManager
	private CommandManager commandManager = new CommandManager();
	
	// ListenerManager
	private ListenerManager listenerManager = new ListenerManager(); 
	
	public static void main(String[] args) {
		new DiscordBot().launchBot();
	}
	
	public DiscordBot() {
		instance = this;
	}

	
	// Launch the bot
	public void launchBot() {
		
		// Config
		File config = new File("config.json");
		
		// Token
		String token = "";
		
		if (!(config.exists())) {
			logger.printRuntimeError("Could not find config.json, creating default one..");
			JSONConfig jsonconfig = new JSONConfig();
			jsonconfig.authors = new String[]{"KaitoMomota", "KokichiOma"};
			jsonconfig.prefix = "INSERT YOUR PREFIX HERE";
			jsonconfig.token = "INSERT THE TOKEN OF YOUR BOT HERE";
			jsonconfig.botname = "INSERT THE NAME OF YOUR BOT HERE";
			try {
				jsonconfig.register(config);
			} catch (IOException e) {
				logger.printRuntimeError("Error while registering config.json, aborting..");
			}
			logger.printRuntimeInfo("config.json has been created, fill it with the right informataions of your bot, then restart me !");
			return;
		} else {
			try {
				JSONConfig jsonconfig = JSONConfig.parseConfig(config);
				if (jsonconfig.authors.length == 0 ) {
					logger.printRuntimeError("Error while parsing config.json, aborting..");
					return;
				}
				if (jsonconfig.prefix.length() != 1) {
					logger.printRuntimeError("Error while parsing config.json, aborting..");
					return;
				}
				Consts.instance.authors = jsonconfig.authors;
				Consts.instance.botname = jsonconfig.botname;
				Consts.instance.prefix = jsonconfig.prefix;
				token = jsonconfig.token;
			} catch (IOException e) {
				logger.printRuntimeError("Error while parsing config.json !");	
				return;
			}
		}
		
		JDABuilder bot = JDABuilder.createDefault(token);
		
		// CommandListener
		bot.addEventListeners(new CommandListener());
		
		// Register commands
		commandManager.registerCommands();
		
		// Register listeners
		listenerManager.registerListeners();
		listenerManager.getListeners().forEach((listener) -> bot.addEventListeners(listener));
		
		bot.addEventListeners(EnumSet.allOf(GatewayIntent.class));
		
		try {
			jda = bot.build();
			logger.printRuntimeInfo("Connected as " + jda.getSelfUser().getAsTag() + " !");
		} catch (LoginException e) {
			logger.printRuntimeError("The specified token is invalid, aborting..");
		}
		
	}
	
	public static DiscordBot getInstance() {
		return instance;
	}
	
	public JDA getJDA() {
		return jda;
	}
	
	public CommandManager getCommandManager() {
		return commandManager;
	}
	

}
