package pageEvents;

import base.BaseTest;
import org.testng.Assert;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents extends BaseTest {

    ElementFetch element = new ElementFetch();

    public LoginPageEvents verifyIfLoginPageIsLoaded() {
        Assert.assertTrue(element.getWebElement("XPATH", LoginPageElements.LoginButton).isDisplayed(), "Element not found");
        return this;
    }

    public LoginPageEvents enterUserName(String email) {
        //logger.info("Enter user name");
        element.getWebElement("XPATH", LoginPageElements.Email).sendKeys(email);
        return this;
    }

    public LoginPageEvents enterPassword(String password) {
        element.getWebElement("XPATH", LoginPageElements.Password).sendKeys(password);
        return this;
    }

    public void login(String email, String password) {
        enterUserName(email).enterPassword(password).clickOnLogin();
    }

    public void clickOnLogin() {
        element.getWebElement("XPATH", LoginPageElements.LoginButton).click();
    }
}
