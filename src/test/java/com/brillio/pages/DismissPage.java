package com.brillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.brillio.base.AutomationKeyboards;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class DismissPage extends AutomationKeyboards{

	private By dismissLocator = AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']");

	private AndroidDriver driver;

	public DismissPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickOnDismiss() {
		if (driver.findElements(dismissLocator).size() > 0) {
//			driver.findElement(dismissLocator).click();
			clickUsingLocator(dismissLocator);
		}
	}

}
