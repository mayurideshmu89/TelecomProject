package com.testingshastra_stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.base.Verify;
import com.testingshastra_keywords.Keywords;
import com.testingshastra_pages.HomePage;
import com.testingshastra_utils.File_utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class File_Steps {
	@Given("Open Browser")
	public void openBrowser() {
		Keywords.openBrowser("chrome");
	}

	@When("user enter app url")
	public void LuanchUrl() {
		Keywords.launchUrl("https://ijmeet.com/");
	}

	@Then("maximize the browser")
	public void maximizebrowser() {
		Keywords.maximizeBrowser("chrome");
	}

	@Then("application should launch")
	public void verifytitleofHomePage() {
		Assert.assertEquals(Keywords.driver.getTitle(), "IJmeet");
	}

	@Then("verify signIn meeting button")
	public void verifysignInmeetingbutton() {
		Keywords.clickOn("xpath", File_utils.getLocator("homepage.first_sign_In_button"));
		WebElement x = Keywords.driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
		Assert.assertTrue(x.isEnabled());
		Keywords.getWebElement("xpath", File_utils.getLocator("homepage.email")).sendKeys("mayurimaratha257@gmail.com");
		Keywords.getWebElement("xpath", File_utils.getLocator("homepage.password")).sendKeys("Romayu@8987");
		Keywords.clickOn("xpath", File_utils.getLocator("homepage.second_sign_In_button"));

	}

	@Then("verify JoinMeeting button")
	public void verifyjoinmeetingbutton() throws InterruptedException {
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Thread.sleep(3000);
		home.clickOnjoinMeeting();
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.enter_join_meetingid"))
				.sendKeys("e5c1d5f");
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.join_meeting_button1"));
		WebElement x = Keywords.driver.findElement(By.xpath("(//div//button[contains(text(),'Join Meeting')])[1]"));
		Assert.assertTrue(x.isEnabled());

	}

	@Then("verify MyMeeting button")
	public void verifyMyMeetingbutton() throws InterruptedException {
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		home.myMeeting();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.My_meeting_button"));
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.enter_search_valueid"))
				.sendKeys("64e4848");
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Mymeeting_enter_start_date"))
				.sendKeys("02/01/2023");
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Mymeeting_enter_end_date"))
				.sendKeys("02/20/2023");
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Mymeeting_search_button"));
		WebElement x = Keywords.driver.findElement(By.xpath("(//a[contains(text(),' Search')])[1]"));
		Assert.assertTrue(x.isEnabled());

	}

	@Then("verify SheduleMeeting button")
	public void verifysheduleMeetingbutton() throws InterruptedException {
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_button"));
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_button_editTopic"))
				.sendKeys("Selenium Java");
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_discription"))
				.sendKeys("xpath,classes,collection including all topics");
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_invites"))
				.sendKeys("roshandeshmukh45@gmail.com,mayuridesh987@gmail.com");
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_start_date"))
				.sendKeys("01/30/2023");
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_start_time"))
				.sendKeys("12:00PM");
		WebElement list = Keywords.driver.findElement(By.xpath("//select[@id=\"edit_hour\"]"));
		Thread.sleep(10000);
		Select select1 = new Select(list);
		select1.selectByVisibleText("01");
		Thread.sleep(5000);
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_enable_waiting"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_videoHostSlider_button"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_muteParticepents"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_button1"));
		// Keywords.clickOn("xpath", File_utils.getLocator("//a[text()='Cancel']"));
		WebElement templ = Keywords.driver.findElement(By.xpath("//input[@value=\"Schedule Meeting\"]"));
		Assert.assertTrue(templ.isEnabled());

	}

	@Then("verify QuickMeeting button")
	public void verifyquickmeeting() throws InterruptedException {
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		ChromeOptions options = new ChromeOptions();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Quickmeeting_button"));
		Thread.sleep(20000);
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Quickmeeting_Closebutton"));
		options.addArguments("--use-fake-device-for-media-stream");
		options.addArguments("--use-fake-ui-for-media-stream");
	}

	@Then("verify my Account button")
	public void verify_my_account_button() {
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Account_tab_button"));
	}
	@Then("verify Webinar button")
	public void verifyWebinarButton() throws InterruptedException {
		Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.Webinar_tab_button"));
		Thread.sleep(20000);
	}
	@Then("verify my Account Upcoming Meeting button")
	public void verifymyAccountUpcomingMeetingbutton() {
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Upcomingmeeting_tab_button"));
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Upcomingmeeting_enter_searchValue_button"))
				.sendKeys("64e4848");
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Upcomingmeeting_start_date_button"))
				.sendKeys("02/01/2023");
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Upcomingmeeting_end_date_button"))
				.sendKeys("02/20/2023");
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Upcomingmeeting_search_button"));
		WebElement x = Keywords.driver.findElement(By.xpath("(//a[contains(text(),' Search')])[1]"));
		Assert.assertTrue(x.isEnabled());
	}

	@Then("verify my Account Previous Meeting button")
	public void verifymyAccountPreviousMeetingbutton() {
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Previousmeeting_tab_button"));
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Previousmeeting_enter_searchValue_button"))
				.sendKeys("edd514d");
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Previousmeeting_start_date_button"))
				.sendKeys("01/28/2023");
		Keywords.getWebElement("xpath", File_utils.getLocator("dashboardpage.Previousmeeting_end_date_button"))
				.sendKeys("01/29/2023");
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Previousmeeting_search_button"));
		WebElement x = Keywords.driver.findElement(By.xpath("(//a[contains(text(),' Search')])[1]"));
		Assert.assertTrue(x.isEnabled());
	}

	@Then("verify Sheduled Webinars button")
	public void verifySheduled_Webinarsbutton() throws InterruptedException {
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Schedule_Webinar_tab_button"));
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.enter_Wbinar_topic"))
				.sendKeys("Selenium java");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.enter_edit_discription"))
				.sendKeys("Oops concepts");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.enter_invites"))
				.sendKeys("roshandeshmukh45@gmail.com");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.alternate_Hosts"))
				.sendKeys("mayurideshmukh989@gmail.com");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.Schedule_Webinar_start_date"))
				.sendKeys("02/06/2023");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.Schedule_Webinar_start_time"))
				.sendKeys("5.27pm");
		WebElement list = Keywords.driver.findElement(By.cssSelector("select#w_edit_hour"));
		Select select1 = new Select(list);
		select1.selectByVisibleText("01");
		Thread.sleep(5000);
		Keywords.driver.findElement(By.xpath("//input[@id=\"enable_waiting_room_w\"]/parent::label"));
		WebElement Element = Keywords.driver.findElement(By.xpath("(//input[@value='Save Changes'])[1]"));
		new Actions(Keywords.driver).click(Element).perform();
		Element.click();
	}

	@Then("verify Upcoming Webinars button")
	public void verifyUpcomingWebinarsbutton() throws InterruptedException {
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.UpcomingWebinar_enter_searchValue"))
				.sendKeys("885a073");
		Thread.sleep(10000);
		WebElement t = Keywords.getWebElement("Css",
				File_utils.getLocator("dashboardpage.UpcomingWebinar_enter_start_date"));
		t.clear();
		t.sendKeys("02/02/2023");
		WebElement s = Keywords.getWebElement("Css",
				File_utils.getLocator("dashboardpage.UpcomingWebinar_enter_end_date"));
		s.clear();
		s.sendKeys("02/19/2023");
		Thread.sleep(20000);
		Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.UpcomingWebinar_search_button"));
		WebElement x = Keywords.driver.findElement(By.cssSelector("a[class$=\"upcoming_webinar\"]"));
		Assert.assertTrue(x.isEnabled());
	}
	@Then("verify Previous Webinars button")
	public void verifyPreviousWebinarsbutton() throws InterruptedException {
		Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.PreviousWebinar_tab_button"));
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.PreviousWebinar_enter_searchValue")).sendKeys("8fbaf6a");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.PreviousWebinar_enter_start_date")).sendKeys("01/31/2023");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.PreviousWebinar_enter_end_date")).sendKeys("02/02/2023");
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.PreviousWebinar_search_button"));
		WebElement x = Keywords.driver.findElement(By.xpath("(//a[contains(text(),' Search')])[5]"));
		Assert.assertTrue(x.isEnabled());
}
	@Then("verify my Account Profile Information button")
	public void verifymymy_Account_ProfileInformationButton() throws InterruptedException {
	Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.ProfileInformation_button"));
	Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.ProfileInformation_MeetingId")).sendKeys("345678");
	Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.ProfileInformation_SaveChanges_button"));
	Thread.sleep(2000);
	Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.ProfileInformation_JoinPersonalMeeting_button"));
	WebElement s=Keywords.driver.findElement(By.xpath("//a[contains(text(),' Join Personal Meeting ')]"));
	Assert.assertTrue(s.isEnabled());
	}	
	@Then("verify my Account Change Password button")
	public void verifymyMyAccountChangePasswordButton() {
	Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.ChangePassword_tab_button"));
	Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.OldPassword_button")).sendKeys("Romayu#8987");
	Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.NewPassword_button")).sendKeys("Romayu%8987");
	Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.ConfirmPassword_button")).sendKeys("Romayu%8987");
	Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Change_button"));
	WebElement s=Keywords.driver.findElement(By.xpath("//button[contains(text(),'Change')]"));
	Assert.assertFalse(s.isEnabled());
	}
	@Then("verify my Account LogOut button")
	public void verifyMyAccountLogOutButton() throws InterruptedException {
	Keywords.driver.findElement(By.xpath("//a[@href=\"https://ijmeet.com/myaccount\"]")).click();
	WebElement s=Keywords.driver.findElement(By.xpath("//a[@href=\"https://ijmeet.com/myaccount\"]"));
	Assert.assertTrue(s.isEnabled());
	Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.LogOut_button"));
	Thread.sleep(2000);
}
	@Then("verify Invites button")
	public void verifyInvitesButton() {
	Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Invites_button"));
    WebElement t=Keywords.driver.findElement(By.xpath("//a[@href=\"https://ijmeet.com/invites\"]"));
	Assert.assertTrue(t.isEnabled());
}
	@Then("verify Application button")
	public void verifyApplicationButton() {
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Application_button"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.TermsAndCondition_button"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.AppStoreDownload_button"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.PlayStoreDownload_button"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.JoinToBrowsers_button"));
		WebElement t=Keywords.driver.findElement(By.xpath("//a[@href=\"https://ijmeet.com/app\"]"));
		Assert.assertTrue(t.isEnabled());
	
	}
	}
