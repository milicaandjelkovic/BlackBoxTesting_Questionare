package test.login;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.PollCreatorPage;
import test.BaseTestClass;
import utils.CustomListener;

@Listeners(CustomListener.class)
public class SuccessfulPollCreatorLogIn058 extends BaseTestClass {
    private WebDriver driver;
    private String username;
    private String password;

    @BeforeMethod
    public void setUpTest(){
        driver = setUpDriver();
        username = CommonStrings.POLLCREATOR_USERNAME;
        password = CommonStrings.PASSWORD;
    }

    @Test
    public void SuccessfulPollCreatorLogIn(){
        LogInPage logInPage = new LogInPage(driver).open();

        PollCreatorPage pollCreatorPage = logInPage.typeUsername(username).typePassword(password).clickLogInButton1();
        Assert.assertTrue(pollCreatorPage.verifyPollCreatorPage(), "Url is not as expected!!!");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }
}
