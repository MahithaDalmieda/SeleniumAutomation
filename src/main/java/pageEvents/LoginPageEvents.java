package pageEvents;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ElementFetch;

public class LoginPageEvents extends BaseTest {

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement loginButton;

    public LoginPageEvents() {
        PageFactory.initElements(driver, this);
    }

    public LoginPageEvents verifyIfLoginPageIsLoaded() {
        Assert.assertTrue(loginButton.isDisplayed(), "Element not found");
        return this;
    }

    public LoginPageEvents enterUserName(String email) {
        //logger.info("Enter user name");
        this.email.sendKeys(email);
        return this;
    }

    public LoginPageEvents enterPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public void login(String email, String password) {
        enterUserName(email).enterPassword(password).clickOnLogin();
    }

    public void clickOnLogin() {
        loginButton.click();
    }
}
