package pageEvents;

import base.BaseTest;
import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents extends BaseTest {
    ElementFetch element = new ElementFetch();

    public LoginPageEvents signIn() {
        //logger.info("Signing in");
        element.getWebElement("XPATH", HomePageElements.LoginButton).click();
        return new LoginPageEvents();
    }

    public LoginPageEvents signIn2() {
        //logger.info("Signing in");
        element.getWebElement(HomePageElements.LoginButton2).click();
        return new LoginPageEvents();
    }
}
