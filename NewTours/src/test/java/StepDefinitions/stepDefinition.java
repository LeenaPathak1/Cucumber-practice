package StepDefinitions;

import org.openqa.selenium.WebDriver;

import BaseMethods.CommonMethods;
import PageObjects.HomePage;
import PageObjects.NewToursRegisterPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition extends CommonMethods {
	
	public static String email;
	public static NewToursRegisterPage ntr;
	public static HomePage hp;
	
	@Given("^Member is on NewTours Home page$")
	public void member_is_on_NewTours_Home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver=CommonMethods.initializeBrowser(memurl);
	}

	@When("^member clicks on Register link$")
	public void member_clicks_on_Register_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    hp = new HomePage(driver);
	    hp.clickRegister();
	}

	@When("^enters valid Firstname, Lastname, Phone, Email, Address, City, State, Postal code$")
	public void enters_valid_Firstname_Lastname_Phone_Email_Address_City_State_Postal_code() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		ntr = new NewToursRegisterPage(driver);
		ntr.enterFirstName("test");
		ntr.enterLastName("ai");
		ntr.enterphone("1232223232");
	    email = typeDynamicText("@yopmail.com");
	    ntr.enterEmail(email);
	    ntr.enterAddress("501 merritt 7");
	    ntr.enterCity("Norwalk");
	    ntr.enterState("CT");
	    ntr.enterZip("06851");
	    ntr.selectCountry("UNITED STATES");
	    
	}

	@When("^enters Username, (.+) and (.+) on Registration page$")
	public void enters_Username_and_on_Registration_page(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ntr.enterUsername(email);
	    ntr.enterPwd(arg1);
	    System.out.println("Confirm password is "+arg2);
	    ntr.enterConfirmPwd(arg2);
	    ntr.clickSubmit();
	    
	}

	@Then("^member gets success message$")
	public void member_gets_success_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(5000);
		ntr.verifySuccessMsg(driver);
	}

}
