package project.tests;

import org.openqa.selenium.WebDriver;
import project.driver.Driver;
import project.pageobjectweb.LoginPage;

import static project.driver.Driver.createDriver;

public class WebPage {
        WebDriver driver;
        LoginPage loginPage;

    public WebPage() {
        this.driver = Driver.createDriver();
        this.loginPage = new LoginPage(driver);
    }

    public void openPage() {
            loginPage.navigateToLoginPage();
        }
        public  void login(){
            loginPage.enterUsername();
            loginPage.enterPassword();
            loginPage.clickLoginButton();
        }
        public  void closePage(){
            loginPage.closePage();
        }
}
