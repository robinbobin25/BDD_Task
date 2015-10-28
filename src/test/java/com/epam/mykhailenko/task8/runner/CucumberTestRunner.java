package com.epam.mykhailenko.task8.runner;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

/**
 * Created by Antonina_Mykhailenko on 28.10.2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = {},
        format = {"pretty", "html:target/cucumber-report/cucumber.html"},
        glue = "core/stepdefs",
        features = "features")
public class CucumberTestRunner {

}
