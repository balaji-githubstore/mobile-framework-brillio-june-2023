package com.brillio.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.brillio.base.AutomationWrapper;

import io.appium.java_client.AppiumBy;

public class LoginTest extends AutomationWrapper{

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
