package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersTest {
    WebDriver driver;

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider(name = "myTestProvider")
    Object[][] ajaxData() {
        Object[][] data = new Object[2][2];
        data[0][0] = "James Lee";
        data[0][1] = "Test James Lee";
        data[1][0] = "Jane Lee";
        data[1][1] = "Test Jane Lee";

        return data;
    }

    @Test(dataProvider = "myTestProvider")
    void testAjaxForm(String name, String comment) {
        System.out.println("Name: " + name);
        System.out.println("comment: " + comment);

        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        driver.findElement(By.id("title")).sendKeys(name);
        driver.findElement(By.id("description")).sendKeys(comment);
        driver.findElement(By.id("btn-submit")).click();
    }

    @Test(dataProviderClass = DataProviderOnly.class, dataProvider = "input-provider")
    void test(String name, String email, int inputNumber) {
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("inputEmail4")).sendKeys(email);
    }

}
