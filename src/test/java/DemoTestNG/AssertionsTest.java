package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    @Test
    public void testSingleCheckbox() {
        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.findElement(By.id("isAgeSelected")).click();

//        Assert.assertEquals(driver.findElement(By.id("txtAge")).getText(), "Checked");
        Assert.assertTrue(driver.findElement(By.id("txtAge")).getText().equals("Checked"), "something is wrong");

    }

    @Test
    public void testRadioButtons() {
        driver.findElement(By.linkText("Radio Buttons Demo")).click();
        driver.findElement(By.xpath("//input[@value='Male' and @name='gender']")).click();
        driver.findElement(By.xpath("//input[@value='15 - 50']")).click();
        driver.findElement(By.xpath("//button[text()='Get values']")).click();

        Assert.assertEquals(driver.findElement(By.className("genderbutton")).getText(), "Male", "sth is wrong 1");
        Assert.assertEquals(driver.findElement(By.cssSelector(".groupradiobutton")).getText(), "15 - 50", "sth is wrong 2");
    }

    @Test
    public void testRadioButtonsSoftAssert() {
        driver.findElement(By.linkText("Radio Buttons Demo")).click();
        driver.findElement(By.xpath("//input[@value='Male' and @name='gender']")).click();
        driver.findElement(By.xpath("//input[@value='15 - 50']")).click();
        driver.findElement(By.xpath("//button[text()='Get values']")).click();

        softAssert.assertEquals(driver.findElement(By.className("genderbutton")).getText(), "Male1", "sth is wrong 1");
        softAssert.assertEquals(driver.findElement(By.cssSelector(".groupradiobutton")).getText(), "15 - 50", "sth is wrong 2");
        softAssert.assertAll("test softAssert");
    }

}
