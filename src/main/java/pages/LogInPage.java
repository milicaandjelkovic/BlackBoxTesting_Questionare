package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends BasePageClass{

    private final String logInPageUrl = CommonStrings.LOGIN_PAGE_URL;
    private final By usernameTextFieldLocator = By.name("username");
    private final By passwordTextFieldLocator = By.name("sifra");

    private final By logInButtonLocator = By.name("logovanje");

    private final By errorMessageLocator = By.xpath("//div//center//font//b");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public LogInPage open(){
        openUrl(logInPageUrl);
        return this;
    }

    public boolean verifyLogInPage(){
        return waitForUrlToChange(logInPageUrl, Time.TIME_SHORTER);
    }
    public LogInPage typeUsername(String username){
        WebElement usernameTextField = waitForWebElementToBeVisible(usernameTextFieldLocator, Time.TIME_SHORTER);
        clearAndTypeTextToWebElement(usernameTextField, username);
        return this;
    }

    public LogInPage typePassword(String password){
        WebElement passwordTextField = waitForWebElementToBeVisible(passwordTextFieldLocator, Time.TIME_SHORTER);
        clearAndTypeTextToWebElement(passwordTextField, password);
        return this;
    }

    //ako ostanemo na istoj strani nakon klika
    public LogInPage clickLogInButtonNoProgress(){
        clickButton(logInButtonLocator);
        return this;
    }

    //za uspesno logovanje na novu stranu
    public AdministratorPage clickLogInButton(){
        clickButton(logInButtonLocator);
        AdministratorPage administratorPage = new AdministratorPage(driver);
        return administratorPage;
    }
    //za uspesno logovanje na novu stranu
    public PollCreatorPage clickLogInButton1(){
        clickButton(logInButtonLocator);
        PollCreatorPage pollCreatorPage = new PollCreatorPage(driver);
        return pollCreatorPage;
    }
    //za uspesno logovanje na novu stranu
    public OfficialPage clickLogInButton2(){
        clickButton(logInButtonLocator);
        OfficialPage officialPage = new OfficialPage(driver);
        return officialPage;
    }
    //za uspesno logovanje na novu stranu
    public RespondentsPage clickLogInButton3(){
        clickButton(logInButtonLocator);
        RespondentsPage respondentsPage = new RespondentsPage(driver);
        return respondentsPage;
    }

    public String getErrorMessage(){
        WebElement element = waitForWebElementToBeVisible(errorMessageLocator,Time.TIME_SHORTER);
        return element.getText();
    }


}
