package com.epam.mykhailenko.task8.core.pages;

import com.epam.mykhailenko.task8.core.utils.Waiters.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.epam.mykhailenko.task8.core.utils.Waiters.Waiters.waitForVisibilityOf;

/**
 * Created by Antonina_Mykhailenko on 27.10.2015.
 */
public class CategoryPage extends AbstractPage {

    public CategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /* for price filter */
    @FindBy(css = "[href$='?fp1=100000']")
    private WebElement minPrice;

    @FindBy(css = ".is_empty_items [href$='?fp1=100000&fp2=150000']")
    private WebElement maxPrice;

    @FindBy(css = "[href$='?fp1=100000&fp2=150000&sort=price']")
    private WebElement priceFilter;

    @FindBy(css = ".price strong")
    private List<WebElement> priceListAfterFilter;

    /* for manufacturer filter */
    @FindBy(css = "[href$='?fo=2526']")
    private WebElement opelManufacturer;

    @FindBy(css = "div:nth-child(5) > div.is_empty_items > i:nth-child(27)")
    private WebElement opelCarsQuantity;

    @FindBy(css = "div.name a")
    private List<WebElement> productNamesInProductList;


    public int parseProductQuantityToJustNumber() {
        String stringOpelNumber = getOpelCarsQuantity().getText().trim().replaceAll("\\D", "");
        int intOpelNumber = Integer.parseInt(stringOpelNumber);
        System.out.println(intOpelNumber);
        return intOpelNumber;
    }

    public void clickOnManufacturerFilter(){
        getOpelManufacturer().click();
    }

    public List<Integer> parsePriceForJustNumbers() {
        String priceNumber;
        int intPrice;
        List<Integer> priceList = new ArrayList<Integer>();
        for (WebElement price : priceListAfterFilter){
            priceNumber = price.getText().trim().replaceAll("\\D", "");
            intPrice = Integer.parseInt(priceNumber);
            priceList.add(intPrice);
        }
        return priceList;
    }

    public void clickOnMinPrice(){
        waitForVisibilityOf(driver, getMinPrice());
        getMinPrice().click();
    }

    public void clickOnMaxPrice(){
        waitForVisibilityOf(driver, getMaxPrice());
        getMaxPrice().click();
    }

    public void clickOnPriceFilter(){
        getPriceFilter().click();
    }

    public WebElement getMinPrice() {
        return minPrice;
    }

    public WebElement getMaxPrice() {
        return maxPrice;
    }

    public WebElement getPriceFilter() {
        return priceFilter;
    }

    public WebElement getOpelManufacturer() {
        return opelManufacturer;
    }

    public WebElement getOpelCarsQuantity() {
        return opelCarsQuantity;
    }

    public List<WebElement> getProductNamesInProductList() {
        return productNamesInProductList;
    }

}













