package com.epam.mykhailenko.task8.core.helpers;

import com.epam.mykhailenko.task8.core.pages.CategoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Antonina_Mykhailenko on 27.10.2015.
 */
public class CategoryPageHelper {
    private CategoryPage categoryPage;
    private WebDriver driver;

    private int numberNearManufacturer;
    private String manufacturerName;

    public CategoryPageHelper(WebDriver driver) {
        this.driver = driver;
        categoryPage = new CategoryPage(driver);
    }

    public CategoryPageHelper selectManufacturerName() {
        manufacturerName = categoryPage.getOpelManufacturer().getText();
        numberNearManufacturer = categoryPage.parseProductQuantityToJustNumber();
        categoryPage.clickOnManufacturerFilter();
        return this;
    }

    public boolean isProductNameContainsManufacturerName() {
        for (WebElement productName : categoryPage.getProductNamesInProductList()) {
            if (productName.getText().contains(manufacturerName))
                return true;
        }
        return false;
    }

    public void verifyThatProductListContainsManufacturerName() {
        assertThat("Products don't have manufacturer name", isProductNameContainsManufacturerName(), is(true));
    }


    public void verifyThatManufacturerFilterWorksCorrect() {
        int quantityInProductList = categoryPage.parsePriceForJustNumbers().size();
        assertThat("Product number is not the same", quantityInProductList, is(numberNearManufacturer));
    }

    public CategoryPageHelper verifyThatPriceFilterWorksCorrect(int min, int max) {
        categoryPage.clickOnPriceFilter();
        assertThat("Filter by price doesn't  work correct. ", compareFirstAndLastPrices(min, max), is(true));
        return this;
    }

    public CategoryPageHelper setPricesForFilter() {
        categoryPage.clickOnMinPrice();
        categoryPage.clickOnMaxPrice();
        return this;
    }

    public boolean compareFirstAndLastPrices(int min, int max) {
        List<Integer> priceList = categoryPage.parsePriceForJustNumbers();
        int firstPrice = priceList.get(0);
        int lastPrice = priceList.get(9);

        if (firstPrice >= min && lastPrice <= max)
            return true;
        return false;
    }
}
