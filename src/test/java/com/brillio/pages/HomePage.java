package com.brillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	private By settingLocator = AppiumBy.xpath("//android.widget.ImageView[@content-desc='Settings']");

	private By searchLocator = AppiumBy.xpath("//*[@text='Search']");

	private AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
	}

	public void clickOnSettings() {
		driver.findElement(settingLocator).click();
	}
}
