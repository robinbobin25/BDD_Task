package com.epam.mykhailenko.task8.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Antonina_Mykhailenko on 27.10.2015.
 */
public class CategoryPage extends AbstractPage {

    public CategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "")
    private WebElement minPrice;

    @FindBy(css = "")
    private WebElement maxPrice;

    @FindBy(css = "")
    private WebElement productPrice;

    @FindBy(css = "")
    private WebElement priceFilter;
}
