package hoichoiAutomation;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.Activity;
import io.appium.java_client.serverevents.CommandEvent;
import io.appium.java_client.serverevents.ServerEvents;

public class LoadingTime extends BaseClass{

	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}
	
	@Test
	public void TestLoadingTime() {
		System.out.println(java.time.LocalTime.now());
		WebDriverWait wait = new WebDriverWait(driver,60);
		
			try {
				Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.mobile.AppCMSLaunchActivity");
				driver.startActivity(act);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.viewlift.hoichoi:id/carouselBadgeImage")));

			
				ServerEvents evnts = driver.getEvents();
				List<CommandEvent> cmds = evnts.getCommands();
				Optional<CommandEvent> startActCmd = cmds.stream()
						.filter((cmd)-> cmd.getName().equals("startActivity"))
						.findFirst();
				
				Optional<CommandEvent> findCmd = cmds.stream()
						.filter((cmd)-> cmd.getName().equals("findElement"))
						.findFirst();
				
				if(!startActCmd.isPresent() || !findCmd.isPresent()) {
					throw new Exception("could not determine start or end time of app launch");
				}
				
				long launchMs= startActCmd.get().endTimestamp - startActCmd.get().startTimestamp;
				long interactMs = findCmd.get().endTimestamp - findCmd.get().startTimestamp;
				
				System.out.println("the app took total <" + (launchMs/1000.0) + "s to launch" +
				" and total <" + (interactMs/1000.0) + "s to become interactable");
				
				System.out.println("LoadingTime Test Complete");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
