package demotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTesting1 {
    WebDriver driver;

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void test1_JQueryDatePicker() {
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-date-picker-demo");
        System.out.println(Thread.currentThread().getId() + ": class 1 - JQuery Date Picker Page");
    }

    @Test
    void test2_DataListFilter() {
        driver.get("https://www.lambdatest.com/selenium-playground/data-list-filter-demo");
        System.out.println(Thread.currentThread().getId() + ": class 1 - Data List Filter Page");
    }


    @AfterMethod
    void quitBrowser() {
        driver.quit();
    }
}
