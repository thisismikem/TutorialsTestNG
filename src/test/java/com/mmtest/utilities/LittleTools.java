package com.mmtest.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LittleTools {

    public static int flag = 0;

    public static void checkDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

}
