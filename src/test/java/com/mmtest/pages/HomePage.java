package com.mmtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "Bootstrap Progress bar")
    private WebElement bootstrapProgressBar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public BootstrapProgressBarPage clickBootstrapProgressBar() {
        bootstrapProgressBar.click();
        return new BootstrapProgressBarPage(driver);
    }

}
