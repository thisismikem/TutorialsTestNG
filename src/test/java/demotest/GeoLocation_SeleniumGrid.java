package demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class GeoLocation_SeleniumGrid {
  public WebDriver driver;
  private String username = "maimao";
  private String accessKey = "VHKvuiV22S9wAsASixr1ASt0PSTQoxkRhnTqKhSfqoBTNe8Vz4";
  private String hub = "@hub.lambdatest.com/wd/hub";
  ChromeOptions driverOptions = new ChromeOptions();

  @BeforeClass
  public void setUp() {

    driverOptions.setPlatformName("Windows 11");
    driverOptions.setBrowserVersion("120");
    HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    ltOptions.put("username", username);
    ltOptions.put("accessKey", accessKey);
    ltOptions.put("project", "TestProject");
    ltOptions.put("selenium_version", "4.0.0");
    ltOptions.put("w3c", true);
    driverOptions.setCapability("LT:Options", ltOptions);

    try{
      driver = new RemoteWebDriver(new URL("https://" +
              username + ":" + accessKey + hub), driverOptions);
    }
    catch(MalformedURLException exc) {
      exc.printStackTrace();
    }
    driver.get("https://where-am-i.org/");
  }

  @Test
  public void testGeoLocation() {
    WebElement address = driver.findElement(By.id("address"));
    System.out.println("Address: " + address.getText());
  }
}
