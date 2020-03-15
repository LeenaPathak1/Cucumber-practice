package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class commonmethods {
	
	public static WebDriver driver;
	public static Properties p;
	public static String mbrowser;
	
	@BeforeSuite
	@Parameters({"environment", "browser"})
	public static void readProperties(String env, String browser) throws IOException{
		p = new Properties();
		mbrowser = browser;
		System.out.println("browser value is "+mbrowser);
		if(env.equals("QA")){
			FileInputStream fs = new FileInputStream("src/main/java/resources/"+env+".properties");
			p.load(fs);
		}	
		
	}
	
	
	public static WebDriver initializeDriver(String browser){
			if(browser.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		}
		
	public static void waitForElement(WebDriver driver,By by){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		
	}
	
	public static void selectbyVisibleText(WebElement element, String textToSelect){
		Select select = new Select(element);
		select.selectByVisibleText(textToSelect);
		
	}
	
	public static void jsClick(WebDriver driver,WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void click(WebElement element){
		element.click();
	}
	
	public static void type(WebElement element, String text){
		element.sendKeys(text);
	}
	
	public static String getText(WebElement element){
		return element.getText();
	}
		

}
