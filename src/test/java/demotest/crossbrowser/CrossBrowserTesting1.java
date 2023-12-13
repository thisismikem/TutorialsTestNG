package demotest.crossbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class CrossBrowserTesting1 {
    WebDriver driver;
    AbstractDriverOptions driverOptions;

    @Parameters(value = {"Browser", "Version", "Platform"})
    @BeforeMethod
    void setup(String browser, String version, String platform) {
        String username = "maimao";
        String accessKey = "VHKvuiV22S9wAsASixr1ASt0PSTQoxkRhnTqKhSfqoBTNe8Vz4";
        String hub = "@hub.lambdatest.com/wd/hub";

        setDriverOptions(browser);

        driverOptions.setPlatformName(platform);
        driverOptions.setBrowserVersion(version);
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accessKey);
        ltOptions.put("project", "TestProject");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        driverOptions.setCapability("LT:Options", ltOptions);


        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + hub), driverOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.get("https://www.lambdatest.com/selenium-playground/");

    }

    void setDriverOptions(String browser) {

        if ("firefox".equals(browser)) {
            driverOptions = new FirefoxOptions();
        } else if ("chrome".equals(browser)) {
            driverOptions = new ChromeOptions();
        } else if ("edge".equals(browser)) {
            driverOptions = new EdgeOptions();
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

    @AfterMethod
    void afterMethod() {
        driver.quit();
    }
}
