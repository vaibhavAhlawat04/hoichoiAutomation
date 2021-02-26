package hoichoiAutomation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

public class logInPage extends BaseClass{

	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}
	@After
	public void End() {
		driver.quit();
	}

	@Test
	public void logInPageTest() throws IOException {

		System.out.println(java.time.LocalTime.now());
		WebDriverWait wait = new WebDriverWait(driver,0);

		//Starting App 
		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.mobile.AppCMSLaunchActivity");
		driver.startActivity(act);


		try {
			if(driver.findElement(By.id("com.viewlift.hoichoi:id/half_interstitial_image")).isDisplayed()) {
				driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.ImageView")).click();
			}
		}catch(Exception ess) {

		}
		try {
			if(driver.findElement(By.id("android:id/message")).isDisplayed()) {
				driver.findElement(By.id("android:id/button1")).click();
			}
		}catch(Exception esss) {

		}

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.viewlift.hoichoi:id/carouselBadgeImage")));


			System.out.println(java.time.LocalTime.now());
			System.out.println("Login Test Started");


			//Login
			driver.findElementByXPath("//*[@text='Menu']").click();

			driver.findElementById("com.viewlift.hoichoi:id/app_cms_nav_login_button").
			click(); 
			try {
				driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
			}catch(Exception er) {
			}
			
			File scrShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("Login.jpg"));

			MobileElement el4 = (MobileElement) driver.findElementById("com.viewlift.hoichoi:id/textInputEditFieldCountryCode");
			el4.clear();
			el4.sendKeys("+91");

			MobileElement el8 = (MobileElement)
					driver.findElementById("com.viewlift.hoichoi:id/textInputEditField");
			el8.sendKeys("7888706544");

			driver.findElement(By.xpath("//android.widget.Button[4]\r\n")).click();

			Thread.sleep(10000);

			driver.findElement(By.id("com.viewlift.hoichoi:id/verifyOTP")).click();



			//if number is not linked to any account or number is invalid
			try { 
				driver.findElement(By.
						xpath("//*[@text='Phone Number is Not Valid. Please Enter a Valid Phone Number']")).isDisplayed(); 
				System.out.println("Phone Number Entered is not valid");
			}catch(Exception ee) {
			}
			try{
				driver.findElement(By.xpath("//*[@text='This Phone Number is not Linked to any account']")).isDisplayed();
				System.out.println("Phone Number is not linked to any Account");  
			}catch(Exception ex) {
			}
			System.out.println("Login is SuccessFull");


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}
}
