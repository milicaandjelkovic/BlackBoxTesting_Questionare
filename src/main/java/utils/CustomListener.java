package utils;

import org.testng.*;

import java.util.Set;

public class CustomListener extends WebDriverUtils implements ITestListener{
    public void onTestFailure(ITestResult result) {
        System.out.println("Test FAILED!");
        failedTestScreenshot(result.getTestName());
    }

}