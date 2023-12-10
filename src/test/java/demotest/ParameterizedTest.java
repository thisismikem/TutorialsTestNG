package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {

    WebDriver driver;

    @Parameters("URL")
    @BeforeClass
    public void setUp(String url) {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Parameters({"Task", "TestResult"})
    @Test
    public void testFileDownload(String task, String testResult) {
        driver.findElement(By.linkText("File Download")).click();
        driver.findElement(By.id("textbox")).sendKeys(task + " Execution: " + testResult);
        driver.findElement(By.id("create")).click();
        driver.findElement(By.id("link-to-download")).click();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
