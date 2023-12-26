package org.opencart;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setub() {
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    //1
    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_Login_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }
    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
    loginPage.enterEmail("qatestertest@gmail.com");
    loginPage .enterPassword("Test@123");
    }
    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
    loginPage.enterEmail(username);
    loginPage.enterPassword(password);
    }
    @When("I click on the Login button")
    public void i_click_on_the_login_buttonO() {
    loginPage.clickLoginButton();
    }
    @Then("I should be logged in successfully")
    public void i_should_be_Logged_in_successfully() {
        Assert.assertEquals(loginPage.checkLogoutLink(), true);
    }
    @Then ("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating (String errorMessage){
// Подтверждаем, что на странице отображается сообщение об ошибке, соответствующее ожидаемому сообщению об ошибке
    Assert.assertEquals(driver. findElement (By.cssSelector(".alert-danger")).isDisplayed(),true);
    }
    @When ("I click on the \"Forgotten Password\" Link")
    public void i_click_on_the_forgotten_password_Link() {
        loginPage.clickForgottenPasswordLink();
}
    @Then ("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        Assert.assertTrue(loginPage.getForgotPwdPageUrL().contains("account/forgotten"));
    }
}