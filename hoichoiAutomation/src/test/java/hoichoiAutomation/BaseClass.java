package hoichoiAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	AndroidDriver driver = null;
	
	@Before
	public void setUp() {
		DesiredCapabilities dcap = new DesiredCapabilities();
		
		
		//dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy J7 Prime");
		//dcap.setCapability("udid", "52032bb1419b1401");
		dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dcap.setCapability("PlatformName", "android");
		dcap.setCapability("appPackage", "com.viewlift.hoichoi");
		dcap.setCapability("appActivity", "com.viewlift.mobile.AppCMSLaunchActivity");
		dcap.setCapability("autoLaunch", false);
		dcap.setCapability("eventTimings", true);
		dcap.setCapability("clearDeviceLogsOnStart", true);
		
		
		try {
			URL url = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver<>(url,dcap);
		}catch(MalformedURLException malUrl) {
			malUrl.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}//setUp
}//BaseClass
