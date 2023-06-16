package com.brillio.test;

import org.testng.annotations.Test;

import com.brillio.utilities.PropUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * Will be deleted
 */
public class ZDemo1Test {
	
	@Test
	public void demo() throws IOException
	{
		var map=PropUtils.getPropertiesIntoMap("test-data/data.properties");
		System.out.println(map);
	}
	
	
	@Test
	public void readProperties() throws IOException
	{
		FileInputStream file=new FileInputStream("test-data/data.properties");
		Properties prop=new Properties();
		prop.load(file);
		
		String value=prop.getProperty("logLocation");
		System.out.println(value);
		HashMap<String, String> propMap=new HashMap<String, String>();
			
		
		for(Object key : prop.keySet())
		{
			//System.out.println(key);
			//value=prop.getProperty(key.toString());
			//System.out.println(value);
			propMap.put(key.toString(), prop.getProperty(key.toString()));
		}
		
		System.out.println(propMap);
		
		
		//without iteration
		Map<Object, Object> propMap1=prop;
		
		
		System.out.println(propMap1);
		System.out.println(propMap1.get("app"));
	}
	
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
