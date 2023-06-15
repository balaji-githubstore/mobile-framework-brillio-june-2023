package com.brillio.test;

import org.testng.annotations.Test;

import com.brillio.base.AutomationWrapper;

import io.appium.java_client.AppiumBy;
/**
 * This class contains test methods of login scenario
 */
public class SignUpTest extends AutomationWrapper{
	
	@Test
	public void validRegisterTest()
	{
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		//test method to valid successful registration
		System.out.println("valid registration");
	}

}
