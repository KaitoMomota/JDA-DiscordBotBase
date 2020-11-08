package fr.kaitomomota.discordbotbase.core.commands.impl.fun;

import fr.kaitomomota.discordbotbase.core.commands.ICommand;
import fr.kaitomomota.discordbotbase.core.commands.categories.Category;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public class HeyCommand implements ICommand {

	@Override
	public String[] getNames() {
		return new String[] {"hey", "hello"};
	}

	@Override
	public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild) {
		channel.sendMessage("Hello you !").queue();
	}

	@Override
	public Category getCategory() {
		return Category.FUN;
	}

	@Override
	public String getUsage() {
		return "hey";
	}

}
