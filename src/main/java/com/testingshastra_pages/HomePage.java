package com.testingshastra_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.testingshastra_keywords.Keywords;
import com.testingshastra_utils.File_utils;

public class HomePage {
	
@FindBy(xpath="//a[contains(text(),'Sign In')]")
public WebElement signIn;

public void signIn() {
	Keywords.signInPage(signIn);
}

@FindBy(xpath="//div[@id='j_meeting_tab']")
public WebElement join_meeting;

public void clickOnjoinMeeting() 
{
	join_meeting.click();
}

@FindBy(xpath="//div[@id='My_Meetingsapps_tab']")
public WebElement my_meeting;

public void myMeeting() {
	my_meeting.click();
}
@FindBy(xpath="")
public WebElement upcoming_Meeting;

public void upcomingMeeting() {
	upcoming_Meeting.click();
}
}