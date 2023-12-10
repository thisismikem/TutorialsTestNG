package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GeoLocationGrid {
    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://where-am-i.org/");
    }

    @Test
    void testGeoLocation() {
        WebElement address = driver.findElement(By.id("address"));
        System.out.println("Address: " + address.getText());
    }
}
