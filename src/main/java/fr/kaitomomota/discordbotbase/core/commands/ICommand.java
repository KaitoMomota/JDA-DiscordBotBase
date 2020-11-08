package fr.kaitomomota.discordbotbase.core.commands;

import fr.kaitomomota.discordbotbase.core.commands.categories.Category;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public interface ICommand {
	
    public String[] getNames();
	
	public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild);
	
	public Category getCategory();
	
	public String getUsage();
	
}
