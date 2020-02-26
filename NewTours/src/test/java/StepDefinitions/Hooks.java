package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import BaseMethods.CommonMethods;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends CommonMethods {
	
	@After()
	public static void getScreenShot(Scenario scenario) throws IOException{
			SimpleDateFormat sf = new SimpleDateFormat("EEEHHmmss");
			Calendar cal = Calendar.getInstance();
			
			if(scenario.isFailed()){
				System.out.println("Scenario result is " +scenario.getStatus());
				File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src,new File("target/error-screenshots/"+scenario.getName()+"_"+String.valueOf(sf.format(cal.getTime()))+"_.png"));
			}
		
		driver.quit();
		report.flush();
	}

}
