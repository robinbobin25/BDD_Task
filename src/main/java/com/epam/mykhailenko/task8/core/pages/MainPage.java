package com.epam.mykhailenko.task8.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Antonina_Mykhailenko on 27.10.2015.
 */
public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1 a.main_page_link_catalog")
    private List<WebElement> categories;

    @FindBy(css = "[href='http://pn.com.ua/ct/3011/']")
    private WebElement carCategory;

    public void clickOnCarCategory(){
        carCategory.click();
    }

    public List<WebElement> getCategories() {
        return categories;
    }

    public WebElement getCarCategory() {
        return carCategory;
    }
}
