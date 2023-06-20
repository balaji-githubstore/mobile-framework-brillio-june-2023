package com.brillio.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.brillio.base.AutomationWrapper;
import com.brillio.pages.DismissPage;
import com.brillio.pages.HomePage;
import com.brillio.pages.SettingsPage;
import com.brillio.pages.WelcomePage;
import com.brillio.utilities.DataUtils;

import io.appium.java_client.AppiumBy;

/**
 * This class contains test methods of login scenario
 */
public class SignUpTest extends AutomationWrapper {

	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider")
	public void validRegisterTest(String firstname, String lastname, String dob, String email, String password,
			String expectedValue) {
		
		DismissPage dismissPage=new DismissPage(driver);
		dismissPage.clickOnDismiss();
		test.log(Status.INFO, "Clicked On Dismiss");

		HomePage homePage=new HomePage(driver);
		homePage.clickOnSettings();
		
		test.log(Status.INFO, "Clicked On Settings Icon");
		
		SettingsPage settingsPage=new SettingsPage(driver);
		settingsPage.clickOnSignIn();
		test.log(Status.INFO, "Clicked On Sign in");

		WelcomePage welcomePage=new WelcomePage(driver);
		welcomePage.clickOnSignupWithEmail();
		test.log(Status.INFO, "Clicked On Sign up with email");

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys(firstname);
		test.log(Status.INFO, "Entered First Name as "+firstname);

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys(lastname);
		test.log(Status.INFO, "Entered Last Name as "+lastname);

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
		
		test.log(Status.INFO, "Entered date as "+dobSplit);

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'Email')]"))
				.sendKeys(email);
		test.log(Status.INFO, "Entered Email as "+email);

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc='Password']")).sendKeys(password);
		test.log(Status.INFO, "Entered Password as "+password);
		//click on create
		//Assert the successful registration or profile page with your name
		System.out.println("valid registration");
	}

}
