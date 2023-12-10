package DemoTestNG;

import com.mmtest.utilities.MmTestValue;
import org.testng.annotations.*;

@Test(groups = "smoke")
public class ConfigurationAnnotations_2_ListBox {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("                (4) Execute @BeforeMethod 2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("                (4) Execute @AfterMethod 2");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("            (3) Execute @BeforeClass 2");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("            (3) Execute @AfterClass 2");
    }

    public void test3_BootstrapListBox() {
        System.out.println("                    (5) Test method 3: Bootstrap List Box2");
    }

    public void test4_JQueryListBox() {
        System.out.println("                    (5) Test method 4: JQuery List Box2");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("        (2) Execute @BeforeTest 2");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("        (2) Execute @AfterTest 2");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("    (1) Execute @BeforeSuite 2");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("    (1) Execute @AfterSuite 2");
    }

    @BeforeGroups(groups = {"regression", "smoke"})
    public void beforeGroups() {
        System.out.println("            (3a) Execute @BeforeGroups 2 - flag = " + ++MmTestValue.flag);
    }

    @AfterGroups(groups = {"regression", "smoke"})
    public void afterGroups() {
        System.out.println("            (3a) Execute @AfterGroups 2 - flag = " + --MmTestValue.flag);
    }
}
