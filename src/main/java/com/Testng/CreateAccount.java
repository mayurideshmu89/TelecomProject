package com.Testng;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.testingshastra_keywords.Keywords;

public class CreateAccount {

	WebDriver driver = new ChromeDriver();

	@Test(priority = 1)
	public void SignInPage() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofMillis(300));
		wait.ignoring(NoSuchElementException.class);
		driver.get("https://ijmeet.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div//a[contains(text(),'Sign In')]")).click();
		WebElement x = driver.findElement(By.xpath("//div//button[contains(text(),'Sign In')]"));
		Assert.assertTrue(x.isEnabled());
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mayurimaratha257@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Romayu@8987");
		driver.findElement(By.xpath("//div//button[contains(text(),'Sign In')]")).click();
	}

//@Test
//	public void SignUpPage() throws InterruptedException {
//		ChromeDriver driver = new ChromeDriver();
//		driver.get("https://ijmeet.com/");
//		driver.findElement(By.xpath("//div//a[contains(text(),'Sign Up')]")).click();
//		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Mayuri Deshmukh");
//		driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("Testing");
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mayurimaratha257@gmail.com");
//		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("123456789");
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Romayu@8987");
//		Thread.sleep(3000); //
//		driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")).click();
//		driver.findElement(By.xpath("//div//button[@class='rc-button //goog-inline-block rc-button-audio']")).click();
//		driver.findElement(By.xpath("//div//button[contains(text(),'Sign Up')]")).click();
//	}
//   @Test(priority = 2)
//	public void join_meeting() {
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		wait.withTimeout(Duration.ofSeconds(30));
//		wait.pollingEvery(Duration.ofMillis(300));
//		wait.ignoring(NoSuchElementException.class);
//		driver.findElement(By.xpath("//a//div[@id='j_meeting_tab']")).click();
//		driver.findElement(By.xpath("//div//input[@title='Please enter correct meeting id']")).sendKeys("https://ijmeet.com/meet/6789");
//		driver.findElement(By.xpath("(//div//button[contains(text(),'Join Meeting')])[1]")).click();
//    	WebElement x = driver.findElement(By.xpath("(//div//button[contains(text(),'Join Meeting')])[1]"));
//		Assert.assertTrue(x.isEnabled());
//	}
    @Test(priority = 2)
	public void my_meeting() {
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	wait.withTimeout(Duration.ofSeconds(30));
	wait.pollingEvery(Duration.ofMillis(300));
	wait.ignoring(NoSuchElementException.class);
	driver.findElement(By.xpath("//a//div[@id='My_Meetingsapps_tab']")).click();
	driver.findElement(By.xpath("//input[@placeholder=\" Enter search value \"]")).sendKeys("7523750");
	driver.findElement(By.xpath("(//input[@class=\"form-control start_date\"]/parent::div[@class=\"input-group date datepicker\"])[1]")).sendKeys("01/18/2023");
	driver.findElement(By.xpath("//input[@id=\"upcoming_meeting_end_date\"]/parent::div[@id=\"datepicker-popup2\"]")).sendKeys("01/19/2023");
    driver.findElement(By.xpath("((//a[contains(text(),' Search ')])[1]")).click();
	WebElement x = driver.findElement(By.xpath("(//a[contains(text(),' Search')])[1]"));
	Assert.assertTrue(x.isEnabled());
}

//	@Test(priority = 3)
//	public void Sheduled_meeting() {
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		wait.withTimeout(Duration.ofSeconds(30));
//		wait.pollingEvery(Duration.ofMillis(300));
//		wait.ignoring(NoSuchElementException.class);
//		driver.findElement(By.xpath("//button//span[contains(text(),' Schedule Meeting ')]")).click();
//		driver.findElement(By.xpath("//*[@id=\"upcoming-meetings\"]/div[2]/div/div/button")).click();
//		driver.findElement(By.xpath("//input[@id='edit_topic']")).sendKeys("Selenium Java");
//		driver.findElement(By.xpath("//div//textarea[@id='edit_description_1']"))
//				.sendKeys("xpath,classes,collection including all topics");
//		driver.findElement(By.xpath("//div[@class=\"multiple_emails-container\"]"))
//				.sendKeys("mayurideshmukh989@gmail.com,mayuridesh987@gmail.com");
//		WebElement list = driver.findElement(By.xpath("//select[@id=\"edit_hour\"]"));
//		Select select1 = new Select(list);
//		select1.selectByVisibleText("August");
//		driver.findElement(By.xpath("//select[@id=\"edit_minute\"]")).click();
//		select1.selectByVisibleText("August");
//		driver.findElement(By.xpath("//select[@id=\"edit_timezone\"]")).click();
//		select1.selectByVisibleText("August");
//		driver.findElement(By.xpath("//select[@id=\"email_template_language\"]")).click();
//		select1.selectByVisibleText("August");
//		WebElement templ = driver.findElement(By.xpath("//select[@id=\"email_template_language\"]"));
//		Assert.assertTrue(templ.isEnabled());
//	}
//	}
//
//
      @Test(priority = 5)
	  public void quick_meeting() throws InterruptedException {
	  
//	  FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//	  wait.withTimeout(Duration.ofSeconds(30));
//	  wait.pollingEvery(Duration.ofMillis(300));
//	  wait.ignoring(NoSuchElementException.class);
    	  ChromeOptions options= new ChromeOptions();
      driver.findElement(By.xpath("//div//div[@id=\"quick_meeting_tab\"]")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//span[@class='close']")).click();
	  options.addArguments("--use-fake-device-for-media-stream");
	  options.addArguments("--use-fake-ui-for-media-stream");
	  }

//	public void my_Account() {
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		wait.withTimeout(Duration.ofSeconds(30));
//		wait.pollingEvery(Duration.ofMillis(300));
//		wait.ignoring(NoSuchElementException.class);
//		driver.findElement(By.xpath("//li//a[@href=\"https://ijmeet.com/myaccount\"]")).click();
//	    driver.findElement(By.xpath("//button[@class=\"mtablinks\"]")).click();
//}

	public void invites() {
		driver.findElement(By.xpath("//li//a[@href=\"https://ijmeet.com/invites\"]")).click();
		driver.findElement(By.xpath("//button[@class=\"mtablinks\"]")).click();
	}
	}

//	public void application() {
//		driver.findElement(By.xpath("//li//a[@href=\"https://ijmeet.com/application\"]")).click();
//
//	}
//}
