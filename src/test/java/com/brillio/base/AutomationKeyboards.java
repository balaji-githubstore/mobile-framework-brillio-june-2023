package com.brillio.base;


import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AutomationKeyboards {
	private AndroidDriver driver;

	public AutomationKeyboards(AndroidDriver driver) {
		this.driver = driver;
	}

	public void clickUsingLocator(By locator) {
		driver.findElement(locator).click();
	}

	public void typeUsingLocator(By locator,String text) {
		driver.findElement(locator).sendKeys(text);
	}
}
