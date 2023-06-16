package com.brillio.test;

import org.testng.annotations.Test;

import com.brillio.base.AutomationWrapper;

import io.appium.java_client.AppiumBy;

/**
 * This class contains test methods of login scenario
 */
public class SignUpTest extends AutomationWrapper {

	@Test
	public void validRegisterTest() {
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Settings']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign up with email']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("john");

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("wick");

		System.out.println("valid registration");
	}

}
