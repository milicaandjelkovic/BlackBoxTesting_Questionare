package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdministratorPage extends BasePageClass{

    private final String administratorPageUrl = CommonStrings.ADMINISTRATOR_PAGE_URL;

    private final By logOutButtonLocator = By.xpath("//div//a[@href='logout.php']");
    public AdministratorPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyAdministratorPage(){
        return waitForUrlToChange(administratorPageUrl, Time.TIME_SHORTER);
    }

    public LogInPage clickLogOutButton(){
        clickButton(logOutButtonLocator);
        LogInPage logInPage = new LogInPage(driver);
        return logInPage;
    }
}
