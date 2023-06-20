package com.brillio.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.brillio.base.AutomationWrapper;
import com.brillio.utilities.DataUtils;

import io.appium.java_client.AppiumBy;
/**
 * This class contains test methods of login scenario
 * No page objects added
 */
public class LoginTest extends AutomationWrapper{
	
	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider")
	public void invalidLoginTest(String username,String password,String expectedError) 
	{
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'address or')]"))
				.sendKeys(username);
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc='Password']"))
				.sendKeys(password);
		driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='Sign in'])[2]")).click();
		String actualError = driver.findElement(AppiumBy.xpath("//*[contains(@text,'issue')]")).getText();
		Assert.assertEquals(actualError, expectedError);
	}


}
