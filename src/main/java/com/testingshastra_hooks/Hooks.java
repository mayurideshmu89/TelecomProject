package com.testingshastra_hooks;

import com.testingshastra_keywords.Keywords;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void launchBrowser() {
		Keywords.openBrowser("Chrome");
	}

	@After
	public void teardown() throws Exception {
		Keywords.driver.quit();
	}
}
