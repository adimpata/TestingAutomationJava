package project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import project.configuration.Config;

public class Driver {
    public static WebDriver createDriver() {
        String browser = Config.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                return createChromeDriver();
            case "firefox":
                return createFirefoxDriver();
            case "ie":
            case "internetexplorer":
                return createInternetExplorerDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    private static WebDriver createChromeDriver() {
        String chromeDriverPath = Config.getProperty("chromeDriverPath");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        String firefoxDriverPath = Config.getProperty("firefoxDriverPath");
        System.out.println("Firefox driver path: " + firefoxDriverPath);
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
        return new FirefoxDriver();
    }

    private static WebDriver createInternetExplorerDriver() {
        return new InternetExplorerDriver();
    }
}
