package test.login;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.OfficialPage;
import test.BaseTestClass;
import utils.CustomListener;

@Listeners(CustomListener.class)
public class SuccessfulOfficialLogIn057 extends BaseTestClass {

    private WebDriver driver;
    private String username;
    private String password;

    @BeforeMethod
    public void setUpTest() {
        driver = setUpDriver();
        username = CommonStrings.OFFICIAL_USERNAME;
        password = CommonStrings.PASSWORD;
    }

    @Test
    public void SuccessfulOfficialLogIn(){
        LogInPage logInPage = new LogInPage(driver).open();

        OfficialPage officialPage = logInPage.typeUsername(username).typePassword(password).clickLogInButton2();
        Assert.assertTrue(officialPage.verifyOfficialPage(), "Url is not as expected!!!");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }
}
