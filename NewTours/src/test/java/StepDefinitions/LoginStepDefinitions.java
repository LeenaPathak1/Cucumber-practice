package StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import BaseMethods.CommonMethods;
import PageObjects.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinitions extends CommonMethods {
	
	public static LoginPage lp;
	
	@Given("^Member is on NewTours home page$")
	public void member_is_on_NewTours_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		logger = report.createTest("Login to NewTours");
		 driver=CommonMethods.initializeBrowser(memurl);
	}
	
	@When("^user enters valid (.+) and (.+) to login$")
    public void user_enters_valid_and_to_login(String username, String password) throws Throwable {
		 lp = new LoginPage(driver);
		   lp.enterUserName(username);
		   lp.enterPassword(password);
		   logger.info("entered username"+username+" and password as "+password);
    }

	@When("^user clicks submit$")
	public void user_clicks_submit() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  lp.clickSubmit();
	}

	@Then("^user is logged in and gets success message$")
	public void user_is_logged_in_and_gets_success_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    lp.verifyLoginSuccess(driver);
	    logger.pass("Member logged in successfully");
	}

	
}
