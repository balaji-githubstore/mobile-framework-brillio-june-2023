package com.brillio.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;

public class AutomationWrapper {
	
	protected AndroidDriver driver;
	
	
	//server setup
	//cloud device
	//record the session as video (.mp4) 
	//extent report

	@BeforeMethod
	public void setup() throws MalformedURLException {

		File file = new File("apps/khan-academy-7-3-2.apk");
		String appPath = file.getAbsolutePath();

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "android");
		caps.setCapability("deviceName", "redmi");
		caps.setCapability("app", appPath);

		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
