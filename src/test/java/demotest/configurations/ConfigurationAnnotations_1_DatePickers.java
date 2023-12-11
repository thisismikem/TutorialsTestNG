package demotest.configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class ConfigurationAnnotations_1_DatePickers {

    @Test(groups = "smoke")
    public void test1_BootstrapDatePicker() {
        System.out.println("                    (5) Test method 1: Bootstrap Date Picker1");
    }

    @Test(groups = {"regression", "e2e"})
    public void test2_JQueryDatePicker() {
        System.out.println("                    (5) Test method 2: JQuery Date Picker1");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("                (4) Execute @BeforeMethod 1");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("                (4) Execute @AfterMethod 1");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("            (3) Execute @BeforeClass 1");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("            (3) Execute @AfterClass 1");
    }
}