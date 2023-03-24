package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utilities.Browser_Util;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://qa.navfort.com");
    }

    @When("Log in as a {string}")
    public void log_in_as_a(String usertype) {
        System.out.println(usertype + " is on log in page");
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {

        loginPage.userNameInput.sendKeys(username);

    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {

        loginPage.passwordInput.sendKeys(password);
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() throws InterruptedException {
        loginPage.submitBtn.click();
        Thread.sleep(3000);
    }


    @Then("user lands on the {string} page")
    public void user_lands_on_the_page(String page) throws InterruptedException {

        Thread.sleep(3000);
        String actual = loginPage.header.getText();
        String expected = page;
        Assert.assertEquals(expected, actual);
    }


    @When("user enters invalid {string} and {string}")
    public void userEntersInvalidAnd(String username, String password) {
        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.submitBtn.click();
    }


    @Then("warning {string} should be displayed")
    public void warningShouldBeDisplayed(String message) throws InterruptedException {

        Thread.sleep(3000);

        String expected1 = message;
        String actual1 = loginPage.message.getText();
        Assert.assertEquals(expected1, actual1);

    }

    @Then("warning message should be displayed")
    public void warningMessageShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        String exp = "Please fill in this field.";
        String act = Driver.getDriver().findElement(By.name("_username")).getAttribute("validationMessage");
        Assert.assertEquals(exp, act);

    }

    @Then("warning different message should be displayed")
    public void warningDifferentMessageShouldBeDisplayed() throws InterruptedException {

        Thread.sleep(3000);
        String exp = "Please fill in this field.";
        String act = Driver.getDriver().findElement(By.name("_password")).getAttribute("validationMessage");
        Assert.assertEquals(exp, act);
    }

    @Then("user displays on his own {string}")
    public void userDisplaysOnHisOwn(String username) {

       Browser_Util.waitForVisibility(loginPage.profile, 5);
       String expectedProfile = username;
       String actualProfile = loginPage.profile.getText();
       Assert.assertEquals(expectedProfile, actualProfile);

    }

}