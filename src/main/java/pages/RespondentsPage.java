package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.WebDriver;

public class RespondentsPage extends BasePageClass{

    private final String respondentsPageUrl = CommonStrings.RESPONDENT_PAGE_URL;
    public RespondentsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyRespondentsPage(){
        return waitForUrlToChange(respondentsPageUrl, Time.TIME_SHORTER);
    }
}
