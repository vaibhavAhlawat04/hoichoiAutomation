package hoichoiAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;

public class SubScription extends BaseClass {
	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}
	@After
	public void End() {
		driver.quit();
	}
	@Test
	public void basicTest() throws IOException {
		System.out.println("Subsription Test Started");

		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.mobile.AppCMSLaunchActivity");
		driver.startActivity(act);
		WebDriverWait wait = new WebDriverWait(driver,60);
		
		
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.viewlift.hoichoi:id/carouselBadgeImage")));

		driver.findElement(By.xpath("//*[@text='Menu']")).click();
		driver.findElement(By.id("com.viewlift.hoichoi:id/app_cms_nav_subscribe_button")).click();
		driver.findElement(By.xpath("//*[@text='Monthly']")).click();
		try {
			driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
		}catch(Exception er) {
			
		}
		MobileElement el4 = (MobileElement) driver.findElementById("com.viewlift.hoichoi:id/textInputEditFieldCountryCode");																
		el4.clear();
		el4.sendKeys("+91");
		
		driver.findElement(By.xpath("//*[@text='Enter Phone Number']")).sendKeys("7888706544");
		driver.findElement(By.xpath("//*[@text='Enter Your Email']")).sendKeys("1vaibhav.ahlawat8@gmail.com");

		driver.findElement(By.xpath("//*[@text='SIGN UP']")).click();
		try {
			driver.findElement(By.xpath("//*[@text='This email address is already linked to an existing account. Please login using the account.']")).isDisplayed();
			driver.findElement(By.xpath("//*[@text='CLOSE'")).click();
		}catch(Exception eee) {
			
		}
		System.out.println("Subscription TEst Complete");
		}catch(Exception essd) {
			essd.printStackTrace();
		}

	}//test

}
