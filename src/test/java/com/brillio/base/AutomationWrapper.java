package com.brillio.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AutomationWrapper {

	protected AndroidDriver driver;
	private AppiumDriverLocalService service;

	// server setup
	// cloud device
	// record the session as video (.mp4)
	// extent report
	
	@BeforeSuite
	public void startSession()
	{
		AppiumServiceBuilder builder=new AppiumServiceBuilder();
		builder.usingAnyFreePort();
		builder.withLogFile(new File("logs/appiumlog.log"));
		builder.withArgument(GeneralServerFlag.BASEPATH,"/wd/hub");
		builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
		service=AppiumDriverLocalService.buildService(builder);
		
		service.start();
		//pass the service on the AndroidDriver object
	}
	
	@AfterSuite
	public void endSession()
	{
		service.stop();
	}

	@BeforeMethod
	public void setup() throws MalformedURLException {

		File file = new File("apps/khan-academy-7-3-2.apk");
		String appPath = file.getAbsolutePath();

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "android");
		caps.setCapability("deviceName", "redmi");
		caps.setCapability("app", appPath);
		caps.setCapability("autoLaunch", "false");

		driver = new AndroidDriver(service,caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.activateApp("org.khanacademy.android");

		if (driver.findElements(By.xpath("//*[@text='Allow']")).size() > 0) {
			driver.findElement(By.xpath("//*[@text='Allow']")).click();
		}
	}


	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
