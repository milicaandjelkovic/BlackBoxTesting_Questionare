package pages;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePageClass {
    protected WebDriver driver;

    public BasePageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void openUrl(String url){
        driver.get(url);
    }

    protected String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected boolean waitForUrlToChange(String url, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlToBe(url));
    }
    //da saceka da element bude vidljiv na mestu na kome se nalazi
    protected WebElement waitForWebElementToBeVisible(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForWebElementToBeVisible2(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //da upise tekst u web element
    protected void typeTextToWebElement(WebElement element, String text){
        waitForWebElementToBeVisible2(element, Time.TIME_SHORTER);
        element.sendKeys(text);
    }

    //da ocistimo string
    protected void clearTextFromWebElement(WebElement element){
        waitForWebElementToBeVisible2(element, Time.TIME_SHORTER);
        element.clear();
    }

    //metoda koja u sebi ima i metodu za brisanje i metodu za ispis
    protected void clearAndTypeTextToWebElement(WebElement element, String text){
        clearTextFromWebElement(element);
        typeTextToWebElement(element, text);
    }

    //da iskoristimo u metodi dole
    protected void clickOnWebElement(WebElement element){
        element.click();
    }
    //metoda koja radi klik
    protected void clickButton(By locator){
        WebElement element = waitForWebElementToBeVisible(locator,Time.TIME_SHORTER);
        clickOnWebElement(element);
    }

    protected String getTextFromWebElement(WebElement element){
        return element.getText();
    }

}
