package fr.kaitomomota.discordbotbase.core.commands.impl.utils;

import fr.kaitomomota.discordbotbase.core.commands.ICommand;
import fr.kaitomomota.discordbotbase.core.commands.categories.Category;
import fr.kaitomomota.discordbotbase.core.consts.Consts;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public class PrefixCommand implements ICommand {

	@Override
	public String[] getNames() {
		return new String[] {"prefix"};
	}

	@Override
	public void execute(MessageChannel channel, String[] args, User user, Member member, Message message, Guild guild) {
		channel.sendMessage("My prefix is: " + Consts.instance.prefix).queue();
	}

	@Override
	public Category getCategory() {
		return Category.UTILS;
	}

	@Override
	public String getUsage() {
		return "prefix";
	}

}
