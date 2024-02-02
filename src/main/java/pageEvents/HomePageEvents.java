package pageEvents;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageEvents extends BaseTest {


    @FindBy(xpath = "//span[normalize-space()='Log In']")
    WebElement loginButton;

    @FindBy(xpath = "//span[normalize-space()='Log In']")
    WebElement loginButton2;

    public HomePageEvents() {
        PageFactory.initElements(driver, this);
    }

    public LoginPageEvents signIn() {
        //logger.info("Signing in");
        loginButton.click();
        return new LoginPageEvents();
    }

    public LoginPageEvents signIn2() {
        //logger.info("Signing in");
        loginButton2.click();
        return new LoginPageEvents();
    }
}
