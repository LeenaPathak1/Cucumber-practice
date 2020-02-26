package BaseMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	public static WebDriver driver=null;
	public static String memurl;
	public static String membrowser;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	@BeforeSuite
	@Parameters({"envFile"})
	public static void readProperties(String env) throws IOException{
		FileInputStream fp = new FileInputStream(env);
		Properties p = new Properties();
		p.load(fp);
		memurl=p.getProperty("MemberUrl");
		membrowser=p.getProperty("browser");
		
		/*ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("/Users/lpathak/Documents/pworkspace/NewTours/Reports/cucumberreport.html"));
		report = new ExtentReports();
		report.attachReporter(extent); */
	}
	
	
	public static WebDriver initializeBrowser(String url){
		
		if(membrowser.equals("chrome")){
			
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		}
		return driver;
	}	
	
	public static void type(WebElement element,String input){
		element.sendKeys(input);
	}
	
	public static void click(WebElement element){
		element.click();
	}
	
	public static String typeDynamicText(String input){
		
		SimpleDateFormat sf = new SimpleDateFormat("EEEHHmmss");
		Calendar cal = Calendar.getInstance();
		String dtext = String.valueOf(sf.format(cal.getTime()))+input;
		return dtext;
	}
	
	public static void selectByValue(WebElement element, String value){
		Select sV = new Select(element);
		sV.selectByValue(value);
		
	}
	
	public static void waitforelement(WebDriver driver,String xpath){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
}
