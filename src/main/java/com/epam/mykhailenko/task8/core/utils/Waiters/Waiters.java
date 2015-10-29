package com.epam.mykhailenko.task8.core.utils.Waiters;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Antonina_Mykhailenko on 29.10.2015.
 */
public class Waiters {

    private static Wait<WebDriver> getWebDriverWait(WebDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public static void waitForVisibilityOf(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait = getWebDriverWait(driver);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
