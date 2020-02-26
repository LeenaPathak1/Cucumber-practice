package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseMethods.CommonMethods;

public class NewToursRegisterPage extends CommonMethods{
	//WebDriver driver;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement phoneNumber;
	
	@FindBy(id="userName")
	WebElement email;
	
	@FindBy(xpath="//input[@name='address1']")
	WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='postalCode']")
	WebElement zip;
	
	@FindBy(xpath="//select[@name='country']")
	WebElement countryDropDown;
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement submit;
	
	//@FindBy(xpath="//p[contains(text(),'Thank you for registering']")
	String success_msg = "//*[contains(text(),'Thank you for registering')]";
	
	
	public NewToursRegisterPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterFirstName(String fname){
		type(firstname, fname);
	}
	
	public void enterLastName(String lname){
		type(lastname, lname);
	}
	
	public void enterphone(String phone){
		type(phoneNumber, phone);
	}
	
	public void enterEmail(String emailID){
		type(email, emailID);
	}
	
	public void enterAddress(String homeaddress){
		type(address, homeaddress);
	}
	
	public void enterCity(String homeCity){
		type(city, homeCity);
	}
	
	public void enterState(String homeState){
		type(state, homeState);
	}
	
	public void enterZip(String homeZip){
		type(zip, homeZip);
	}
	
	public void selectCountry(String homeCountry){
		selectByValue(countryDropDown,homeCountry);
	}
	
	public void enterUsername(String memname){
		type(username, memname);
	}
	
	public void enterPwd(String memPwd){
		type(password, memPwd);
	}
	
	public void enterConfirmPwd(String memCPwd){
		type(confirmPassword, memCPwd);
	}
	
	public void clickSubmit(){
		click(submit);
	}
	
	public void verifySuccessMsg(WebDriver driver){
		waitforelement(driver,success_msg);
	}
	

}
