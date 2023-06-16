package com.brillio.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.brillio.utilities.PropUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AutomationWrapper {

	protected AndroidDriver driver;
	private static AppiumDriverLocalService service;
	private static Map<Object, Object> propEnvMap;

	// server setup
	// cloud device
	// record the session as video (.mp4)
	// extent report

	@BeforeSuite
	public void startSession() throws IOException {
		if(propEnvMap==null)
		{
			propEnvMap = PropUtils.getPropertiesIntoMap("test-data/data.properties");
		}
		

		if (propEnvMap.get("runenv").toString().equalsIgnoreCase("local") && service == null) {
			AppiumServiceBuilder builder = new AppiumServiceBuilder();
			builder.usingAnyFreePort();
			builder.withLogFile(new File(propEnvMap.get("logLocation").toString()));
			builder.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub");
			builder.withAppiumJS(new File(propEnvMap.get("appiumJSpath").toString()));
			service = AppiumDriverLocalService.buildService(builder);

			service.start();
		}
		// pass the service on the AndroidDriver object
	}

	@AfterSuite
	public void endSession() {
		if (service != null && service.isRunning()) {
			service.stop();
		}
	}

	@BeforeMethod
	@Parameters({"deviceName","platformVersion"})
	public void setup(@Optional("None") String deviceName,@Optional("None") String platformVersion) throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", propEnvMap.get("platformName").toString());
		
		if(deviceName.equalsIgnoreCase("none"))
		{
			caps.setCapability("deviceName", propEnvMap.get("deviceName").toString());
			caps.setCapability("platformVersion", propEnvMap.get("platformVersion").toString());
		}
		else
		{
			caps.setCapability("deviceName",deviceName);
			caps.setCapability("platformVersion", platformVersion);
		}
		
		

		if (propEnvMap.get("runenv").toString().equalsIgnoreCase("local")) {
			String appPath = new File(propEnvMap.get("app").toString()).getAbsolutePath();

			caps.setCapability("autoLaunch", "false");
			caps.setCapability("app", appPath);

			driver = new AndroidDriver(service, caps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			driver.activateApp("org.khanacademy.android");

			if (driver.findElements(By.xpath("//*[@text='Allow']")).size() > 0) {
				driver.findElement(By.xpath("//*[@text='Allow']")).click();
			}
		} else {
			
			caps.setCapability("app", propEnvMap.get("appCloud").toString());

			Map<String, String> bstackDetails = new HashMap<String, String>();

			bstackDetails.put("projectName", propEnvMap.get("projectName").toString());
			bstackDetails.put("buildName", propEnvMap.get("buildName").toString());
			bstackDetails.put("sessionName", propEnvMap.get("sessionName").toString());

			bstackDetails.put("userName", propEnvMap.get("userName").toString());
			bstackDetails.put("accessKey", propEnvMap.get("accessKey").toString());

			caps.setCapability("bstack:options", bstackDetails);

			driver = new AndroidDriver(new URL(propEnvMap.get("browserstackUrl").toString()), caps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
