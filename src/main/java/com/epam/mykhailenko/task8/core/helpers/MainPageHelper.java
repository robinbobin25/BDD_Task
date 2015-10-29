package com.epam.mykhailenko.task8.core.helpers;

import com.epam.mykhailenko.task8.core.pages.MainPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Antonina_Mykhailenko on 27.10.2015.
 */
public class MainPageHelper {

    private MainPage mainPage;
    private WebDriver driver;

    public MainPageHelper(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
    }

    public MainPageHelper navigateToMainPage() {
        mainPage.openPage("http://pn.com.ua/");
        return this;
    }

    public CategoryPageHelper selectCategory() {
        mainPage.clickOnCarCategory();
        return new CategoryPageHelper(driver);
    }
}
