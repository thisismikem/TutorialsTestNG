package demotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTesting2 {
    WebDriver driver;

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    @Test(threadPoolSize = 3, invocationCount = 5)
    void test3_BootstrapAlert() {
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");
        System.out.println(Thread.currentThread().getId() + ": class 2 - Bootstrap Alert Page");
    }

    @Test
    void test4_DragAndDrop() {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        System.out.println(Thread.currentThread().getId() + ": class 2 - Drag and Drop Page");
    }


//    @AfterMethod
//    void quit() {
//        driver.quit();
//    }
}
