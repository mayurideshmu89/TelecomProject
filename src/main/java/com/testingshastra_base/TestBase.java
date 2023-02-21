package com.testingshastra_base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testingshastra_keywords.Keywords;

public class TestBase {

	@BeforeMethod
	public void launchBrowser() {
		Keywords.openBrowser("Chrome");
	}

	@AfterMethod
	public void teardown() throws Exception {
		Keywords.driver.quit();
	}
}
