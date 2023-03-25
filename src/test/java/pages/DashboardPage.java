package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DashboardPage {

    public DashboardPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='javascript: void(0);']")
    public WebElement profile;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logout;

    @FindBy(xpath = "//a[.='Login']")
    public WebElement loginPage;



















}

