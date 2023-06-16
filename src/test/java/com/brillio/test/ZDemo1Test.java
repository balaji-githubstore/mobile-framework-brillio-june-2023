package com.brillio.test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ZDemo1Test {
	
	@DataProvider
	public Object[][] demoValidData()
	{
		Object[][] arr=new 	Object[3][2];
		//i--> number of test sets/test case
		//j-->number of parameters 
		arr[0][0]="john";
		arr[0][1]="john123";
		
		arr[1][0]="kim";
		arr[1][1]="787878";
		
		arr[2][0]="saul";
		arr[2][1]="78.8";
		
		return arr;
	}
	
	@Test(dataProvider = "demoValidData")
	public void demoValidTest(String username,String password)
	{
		System.out.println("hello "+username+password);
	}
	
	@Test()
	public void demoValid2Test()
	{
		System.out.println("hello2");
	}

}
