package com.mmtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    static WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    WebElement find(By locator) {
        return driver.findElement(locator);
    }

    void click(By locator) {
        find(locator).click();
    }

    String getText(By locator) {
        String text = find(locator).getText();
        System.out.println("Text = " + text);
        return text;
    }


}
