package com.mmtest.tests;

import com.mmtest.pages.BootstrapProgressBarPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProgressBarTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    BootstrapProgressBarPage progressBarPage = new BootstrapProgressBarPage();

    @Test
    public void testProgressBarPercentage() {
        progressBarPage = homePage.clickBootstrapProgressBar();
        progressBarPage.clickStartDownloadButton();
        String actualMessage = progressBarPage.getCompletedMessage();
        String actualPercentage = progressBarPage.getProgressBarPercentage();
        String expectedMessage = "Download completed!";
        String expectedPercentage = "1000%";

        softAssert.assertEquals(actualMessage, expectedMessage, "message is not correct");
        softAssert.assertEquals(actualPercentage, expectedPercentage, "percentage is not correct");
        softAssert.assertAll();
    }

}
