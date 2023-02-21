package com.testingshastra_utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_utils {
	/**
	 * use this method locators from OR.properties file.Pass the key of locator that you want
	 * @param locator key of locator
	 * @return value of locator
	 */
	public static String getLocator(String locator) {
		String baseDir = System.getProperty("user.dir");// Current Working Directory or PWD
		String locatorvalue = "";
		try {
			FileInputStream fis = new FileInputStream(baseDir + "/src/main/resources/OR.properties");
			Properties prop = new Properties();
			prop.load(fis);
			locatorvalue =prop.getProperty(locator);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return locatorvalue;
	}

}
