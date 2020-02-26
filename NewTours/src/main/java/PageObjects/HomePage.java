package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseMethods.CommonMethods;

public class HomePage extends CommonMethods {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='REGISTER']")
	WebElement registerLink;

	@FindBy(xpath="//input[@name='userName']")
	WebElement userName;

	@FindBy(xpath="//input[@name='password']")
	WebElement signOnPassword;
	
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickRegister(){
		
		click(registerLink);
		
	}
	
}
