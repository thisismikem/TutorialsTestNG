package demotest.crossbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting2 {
    WebDriver driver;

    @Parameters(value = {"Browser"})
    @BeforeMethod
    void setup(String browser) {
        setDriver(browser);
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    void setDriver(String browser) {
        if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        } else if ("chrome".equals(browser)) {
            driver = new ChromeDriver();
        } else if ("edge".equals(browser)) {
            driver = new EdgeDriver();
        } else
            throw new RuntimeException("No driver found");
    }

    @Test
    void testDropdown() {
        driver.findElement(By.linkText("Select Dropdown List")).click();
        WebElement findDropdown = driver.findElement(By.id("select-demo"));
        Select dayDropdown = new Select(findDropdown);
        dayDropdown.selectByVisibleText("Saturday");
    }

    @Test
    void testDragAndDrop() {
        driver.findElement(By.linkText("Drag and Drop")).click();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();

    }

}
