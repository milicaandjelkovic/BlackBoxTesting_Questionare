package utils;

import data.Time;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class WebDriverUtils {
    private static WebDriver driver;
    public static WebDriver setUpWebDriver(){
        driver = WebDriverManager.chromedriver().create();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time.IMPLICIT_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time.PAGELOAD_TIMEOUT));

        driver.manage().window().maximize();

        return driver;
    }

    public static void quitWebDriver(WebDriver driver){
        driver.quit();
    }

    public void failedTestScreenshot(String testMethodName){
        Date d = new Date();
        String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("/Users/Milica/Downloads/BlackBoxTesting/.screenshot/"+ testMethodName + "_"
                    + TimeStamp +".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
