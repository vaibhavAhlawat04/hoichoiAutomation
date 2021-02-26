package hoichoiAutomation;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.StreamSupport;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.Activity;
import io.appium.java_client.serverevents.ServerEvents;

public class ApiCalls extends BaseClass {
	
	
	public static void main(String[] args){
		BaseClass base=new BaseClass();
		base.setUp();	
	}
	
	
	@After 
	public void End() {
		
		try{
			driver.quit();
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}

	@Test
	public void StartingApiCall() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,10);

		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.mobile.AppCMSLaunchActivity");
		driver.startActivity(act);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.viewlift.hoichoi:id/carouselBadgeImage")));
		
		Thread.sleep(5000);
		
		LogEntries logs = driver.manage().logs().get("logcat");
		StreamSupport.stream(logs.spliterator(), false).filter(s -> s.toString().contains("com.viewlift.hoichoi")).forEach(System.out::println);
	
	}

}
