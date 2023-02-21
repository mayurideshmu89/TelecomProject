package IJmeetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.testingshastra_base.TestBase;
import com.testingshastra_keywords.Keywords;
import com.testingshastra_pages.HomePage;
import com.testingshastra_utils.File_utils;
import com.testingshastra_utils.Locator;
import com.testingshastra_utils.LocatorType;

public class HomePageTests extends TestBase {
	@Test
	public void SignInIJmeetPage() {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		Keywords.clickOn("xpath", File_utils.getLocator("homepage.first_sign_In_button"));
		WebElement x = Keywords.driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
		Assert.assertTrue(x.isEnabled());
		Keywords.getWebElement("xpath", File_utils.getLocator("homepage.email")).sendKeys("mayurimaratha257@gmail.com");
		Keywords.getWebElement("xpath", File_utils.getLocator("homepage.password")).sendKeys("Romayu%8987");
		Keywords.clickOn("xpath", File_utils.getLocator("homepage.second_sign_In_button"));
	}

	@Test
	public void SignUpPage() throws InterruptedException {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		Keywords.clickOn("xpath", File_utils.getLocator("homepage.Sign_Up_button"));
		Keywords.getWebElement("xpath", File_utils.getLocator("homepage.Full_Name")).sendKeys("Mayuri Deshmukh");
		Keywords.getWebElement("xpath", File_utils.getLocator("homepage.Company_Name")).sendKeys("Selenium Testing");
		Keywords.getWebElement("xpath", File_utils.getLocator("homepage.Email")).sendKeys("mayurideshmukh989@gmail.com");
		Keywords.getWebElement("xpath", File_utils.getLocator("homepage.Contact")).sendKeys("2345678912");
		Keywords.getWebElement("xpath", File_utils.getLocator("homepage.password")).sendKeys("Romayu&8987");
		Thread.sleep(20000);
		WebElement Element = Keywords.driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]/parent::div"));
		new Actions(Keywords.driver).click(Element).perform();
		Element.click();
	}

	@Test
	public void join_meeting() throws InterruptedException {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		// HomePage p = new HomePage();
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

	@Test
	public void my_meeting() throws InterruptedException {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		// p.myMeeting();
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

	@Test
	public void Sheduled_meeting() throws InterruptedException {

		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
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
		Keywords.wait1(list);
		Select select1 = new Select(list);
		select1.selectByVisibleText("01");
		Thread.sleep(5000);
//		 Keywords.driver.findElement(By.xpath("//select[@name=\"minute\"]")).click();
//		 select1.selectByVisibleText("29");
//		 Keywords.driver.findElement(By.xpath("//select[@id=\"edit_timezone\"]")).click();
//		 select1.selectByVisibleText("(GMT+05:30) Asia/Kolkata");
//		 Keywords.driver.findElement(By.xpath("//select[@id=\"email_template_language\"]")).click();
//		 select1.selectByVisibleText("English");
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_enable_waiting"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_videoHostSlider_button"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_muteParticepents"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Sheduled_meeting_button1"));
		// Keywords.clickOn("xpath", File_utils.getLocator("//a[text()='Cancel']"));
		WebElement templ = Keywords.driver.findElement(By.xpath("//input[@value=\"Schedule Meeting\"]"));
		Assert.assertTrue(templ.isEnabled());
	}

	@Test
	public void quick_meeting() throws InterruptedException {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		ChromeOptions options = new ChromeOptions();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Quickmeeting_button"));
		Thread.sleep(20000);// assertion
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Quickmeeting_Closebutton"));
		options.addArguments("--use-fake-device-for-media-stream");
		options.addArguments("--use-fake-ui-for-media-stream");
	}

	@Test
	public void my_Account_Upcoming_Meeting() {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Account_tab_button"));
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

	@Test
	public void my_Account_Previous_Meeting() {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Account_tab_button"));
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

	@Test
	public void Sheduled_Webinars() throws InterruptedException, Exception {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Account_tab_button"));
		Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.Webinar_tab_button"));
		Thread.sleep(20000);
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Schedule_Webinar_tab_button"));
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.enter_Wbinar_topic")).sendKeys("Selenium java");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.enter_edit_discription")).sendKeys("Oops concepts");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.enter_invites")).sendKeys("roshandeshmukh45@gmail.com");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.alternate_Hosts")).sendKeys("mayurideshmukh989@gmail.com");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.Schedule_Webinar_start_date")).sendKeys("02/06/2023");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.Schedule_Webinar_start_time")).sendKeys("5.27pm");
		WebElement list = Keywords.driver.findElement(By.cssSelector("select#w_edit_hour"));
		Select select1 = new Select(list);
		select1.selectByVisibleText("01");
		Thread.sleep(5000);
		Keywords.driver.findElement(By.xpath("//input[@id=\"enable_waiting_room_w\"]/parent::label"));
		WebElement Element = Keywords.driver.findElement(By.xpath("(//input[@value='Save Changes'])[1]"));
		new Actions(Keywords.driver).click(Element).perform();
		Element.click();
	}

	@Test
	public void my_Account_Upcoming_Webinars() throws InterruptedException {

		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Account_tab_button"));
		Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.Webinar_tab_button"));
		Thread.sleep(20000);
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.UpcomingWebinar_enter_searchValue")).sendKeys("885a073");
		Thread.sleep(10000);
		WebElement t =Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.UpcomingWebinar_enter_start_date"));
		t.clear();
		t.sendKeys("02/02/2023");
		WebElement s =Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.UpcomingWebinar_enter_end_date"));
		s.clear();
		s.sendKeys("02/19/2023");
		Thread.sleep(20000);
		Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.UpcomingWebinar_search_button"));
		WebElement x = Keywords.driver.findElement(By.cssSelector("a[class$=\"upcoming_webinar\"]"));
		Assert.assertTrue(x.isEnabled());

	}

	@Test
	public void my_Account_Previous_Webinars() throws InterruptedException {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Account_tab_button"));
		Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.Webinar_tab_button"));
		Thread.sleep(2000);
		Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.PreviousWebinar_tab_button"));
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.PreviousWebinar_enter_searchValue")).sendKeys("8fbaf6a");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.PreviousWebinar_enter_start_date")).sendKeys("01/31/2023");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.PreviousWebinar_enter_end_date")).sendKeys("02/02/2023");
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.PreviousWebinar_search_button"));
		WebElement x = Keywords.driver.findElement(By.xpath("(//a[contains(text(),' Search')])[5]"));
		Assert.assertTrue(x.isEnabled());
		
	}

	@Test
	public void my_Account_ProfileInformation() throws InterruptedException {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Account_tab_button"));
		Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.ProfileInformation_button"));
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.ProfileInformation_MeetingId")).sendKeys("345678");
		Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.ProfileInformation_SaveChanges_button"));
		Thread.sleep(2000);
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.ProfileInformation_JoinPersonalMeeting_button"));
		WebElement s=Keywords.driver.findElement(By.xpath("//a[contains(text(),' Join Personal Meeting ')]"));
		Assert.assertTrue(s.isEnabled());
	}

	@Test
	public void my_Account_ChangePassword() {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Account_tab_button"));
		Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.ChangePassword_tab_button"));
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.OldPassword_button")).sendKeys("Romayu#8987");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.NewPassword_button")).sendKeys("Romayu%8987");
		Keywords.getWebElement("Css", File_utils.getLocator("dashboardpage.ConfirmPassword_button")).sendKeys("Romayu%8987");
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Change_button"));
		WebElement s=Keywords.driver.findElement(By.xpath("//button[contains(text(),'Change')]"));
		Assert.assertFalse(s.isEnabled());
		
	}

	@Test
	public void my_Account_LogOut() throws InterruptedException {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Keywords.driver.findElement(By.xpath("//a[@href=\"https://ijmeet.com/myaccount\"]")).click();
		WebElement s=Keywords.driver.findElement(By.xpath("//a[@href=\"https://ijmeet.com/myaccount\"]"));
		Assert.assertTrue(s.isEnabled());
		Keywords.clickOn("Css", File_utils.getLocator("dashboardpage.LogOut_button"));
		Thread.sleep(2000);
	
	}

	@Test
	public void invites() {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Invites_button"));
        WebElement t=Keywords.driver.findElement(By.xpath("//a[@href=\"https://ijmeet.com/invites\"]"));
		Assert.assertTrue(t.isEnabled());

	}

	@Test
	public void application() {
		Keywords.launchUrl("https://ijmeet.com/");
		Keywords.maximizeBrowser("chrome");
		HomePage home = PageFactory.initElements(Keywords.driver, HomePage.class);
		home.signIn();
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.Application_button"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.TermsAndCondition_button"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.AppStoreDownload_button"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.PlayStoreDownload_button"));
		Keywords.clickOn("xpath", File_utils.getLocator("dashboardpage.JoinToBrowsers_button"));
		WebElement t=Keywords.driver.findElement(By.xpath("//a[@href=\"https://ijmeet.com/app\"]"));
		Assert.assertTrue(t.isEnabled());
	}
}