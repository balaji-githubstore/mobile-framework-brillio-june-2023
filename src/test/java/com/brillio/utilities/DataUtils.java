package com.brillio.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataUtils {

	@DataProvider
	public Object[][] invalidLoginData() {
		Object[][] arr = new Object[2][3];

		arr[0][0] = "saul";
		arr[0][1] = "saul123";
		arr[0][2] = "There was an issue signing in";

		arr[1][0] = "kim";
		arr[1][1] = "kim123";
		arr[1][2] = "There was an issue signing in";

		return arr;
	}

	@DataProvider
	public Object[][] commonDataProvider(Method mtd) throws IOException {
		
		//currentTestMethodName is the sheetname
		String currentTestMethodName=mtd.getName();
		
		
		Object[][] arr=ExcelUtils.getSheetIntoTwoDimensionalArray("test-data/khan_academy_data.xlsx",
				currentTestMethodName);

		return arr;
	}
}
