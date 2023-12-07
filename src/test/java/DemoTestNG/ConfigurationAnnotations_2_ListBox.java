package DemoTestNG;

import org.testng.annotations.*;

@Test(groups = "smoke")
public class ConfigurationAnnotations_2_ListBox {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("                (4) Execute before each test method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("                (4) Execute after each test method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("            (3) Execute before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("            (3) Execute after class");
    }

    public void test3_BootstrapListBox() {
        System.out.println("                    (5) Test method 3: Bootstrap List Box");
    }

    public void test4_JQueryListBox() {
        System.out.println("                    (5) Test method 4: JQuery List Box");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("        (2) Execute before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("        (2) Execute after test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("    (1) Execute before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("    (1) Execute after Suite");
    }

    @BeforeGroups(groups = {"regression", "smoke"})
    public void beforeGroups() {
        System.out.println("(0) Execute before Groups");
    }

    @AfterGroups(groups = {"regression", "smoke"})
    public void afterGroups() {
        System.out.println("(0) Execute after Groups");
    }
}
