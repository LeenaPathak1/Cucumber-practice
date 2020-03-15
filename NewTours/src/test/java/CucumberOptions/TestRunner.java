package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"src/test/java/Features"}, plugin={"json:target/jsonReports/cucumber-report.json"}, glue="StepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {

}
