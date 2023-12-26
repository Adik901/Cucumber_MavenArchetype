package org.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    //By Locators
    private By emailInputLocator = By.xpath ("//input[@name='email']");
    private By passwordInputLocator = By.xpath ("//input[@name='password']");
    private By LoginButtonLocator = By.xpath("//input[@type='submit']");
    private By forgottenPasswordLinkeLocator = By.linkText("Forgotten Password");
    private By LogoutLinkLocator = By.linkText("Logout");

    // Constructor
    public LoginPage (WebDriver driver) {
        this.driver = driver;

    }

    // Methods / ACTION
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }
    public void enterPassword (String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(LoginButtonLocator);
        loginButton.click();
    }
    public void clickForgottenPasswordLink () {
        WebElement forgottenPasswordLink = driver.findElement(forgottenPasswordLinkeLocator);
        forgottenPasswordLink.click();
    }
    public boolean checkForgotPwdLink () {
        return driver. findElement (forgottenPasswordLinkeLocator).isDisplayed();
    }
    public boolean checkLogoutLink () {
        return driver.findElement(LogoutLinkLocator).isDisplayed();
    }
    public void Login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
    public String getForgotPwdPageUrL() {
        String forgotPwdPageUrl = driver.getCurrentUrl();
        return forgotPwdPageUrl;
    }
}
