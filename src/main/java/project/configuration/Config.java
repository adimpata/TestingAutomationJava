package project.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {


    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading config properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
