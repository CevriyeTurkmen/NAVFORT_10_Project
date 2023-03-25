package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.Browser_Util;
import utilities.ConfigurationReader;
import utilities.Driver;

import static utilities.Browser_Util.waitFor;
import static utilities.Browser_Util.waitForPresenceOfElement;

public class LogoutStepDefinitions {

    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();

    @Given("driver is on the login page by entering {string} and {string}")
    public void driver_is_on_the_login_page_by_entering_and(String username, String password) {
   Driver.getDriver().get(ConfigurationReader.getProperty("url"));
   loginPage.userNameInput.sendKeys(username);
   loginPage.passwordInput.sendKeys(password);
   loginPage.submitBtn.click();

    }

    @When("driver goes to the profile menu and clicks the button")
    public void driver_goes_to_the_profile_menu_and_clicks_the_button() {
        waitFor(5);
      loginPage.profile.click();
    }
    @When("driver displays logout button and clicks the button")
    public void driver_displays_logout_button_and_clicks_the_button() {
        waitFor(5);
       dashboardPage.logout.click();
    }
    @Then("driver lands on the login page")
    public void driver_lands_on_the_login_page() {
        waitFor(5);
       Assert.assertEquals("https://qa.navfort.com/user/login",Driver.getDriver().getCurrentUrl());
    }


    @Given("sales manager is on the login page by entering {string} and {string}")
    public void sales_manager_is_on_the_login_page_by_entering_and(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.submitBtn.click();
    }
    @When("sales manager goes to the profile menu and clicks the button")
    public void sales_manager_goes_to_the_profile_menu_and_clicks_the_button() {
        waitFor(5);
        loginPage.profile.click();
    }
    @When("sales manager displays logout button and clicks the button")
    public void sales_manager_displays_logout_button_and_clicks_the_button() {
        waitFor(5);
        dashboardPage.logout.click();
    }
    @Then("sales manager lands on the login page")
    public void sales_manager_lands_on_the_login_page() {
        waitFor(5);
        Assert.assertEquals("https://qa.navfort.com/user/login",Driver.getDriver().getCurrentUrl());
    }

    @Given("store manager is on the login page by entering {string} and {string}")
    public void store_manager_is_on_the_login_page_by_entering_and(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.submitBtn.click();

    }
    @When("store manager goes to the profile menu and clicks the button")
    public void store_manager_goes_to_the_profile_menu_and_clicks_the_button() {
        waitFor(5);
        loginPage.profile.click();
    }
    @When("store manager displays logout button and clicks the button")
    public void store_manager_displays_logout_button_and_clicks_the_button() {
        waitFor(5);
        dashboardPage.logout.click();
    }
    @Then("store manager lands on the login page")
    public void store_manager_lands_on_the_login_page() {
        waitFor(5);
        Assert.assertEquals("https://qa.navfort.com/user/login",Driver.getDriver().getCurrentUrl());
    }

    @When("user logs out")
    public void userlogsOut() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.userNameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.submitBtn.click();
        waitFor(5);
        loginPage.profile.click();
        waitFor(5);
        dashboardPage.logout.click();
    }


    @And("user clicks the step back button")
    public void userClicksTheStepBackButton() {

        Driver.getDriver().navigate().back();
    }

    @Then("user should not go to homepage")
    public void userShouldNotGoToHomepage() {
        waitFor(5);
        Assert.assertNotEquals("https://qa.navfort.com/",Driver.getDriver().getCurrentUrl());

    }


}


