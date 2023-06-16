package com.brillio.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.brillio.base.AutomationWrapper;

import io.appium.java_client.AppiumBy;
/**
 * This class contains test methods of login scenario
 */
public class LoginTest extends AutomationWrapper{

	@DataProvider
	public Object[][] invalidLoginData()
	{
		Object[][] arr=new Object[2][3]; 
		
		arr[0][0]="saul";
		arr[0][1]="saul123";
		arr[0][2]="There was an issue signing in";
		
		arr[1][0]="kim";
		arr[1][1]="kim123";
		arr[1][2]="There was an issue signing in";
		
		return arr;
		
	}
	
	@Test(dataProvider = "invalidLoginData")
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
