package project.configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Configuration {
    private static Map<String, Object> globalConfig;
    private static Map<String, Object> localConfig;

    static {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Load global configuration
            JsonNode globalNode = objectMapper.readTree(new File("resources/global-config.json"));
            globalConfig = objectMapper.convertValue(globalNode, Map.class);

            // Load local configuration
            JsonNode localNode = objectMapper.readTree(new File("resources/local-config.json"));
            localConfig = objectMapper.convertValue(localNode, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Error loading JSON configuration", e);
        }
    }
    public static Object getGlobalValue(String key) {
        return globalConfig.get(key);
    }
    public static Object getLocalValue(String key) {
        return localConfig.get(key);
    }
}
