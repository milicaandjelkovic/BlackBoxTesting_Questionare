package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.WebDriver;

public class PollCreatorPage extends BasePageClass{

    private final String pollCreatorPageUrl = CommonStrings.POLLCREATOR_PAGE_URL;
    public PollCreatorPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyPollCreatorPage(){
        return waitForUrlToChange(pollCreatorPageUrl, Time.TIME_SHORTER);
    }

}
