package com.brillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SettingsPage {
	
	private By signInLocator=AppiumBy.xpath("//android.widget.TextView[@text='Sign in']");
	
	private AndroidDriver driver;

	public SettingsPage(AndroidDriver driver) {
		this.driver = driver;
	}

	public void clickOnSignIn()
	{
		driver.findElement(signInLocator).click();
	}
}
