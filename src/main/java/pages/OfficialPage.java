package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.WebDriver;

public class OfficialPage extends BasePageClass{

    private final String officialPageUrl = CommonStrings.OFFICIAL_PAGE_URL;
    public OfficialPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyOfficialPage(){
        return waitForUrlToChange(officialPageUrl, Time.TIME_SHORTER);
    }
}
