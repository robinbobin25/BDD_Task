package com.epam.mykhailenko.task8.core.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Antonina_Mykhailenko on 28.10.2015.
 */
public class WebDriverFactory {

    private static final String BROWSER_TYPE = "FF";
    private static WebDriver driver;

    public static WebDriver createInstance() {
        switch (BROWSER_TYPE) {
            case "FF":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

}
