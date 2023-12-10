package project.pageobjectweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.configuration.Configuration;
import project.driver.Driver;
import project.utils.Action;
import project.utils.MapElementJson;

public class LoginPage extends Base {

    private By usernameField = MapElementJson.getLocator("username");
    private By passwordField = MapElementJson.getLocator("password");
    private By loginButton = MapElementJson.getLocator("loginButton");

    public LoginPage(WebDriver driver) {
        super(Driver.createDriver());
        this.action = new Action(driver);
    }


    public void enterUsername() {
        String username = (String) Configuration.getLocalValue("username");
        action.typeText(usernameField, username);

    }

    public void enterPassword() {
        String password = (String) Configuration.getLocalValue("password");
        action.typeText(passwordField, password);
    }

    public void clickLoginButton() {
        action.clickElement(loginButton);
    }
}
