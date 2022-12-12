package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePageClass{
    private final String changePasswordPageUrl = CommonStrings.CHANGEPASSWORD_PAGE_URL;
    private final By usernameTextFieldLocator = By.xpath("//div//form//table//td//input[@name='username']");
    private final By oldPasswordTextFieldLocator = By.xpath("//div//form//table//td//input[@name='sifra_stara']");
    private final By newPasswordTextFieldLocator = By.xpath("//div//form//table//td//input[@name='sifra_nova']");
    private final By changePasswordButtonLocator = By.xpath("//div//form//table//td//input[@name='promeni']");

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public ChangePasswordPage open(){
        openUrl(changePasswordPageUrl);
        return this;
    }

    public ChangePasswordPage typeUsernameYouHave(String username){
        WebElement usernameTextField = waitForWebElementToBeVisible(usernameTextFieldLocator, Time.TIME_SHORTER);
        clearAndTypeTextToWebElement(usernameTextField, username);
        return this;
    }

    public ChangePasswordPage typeOldPassword(String password){
        WebElement passwordTextField = waitForWebElementToBeVisible(oldPasswordTextFieldLocator, Time.TIME_SHORTER);
        clearAndTypeTextToWebElement(passwordTextField, password);
        return this;
    }

    public ChangePasswordPage typeNewPassword(String password){
        WebElement passwordTextField = waitForWebElementToBeVisible(newPasswordTextFieldLocator, Time.TIME_SHORTER);
        clearAndTypeTextToWebElement(passwordTextField, password);
        return this;
    }

    //ako ostanemo na istoj strani nakon klika
    public ChangePasswordPage clickChangePasswordButtonNoProgress(){
        clickButton(changePasswordButtonLocator);
        return this;
    }

    public LogInPage clickChangePasswordButton(){
        clickButton(changePasswordButtonLocator);
        LogInPage logInPage = new LogInPage(driver);
        return logInPage;
    }




}
