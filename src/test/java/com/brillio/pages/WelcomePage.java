package com.brillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class WelcomePage {
	private By signUpLocator = AppiumBy.xpath("//android.widget.TextView[@text='Sign in']");

	private By signUpWithEmailLocator = AppiumBy.xpath("//android.widget.TextView[@text='Sign up with email']");

	private AndroidDriver driver;

	public WelcomePage(AndroidDriver driver) {
		this.driver = driver;
	}

	public void clickOnSignup() {
		driver.findElement(signUpLocator).click();
	}

	public void clickOnSignupWithEmail() {
		driver.findElement(signUpWithEmailLocator).click();
	}
}
