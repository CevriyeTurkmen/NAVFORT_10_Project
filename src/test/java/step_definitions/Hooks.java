package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Browser_Util;
import utilities.Driver;

public class Hooks {
    @Before(value = "@smoke")
    public void init() {
        System.out.println("This is running before every step definitions");
    }

    @After
    public void teardownScenario(Scenario scenario) {
        {

            if (scenario.isFailed()) {

                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());

            }


            Driver.closeDriver();
        }

    }
}
