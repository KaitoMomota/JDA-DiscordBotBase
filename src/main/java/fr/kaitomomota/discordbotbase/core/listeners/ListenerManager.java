package fr.kaitomomota.discordbotbase.core.listeners;

import java.util.ArrayList;
import java.util.List;

import fr.kaitomomota.discordbotbase.core.listeners.impl.ReadyListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ListenerManager {
	
	List<ListenerAdapter> listeners = new ArrayList<>();
	
	public void registerListeners() {
		// Listeners goes here:
		listeners.add(new ReadyListener()); 
	}
	
	public List<ListenerAdapter> getListeners() {
		return listeners;
	}

}
