package cucumberOptions;

import java.io.File;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features={"src/test/java/Features/Login.feature"}, plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}, glue="StepDefinitions")

public class TestRunner extends AbstractTestNGCucumberTests {

	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Stging");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
}
