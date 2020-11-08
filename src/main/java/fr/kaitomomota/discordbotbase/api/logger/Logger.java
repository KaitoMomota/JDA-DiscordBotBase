package fr.kaitomomota.discordbotbase.api.logger;

import fr.kaitomomota.discordbotbase.core.consts.Consts;

public class Logger {

	public void printError(String message) {
		System.err.println("[" + Consts.instance.botname + "] ERROR: " + message);
	}
	
	public void printError(String botname, String message) {
		System.err.println("[" + botname + "] ERROR: " + message);
	}

	public void printRuntimeError(String message) {
		System.err.println("[RUNTIME] ERROR: " + message);
	}

	public void printRuntimeInfo(String message) {
		System.out.println("[RUNTIME] INFO: " + message);
	}
	
}
 