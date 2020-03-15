package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import resources.commonmethods;

public class Hooks extends commonmethods {
	
	@After
	public  void takeErrorSnapshot(Scenario scenario) throws IOException{
		
		System.out.println("Inside After Hook");
		if(scenario.isFailed()){
			SimpleDateFormat sd = new SimpleDateFormat("EEEhhMMss");
			Calendar cal = Calendar.getInstance();
			TakesScreenshot js = (TakesScreenshot)driver;
			File source = js.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("target/screenshots/"+scenario.getName()+"_"+sd.format(cal.getTime())+".png"));
		}
		
		driver.quit();
	}

}
