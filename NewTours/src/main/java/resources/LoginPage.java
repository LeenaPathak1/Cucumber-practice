package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends commonmethods {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//input[@name='userName']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='submit']")
	WebElement submitButton;
	
	
	By loginSuccessMsg = By.xpath("//h3[text()='Login Successfully']");
	By loginThankYouMsg = By.xpath("//p//b[contains(text(),'Thank you for Loggin')]");
	
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void enterUserName(String name){
		type(username,name);
	}
	
	public void enterPwd(String pwd){
		type(password,pwd);
	}
	
	public void clickSubmit(){
		click(submitButton);
	}
	
	public void verifysuccessmsg(){
		waitForElement(driver,loginSuccessMsg);
		waitForElement(driver,loginThankYouMsg);
	}
	
}
