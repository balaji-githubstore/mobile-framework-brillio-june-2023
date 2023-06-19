package com.brillio.test;

import org.testng.annotations.Test;

import com.brillio.base.AutomationWrapper;
import com.brillio.utilities.DataUtils;

import io.appium.java_client.AppiumBy;

/**
 * This class contains test methods of login scenario
 */
public class SignUpTest extends AutomationWrapper {

	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider")
	public void validRegisterTest(String firstname, String lastname, String dob, String email, String password,
			String expectedValue) {
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Settings']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign up with email']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys(firstname);

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys(lastname);

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Birthday']")).click();
		
		String[] dobSplit=dob.split("-");

		driver.findElement(AppiumBy.xpath("(//*[@resource-id='android:id/numberpicker_input'])[1]")).click();
		driver.findElement(AppiumBy.xpath("(//*[@resource-id='android:id/numberpicker_input'])[1]")).clear();
		driver.findElement(AppiumBy.xpath("(//*[@resource-id='android:id/numberpicker_input'])[1]")).sendKeys(dobSplit[1]);

		driver.findElement(AppiumBy.xpath("(//*[@resource-id='android:id/numberpicker_input'])[2]")).click();
		driver.findElement(AppiumBy.xpath("(//*[@resource-id='android:id/numberpicker_input'])[2]")).clear();
		driver.findElement(AppiumBy.xpath("(//*[@resource-id='android:id/numberpicker_input'])[2]")).sendKeys(dobSplit[0]);

		driver.findElement(AppiumBy.xpath("(//*[@resource-id='android:id/numberpicker_input'])[3]")).click();
		driver.findElement(AppiumBy.xpath("(//*[@resource-id='android:id/numberpicker_input'])[3]")).clear();
		driver.findElement(AppiumBy.xpath("(//*[@resource-id='android:id/numberpicker_input'])[3]")).sendKeys(dobSplit[2]);

		driver.findElement(AppiumBy.xpath("//*[@text='OK']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'Email')]"))
				.sendKeys(email);

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc='Password']")).sendKeys(password);

		//click on create
		//Assert the successful registration or profile page with your name
		System.out.println("valid registration");
	}

}
