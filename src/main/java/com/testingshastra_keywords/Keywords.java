package com.testingshastra_keywords;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.testingshastra_utils.File_utils;

public class Keywords {
	public static WebDriver driver;

	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			System.err.println("Invalid browser name: " + browserName);
		}
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}
	public static void signInPage(WebElement element) {
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mayurimaratha257@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Romayu%8987");
		driver.findElement(By.xpath("//div//button[contains(text(),'Sign In')]")).click();
	}

	public static void maximizeBrowser(String browserName) {
		driver.manage().window().maximize();
	}

	
	public static void sendKeys(String locatorType,String locatorValue) {
		driver.findElement(By.xpath(locatorType)).sendKeys(locatorValue);
	}


	public static String getText(WebElement element) {
		return element.getText();
	}

	public static String getText(String locatorType, String locatorValue) {
		return getWebElement(locatorType,locatorValue).getText();
		
	}

	public  static List<String> getTexts(String locatorType, String locatorValue) 
	{
		List<String> texts= new ArrayList<String>();
		List<WebElement> elements =new ArrayList<WebElement>();
		
		if(locatorType.equalsIgnoreCase("ID"))
			elements = driver.findElements(By.id(locatorValue));
	    else if(locatorType.equalsIgnoreCase("ClASS")) 
	    	elements = driver.findElements(By.className(locatorValue));
		else if(locatorType.equalsIgnoreCase("xpath")) 
			elements = driver.findElements(By.xpath(locatorValue));
	    else if(locatorType.equalsIgnoreCase("linkText")) 
	    	elements = driver.findElements(By.linkText(locatorValue));
	    else if(locatorType.equalsIgnoreCase("PartiallinkText")) 
	    	elements =driver.findElements(By.partialLinkText(locatorValue));
	    else if(locatorType.equalsIgnoreCase("Tagname")) 
	    	elements = driver.findElements(By.tagName(locatorValue));
	    else if(locatorType.equalsIgnoreCase("Name")) 
	    	elements = driver.findElements(By.name(locatorValue));
	    else if(locatorType.equalsIgnoreCase("Css")) 
	    	elements = driver.findElements(By.cssSelector(locatorValue));
        for(WebElement element:elements)
        { 
	     texts.add(element.getText());
	  
        }
		return texts;
	    }
public static void enterText(String locatorType, String locatorValue,String TextToEnter) {
	getWebElement(locatorType,locatorValue).sendKeys(TextToEnter);

}
public static WebElement getWebElement(String locatorType, String locatorValue)
{
	if (locatorType.equalsIgnoreCase("ID"))
		return driver.findElement(By.id(locatorValue));
	else if (locatorType.equalsIgnoreCase("ClASS"))
		return driver.findElement(By.className(locatorValue));
	else if (locatorType.equalsIgnoreCase("xpath"))
		return driver.findElement(By.xpath(locatorValue));
	else if (locatorType.equalsIgnoreCase("linkText"))
		return driver.findElement(By.linkText(locatorValue));
	else if (locatorType.equalsIgnoreCase("PartiallinkText"))
		return driver.findElement(By.partialLinkText(locatorValue));
	else if (locatorType.equalsIgnoreCase("Tagname"))
		return driver.findElement(By.tagName(locatorValue));
	else if (locatorType.equalsIgnoreCase("Name"))
		return driver.findElement(By.name(locatorValue));
	else if (locatorType.equalsIgnoreCase("Css"))
		return driver.findElement(By.cssSelector(locatorValue));
	return null;
	}

	public static void wait1(WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(element)); element.click();

	}

	public void closebrowser() {
		driver.close();
	}

	public static void clickOn(String locatorType, String locatorValue) {
		getWebElement(locatorType,locatorValue).click();
	}
	public static void click(WebElement element) {
		WebElement element1 = driver.findElement(By.xpath("//div[@id='j_meeting_tab']"));
		element1.click();
		}}









	


