package cucumberOptions;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.Cucumber;

@CucumberOptions(features = "src/test/resources/features", 
glue = "stepDefinitions",
plugin = {"pretty", "html:target/cucumberReport.html", "json:target/cucumberjson-report.json"},
monochrome = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}

