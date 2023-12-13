package com.mmtest.tests;

import com.mmtest.pages.BasePage;
import com.mmtest.pages.HomePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;
    private final String AUT_URL = "https://www.lambdatest.com/selenium-playground/";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(AUT_URL);

//        basePage = new BasePage(driver);

        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void takeScreenshotForFailure(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/"
                    + testResult.getName() + "_" + timeStamp + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
