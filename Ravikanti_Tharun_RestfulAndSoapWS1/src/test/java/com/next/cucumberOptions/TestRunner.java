package com.next.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources", // Specify the path to your feature files
    glue = "stepdefinitions",         // Specify the package where your step definitions are
    plugin = {"pretty", "html:target/cucumberReport.html", "json:target/cucumberjson-report.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}


