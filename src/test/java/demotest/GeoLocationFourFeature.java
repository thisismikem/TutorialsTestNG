package demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.emulation.Emulation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GeoLocationFourFeature {
    ChromeDriver driver;

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
//        driver.get("https://where-am-i.org/");
    }

    @Test
    void mockGeoLocation1() {

        Map coordinates = new HashMap() {{
            put("latitude", 25.1972);
            put("longitude", 55.2744);
            put("accuracy", 1);
        }};
        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        driver.get("https://where-am-i.org/");
        System.out.println("Address1: " + driver.findElement(By.id("address")).getText());
    }

    @Test
    void mockGeoLocation2() {

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(52.5043),
                Optional.of(13.4501),
                Optional.of(1)
        ));
        driver.get("https://my-location.org/");
        System.out.println("Address2: " + driver.findElement(By.id("address")).getText());
    }

    @Test
    void mockGeoLocation3() {

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        driver.get("https://my-location.org/");
        System.out.println("Address3: " + driver.findElement(By.id("address")).getText());
    }
}
