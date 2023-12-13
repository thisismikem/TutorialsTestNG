package com.mmtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BootstrapProgressBarPage extends BasePage {

    @FindBy(id = "dwnBtn")
    private WebElement startDownloadButton;

    @FindBy(css = ".counter")
    private WebElement progressBarPercentage;

    @FindBy(xpath = "//p[contains(@class,'success')]")
    private WebElement completedMessage;

    public BootstrapProgressBarPage(WebDriver driver) {
        super(driver);
    }

    public void clickStartDownloadButton() {
        startDownloadButton.click();
    }

    public String getProgressBarPercentage() {
        waitElement(progressBarPercentage);
        return getText(progressBarPercentage);
    }

    public String getCompletedMessage() {
        waitElement(completedMessage);
        return getText(completedMessage);
    }
}
