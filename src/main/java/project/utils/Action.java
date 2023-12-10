package project.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.configuration.Configuration;

public class Action {

    private WebDriver driver;

    public Action(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        String url = (String) Configuration.getGlobalValue("url");
        if (url == null || url.isEmpty()) {
            throw new RuntimeException("URL is not specified in the configuration.");
        }


        driver.get(url);
        driver.manage().window().maximize();
    }

    public void close(){
        if (driver != null){
            driver.quit();
        }
    }

    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void typeText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }
    public String getLocalUsername() {
        return (String) Configuration.getLocalValue("username");
    }

    public String getLocalPassword() {
        return (String) Configuration.getLocalValue("password");
    }
}
