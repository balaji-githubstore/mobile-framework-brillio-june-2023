package com.brillio.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ZDemo3ExtentReportTest {

	public static void main(String[] args) {
		
		//run only once in the beginning // @Before Suite 
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		
		//before each @Test method  - @BEforeMethod 
		ExtentTest test= extent.createTest("MyFirstTest-Balaji");
		
		
		
		
		//after each @Test method  - @AfterMethod 
		test.log(Status.FAIL, "This is a logging event for MyFirstTest, and it passed!");
		
		
		//run at end of the session @AfterSuite
		extent.flush();
		

	}

}
