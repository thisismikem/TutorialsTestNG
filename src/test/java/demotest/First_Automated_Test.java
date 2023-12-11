package demotest;

import com.mmtest.utilities.LittleTools;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class First_Automated_Test {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        LittleTools.checkDriver();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void setupMethod() {
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testTableSortAndSearch() {
        driver.findElement(By.linkText("Table Sort & Search")).click();
        driver.findElement(By.xpath("//div[@id='example_filter']//input[@type='search']")).sendKeys("C. Kelly");
    }

    @Test(priority = 1)
    public void testBootStrapDatePicker() {
        driver.findElement(By.linkText("Bootstrap Date Picker")).click();
        driver.findElement(By.id("birthday")).sendKeys("06/07/2008");

    }
}
