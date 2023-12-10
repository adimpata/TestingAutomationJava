package project.pageobjectweb;

import org.openqa.selenium.WebDriver;
import project.driver.Driver;
import project.utils.Action;

public class Base {
    public WebDriver driver;
    protected Action action;
    public Base(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(this.driver);
    }
    public void navigateToLoginPage() {
        action.open();
    }
    public void closePage() {
        action.close();
    }


}
