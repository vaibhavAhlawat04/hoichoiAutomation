package hoichoiAutomation;

import java.io.File;
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

public class ScreenShot extends BaseClass {
	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}
	
	@After
	public void End() {
		driver.quit();
	}
	
	@Test
	public void ScreenShots() {
		
	WebDriverWait wait = new WebDriverWait(driver,60);
		
		//Starting App 
		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.mobile.AppCMSLaunchActivity");
		driver.startActivity(act);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.viewlift.hoichoi:id/carouselBadgeImage")));
			
			
			System.out.println(java.time.LocalTime.now());
			System.out.println("ScreenShots Test Started");
			File scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("MainPage.jpg"));
			scroll();
			
			
			driver.findElement(By.xpath("//*[@text='Shows']")).click();
			scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("ShowsPage.jpg"));
			scroll();
			
			driver.findElement(By.xpath("//androidx.appcompat.widget.LinearLayoutCompat[3]")).click();
			scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("MoviesPage.jpg"));
			scroll();
			
			driver.findElement(By.xpath("//androidx.appcompat.widget.LinearLayoutCompat[4]")).click();
			scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("FreePage.jpg"));
			scroll();
			
			driver.findElementByXPath("//*[@text='Menu']").click();
			scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("MenuPage.jpg"));
			
			try{
				driver.findElement(By.xpath("//*[@text='GENRES']")).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Action']")));
				scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrShot, new File("Genres.jpg"));
				
				MobileElement Genres1 = (MobileElement) driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.TextView"));
				Assert.assertEquals(Genres1.getText(), "Action");
				MobileElement Genres2 = (MobileElement) driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.TextView"));
				Assert.assertEquals(Genres2.getText(), "Classics");
				MobileElement Genres3 = (MobileElement) driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.TextView"));
				Assert.assertEquals(Genres3.getText(), "Comedy");
				MobileElement Genres4 = (MobileElement) driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.widget.FrameLayout/android.widget.TextView"));
				Assert.assertEquals(Genres4.getText(), "Detective");
				MobileElement Genres5 = (MobileElement) driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[5]/android.widget.FrameLayout/android.widget.TextView"));
				Assert.assertEquals(Genres5.getText(), "Drama");
				MobileElement Genres6 = (MobileElement) driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[6]/android.widget.FrameLayout/android.widget.TextView"));
				Assert.assertEquals(Genres6.getText(), "Family");
				MobileElement Genres7 = (MobileElement) driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[7]/android.widget.FrameLayout/android.widget.TextView"));
				Assert.assertEquals(Genres7.getText(), "Free");
				MobileElement Genres8 = (MobileElement) driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[8]/android.widget.FrameLayout/android.widget.TextView"));
				Assert.assertEquals(Genres8.getText(), "Hindi");
				MobileElement Genres9 = (MobileElement) driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[9]/android.widget.FrameLayout/android.widget.TextView"));
				Assert.assertEquals(Genres9.getText(), "Learn to Cook");
				MobileElement Genres10 = (MobileElement) driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[10]/android.widget.FrameLayout/android.widget.TextView"));
				Assert.assertEquals(Genres10.getText(), "Romance");
				
				
				//scroll
				
				TouchAction action = new TouchAction(driver);
				action.press(PointOption.point(588,1418))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000)))
				.moveTo(PointOption.point(588,742))
				.release()
				.perform();

				
				MobileElement Genres11 = (MobileElement) driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[10]/android.widget.FrameLayout/android.widget.TextView"));
				Assert.assertEquals(Genres11.getText(), "Shorts");
				
				System.out.println("All Genres match as Expected ");
				
				
				
			}catch(Exception GenresException) {
				System.out.println("Exception in Genres");
				GenresException.printStackTrace();
			}
			driver.findElementByXPath("//*[@text='Menu']").click();
			
			driver.findElement(By.xpath("//*[@text='MUSIC']")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.viewlift.hoichoi:id/carouselImage")));
			scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("Music.jpg"));
			driver.findElementByXPath("//*[@text='Menu']").click();
			
			driver.findElement(By.xpath("//*[@text='LANGUAGE']")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='English']")));
			scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("Language.jpg"));
			driver.findElementByXPath("//*[@text='CANCEL']").click();
			
			driver.findElement(By.xpath("//*[@text='REFER AND EARN']")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.viewlift.hoichoi:id/getSocialSignInButtonText")));
			scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("Refer&Earn.jpg"));
			driver.findElementByXPath("//*[@text='Menu']").click();
			
			driver.findElement(By.xpath("//*[@text='HELP']")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Most asked questions']")));
			scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("Help.jpg"));
			driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]").click();
			
			System.out.println("ScreenShots Saved");
			
		
	   }//try
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void scroll(){
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(588,1418))
		.waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000)))
		.moveTo(PointOption.point(588,742))
		.release()
		.perform();
	}

}
