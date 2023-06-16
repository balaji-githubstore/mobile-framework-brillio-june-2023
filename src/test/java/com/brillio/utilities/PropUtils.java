package com.brillio.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropUtils {

	public static Map<Object, Object> getPropertiesIntoMap(String filePath) throws IOException{
		
		FileInputStream file=new FileInputStream(filePath);
		Properties prop=new Properties();
		prop.load(file);
		
		Map<Object, Object> propMap=prop;
		
		return propMap;
	}
}
