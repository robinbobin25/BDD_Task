package com.epam.mykhailenko.task8.core.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Antonina_Mykhailenko on 28.10.2015.
 */
public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url) {
        this.driver.get(url);
    }
}
