package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.LoginPage;
import resources.commonmethods;

  
public class StepDefinitions extends commonmethods {
	public WebDriver driver;
	LoginPage lp ;
	
	
	@Given("user is on NewTours home page")
	public void user_is_on_NewTours_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	   driver=initializeDriver(mbrowser);
	   driver.get(p.getProperty("MemberURL"));
	}
	
	@When("^user enters valid (.+) and (.+)$")
    public void user_enters_valid_and(String username, String password) throws Throwable {
		lp = PageFactory.initElements(driver, LoginPage.class);
		lp.enterUserName(username);
		lp.enterPwd(password);
        
    }


	@When("clicks submit button")
	public void clicks_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
	   lp.clickSubmit();
	}

	@Then("user gets success message on logging in successfully")
	public void user_gets_success_message_on_logging_in_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    lp.verifysuccessmsg();
	}
	
}
