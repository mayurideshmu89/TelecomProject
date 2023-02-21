package com.testingshastra_hooks;

import com.testingshastra_keywords.Keywords;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Ashtvivah_Hooks {
	@Before
	public void setup() {
		String env=System.getProperty("env");
		System.out.println("Enviorment: "+env);
		Keywords.openBrowser("Chrome");
		Keywords.launchUrl("https://ashtvivah.com/");
		Keywords.maximizeBrowser("Chrome");
	}

	@After
	public void teardown() throws Exception {
		Keywords.driver.quit();
	
}
}