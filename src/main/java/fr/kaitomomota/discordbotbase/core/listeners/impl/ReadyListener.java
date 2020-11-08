package fr.kaitomomota.discordbotbase.core.listeners.impl;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {
	
	@Override
	public void onReady(ReadyEvent event) {
		System.out.println("I AM READY !!!!! (ReadyListener)");
	}

}
