package com.epam.mykhailenko.task8.tests;

import com.epam.mykhailenko.task8.core.helpers.CategoryPageHelper;
import com.epam.mykhailenko.task8.core.helpers.MainPageHelper;
import com.epam.mykhailenko.task8.core.webdriver.WebDriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

/**
 * Created by Antonina_Mykhailenko on 29.10.2015.
 */
public class BDDTests {

    private MainPageHelper mainPageHelper;
    private CategoryPageHelper categoryPageHelper;
    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.createInstance();
        mainPageHelper = new MainPageHelper(driver);
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Given("I am on start page")
    public void I_am_on_start_page() {
        mainPageHelper.navigateToMainPage();
    }

    @When("I select category")
    public void I_select_category() {
        categoryPageHelper = mainPageHelper.selectCategory();
    }

    @And("I set minimum and maximum prices")
    public void I_set_minimum_and_maximum_prices() {
        categoryPageHelper.setPricesForFilter();
    }

    @Then("^I see results matching search parameters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void I_see_results_matching_search_parameters_and(int min, int max) {
        categoryPageHelper.verifyThatPriceFilterWorksCorrect(min, max);
    }

    @And("I select manufacturer")
    public void I_select_manufacturer() {
        categoryPageHelper.selectManufacturerName();
    }

    @Then("^the number of products equals to the number next to the manufacturer$")
    public void the_number_of_products_equals_to_the_number_next_to_the_manufacturer() {
        categoryPageHelper.verifyThatManufacturerFilterWorksCorrect();
    }

    @And("^product names begin with the selected products$")
    public void product_names_begin_with_the_selected_products() {
        categoryPageHelper.verifyThatProductListContainsManufacturerName();
    }

//    @And("^I sort product by price$")
//    public void I_sort_product_by_price() {
//
//    }
//
//    @And("^I get the name of the cheapest product$")
//    public void I_get_the_name_of_the_cheapest_product() {
//
//    }
//
//    @And("^enter product name into the search field and submit$")
//    public void enter_product_name_into_the_search_field_and_submit() {
//
//    }
//
//    @Then("^Search Results Page has (\\d+) product$")
//    public void Search_Results_Page_has_product(int arg1) {
//
//    }
//
//    @And("^product name is equal to specified name$")
//    public void product_name_is_equal_to_specified_name() {
//
//    }

}
