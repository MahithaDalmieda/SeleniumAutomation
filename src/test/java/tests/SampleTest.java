package tests;

import base.BaseTest;

import org.testng.annotations.Test;
import pageEvents.HomePageEvents;
import utils.DataProviderUtil;

import java.util.Map;

public class SampleTest extends BaseTest {

    @Test(dataProvider = "testData1", dataProviderClass = DataProviderUtil.class)
    public void loginAndVerify(Map<String, String> testDetails) {
        logger.info("Signing in");
        HomePageEvents homePageEvents = new HomePageEvents();
        homePageEvents.signIn2()
                .verifyIfLoginPageIsLoaded()
                .login(testDetails.get("email"), testDetails.get("password"));
    }

}
