package project.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapElementJson {

    private static final Map<String, By> elementMap = new HashMap<>();

    static {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("resources/element-map.json");

            if (!file.exists()) {
                throw new IOException("Element map file not found");
            }

            JsonNode rootNode = objectMapper.readTree(file);

            if (rootNode == null) {
                throw new IOException("Error reading element map file");
            }

            rootNode.fields().forEachRemaining(entry -> {
                String key = entry.getKey();
                JsonNode locatorNode = entry.getValue();
                String type = locatorNode.get("type").asText();
                String value = locatorNode.get("value").asText();

                By by;
                switch (type.toLowerCase()) {
                    case "id":
                        by = By.id(value);
                        break;
                    case "name":
                        by = By.name(value);
                        break;
                    case "xpath":
                        by = By.xpath(value);
                        break;
                    case "css":
                    case "cssselector":
                        by = By.cssSelector(value);
                        break;
                    case "tagname":
                        by = By.tagName(value);
                        break;
                    case "class":
                    case "classname":
                        by = By.className(value);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported locator type: " + type);
                }
                elementMap.put(key, by);
            });
        } catch (IOException e) {
            throw new RuntimeException("Error loading element map", e);
        }
    }

    public static By getLocator(String key) {
        return elementMap.get(key);
    }
}
