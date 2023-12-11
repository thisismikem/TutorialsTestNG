package demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;


public class AppTest {
	WebDriver webDriver = new ChromeDriver();
	
	@BeforeClass
	void beforeEach() {
		WebDriverManager.chromedriver().setup();
	}

    @BeforeMethod
    void beforeMethod() {
        webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
    }

    @AfterMethod
    void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
    }

	@AfterClass
	void afterClass() throws InterruptedException {
		webDriver.close();
	}
	
	
    @Test
    public void testEmailAndPassword() {
        webDriver.findElement(By.id("email-input")).sendKeys("login@codility.com");;
        webDriver.findElement(By.id("password-input")).sendKeys("password");
        webDriver.findElement(By.id("login-button")).click();
    }

    @Test
    public void testEmailAndPasswordPass() {
        webDriver.findElement(By.id("email-input")).sendKeys("login@codility.com");
        webDriver.findElement(By.id("password-input")).sendKeys("password");
        webDriver.findElement(By.id("login-button")).click();
        assertEquals("Welcome to Codility", webDriver.findElement(By.xpath("//div[@class='message success']")).getText());
    }

    @Test
    public void testEmailAndPasswordFail() {
        webDriver.findElement(By.id("email-input")).sendKeys("unknown@codility.com");
        webDriver.findElement(By.id("password-input")).sendKeys("password");
        webDriver.findElement(By.id("login-button")).click();
        assertEquals("You shall not pass! Arr!", webDriver.findElement(By.xpath("//div[@class='message error']")).getText());
    }

    @Test
    public void testInvalidEmailAddress() {
        webDriver.findElement(By.id("email-input")).sendKeys("abc");
        webDriver.findElement(By.id("password-input")).sendKeys("password");
        webDriver.findElement(By.id("login-button")).click();
        assertEquals("Enter a valid email", webDriver.findElement(By.xpath("//div[@class='validation error']")).getText());
    }

    @Test
    public void testEmptyEmail() {
        webDriver.findElement(By.id("password-input")).sendKeys("password");
        webDriver.findElement(By.id("login-button")).click();
        assertEquals("Email is required", webDriver.findElement(By.xpath("//div[@class='validation error']")).getText());
    }

    @Test
    public void testEmptyPassword() {
        webDriver.findElement(By.id("email-input")).sendKeys("login@codility.com");
        webDriver.findElement(By.id("login-button")).click();
        assertEquals("Password is required", webDriver.findElement(By.xpath("//div[@class='validation error']")).getText());
    }

    @Test
    public void testTabEnter() {
        WebElement element = webDriver.findElement(By.id("email-input"));
        element.sendKeys("login@codility.com");
        element.sendKeys(Keys.TAB);
        element = webDriver.switchTo().activeElement();
        element.sendKeys("password");
        element.sendKeys(Keys.TAB);
        element = webDriver.switchTo().activeElement();
        element.sendKeys(Keys.ENTER);
        assertEquals("Welcome to Codility", webDriver.findElement(By.xpath("//div[@class='message success']")).getText());
    }
}


