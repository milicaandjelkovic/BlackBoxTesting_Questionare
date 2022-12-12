package test.login;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AdministratorPage;
import pages.LogInPage;
import test.BaseTestClass;
import utils.CustomListener;

@Listeners(CustomListener.class)
public class SuccessfulAdministratorLogIn056 extends BaseTestClass {
    private WebDriver driver;
    private String username;
    private String password;


    @BeforeMethod
    public void setUpTest(){
        driver = setUpDriver();
        username = CommonStrings.ADMINISTRATOR_USERNAME;
        password = CommonStrings.PASSWORD;
    }

    @Test
    public void SuccessfulAdministratorLogIn(){
        LogInPage logInPage = new LogInPage(driver).open();

        AdministratorPage administratorPage = logInPage.typeUsername(username).typePassword(password).clickLogInButton();
        Assert.assertTrue(administratorPage.verifyAdministratorPage(), "Url is not as expected!!!");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }
}
