package fr.kaitomomota.discordbotbase.api.data;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONConfig {
	
	public String token;
	public String botname;
	public String prefix;
	public String[] authors;
	
	
	// Register config.json
	public void register(File target) throws JsonGenerationException, JsonMappingException, IOException {
		new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(target, this);
	}
	
	// Parse config.json
	public static JSONConfig parseConfig(File target) throws IOException {
		return new ObjectMapper().readValue(target, JSONConfig.class);
	}

}
