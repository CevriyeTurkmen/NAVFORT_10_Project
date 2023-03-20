package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginStepDefinitions {

    LoginPage loginPage=new LoginPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://qa.navfort.com");
    }
    @When("Log in as a {string}")
    public void log_in_as_a(String usertype) {
        System.out.println( usertype+ " is on log in page");
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
    public void user_clicks_the_login_button() {
       loginPage.submitBtn.click();
    }
    @Then("user lands on the {string} page")
    public void user_lands_on_the_page(String page) throws InterruptedException {
        Thread.sleep(3000);
        String actual = loginPage.header.getText();
        String expected = page;
        Assert.assertEquals(expected,actual);
    }


}