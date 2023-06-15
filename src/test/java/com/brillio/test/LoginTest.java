package com.brillio.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginTest {

	AndroidDriver driver;

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

	@Test
	public void invalidLoginTest() {
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'address or')]"))
				.sendKeys("john@gmail.com");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc='Password']"))
				.sendKeys("welcome123");
		driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='Sign in'])[2]")).click();
		String actualError = driver.findElement(AppiumBy.xpath("//*[contains(@text,'issue')]")).getText();
		Assert.assertEquals(actualError, "There was an issue signing in");

	}

}
