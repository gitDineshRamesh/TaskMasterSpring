package com.sample.usermanagement.UserManagement;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:build/reports/tests/cucumber/cucumber-report.html"},
        features = {"src/test/resources"}
)
public class CucumberTestRunner {

}
