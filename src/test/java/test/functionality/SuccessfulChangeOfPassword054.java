package test.functionality;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.LogInPage;
import test.BaseTestClass;
import utils.CustomListener;

@Listeners(CustomListener.class)
public class SuccessfulChangeOfPassword054 extends BaseTestClass {
    private WebDriver driver;
    private String username;
    private String oldpassword;
    private String newpassword;

    @BeforeMethod
    public void setUpTest(){
        driver = setUpDriver();
        username = CommonStrings.RESPONDENT3_USERNAME;
        oldpassword = CommonStrings.OLD_PASSWORD;
        newpassword = CommonStrings.NEW_PASSWORD;
    }

    @Test
    public void SuccessfulChangeOfPassword() throws Exception{
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver).open();

        LogInPage logInPage = changePasswordPage.typeUsernameYouHave(username).typeOldPassword(oldpassword).typeNewPassword(newpassword).clickChangePasswordButton();

        Assert.assertTrue(logInPage.verifyLogInPage(), "Url is not right!");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }


}
