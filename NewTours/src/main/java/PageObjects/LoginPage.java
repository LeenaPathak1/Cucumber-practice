package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseMethods.CommonMethods;

public class LoginPage extends CommonMethods {
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement submitButton;
	
	String loginSuccessTitle = "//h3[text()='Login Successfully']";
	
	String loginSuccessMsg = "//*[contains(text(),'Thank you for Loggin')]";
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String userId){
		type(username, userId);
	}
	
	public void enterPassword(String pwd){
		type(password, pwd);
	}
	
	public void clickSubmit(){
		click(submitButton);
	}
	
	public void verifyLoginSuccess(WebDriver driver) throws InterruptedException{
		waitforelement(driver,loginSuccessTitle);
		Thread.sleep(5000);
		waitforelement(driver,loginSuccessMsg);
	}
}
