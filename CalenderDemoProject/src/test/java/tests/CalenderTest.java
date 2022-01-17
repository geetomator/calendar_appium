package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;

@Listeners(listners.TestNGListeners.class)
public class CalenderTest extends BaseClass {

	@Parameters({"email1"})
	@Test
	public void fridayMeeting(String email1) {

		extendreportStart();

		System.out.println("calender app started");

		navigateToEvent();
		createEvent();
		setTimeforFriday();
		addAttendes(email1);
		saveReccuringEventforFriday();
		assertFridaymeeting();
		
		

	}
	
	@Parameters({"email1"})
	@Test
	public void mondayStandUp(String email1) {
		extendreportStart();
		System.out.println("calender app started");

		createEvent();
		setTimeforMonday();
		addAttendes(email1);
		saveEventforMonday();
		assertMondaymeeting();
		

	}
	
	public void extendreportStart()
	{
		// creates a toggle for the given test, adds all log events under it
				ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
				// log(Status, details)
				test.log(Status.INFO, "This step shows usage of log(status, details)");

				// info(details)
				test.info("This step shows usage of info(details)");

				// log with snapshot
				test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

				// test with snapshot
				test.addScreenCaptureFromPath("screenshot.png");
	}

	public void navigateToEvent() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		MobileElement googlecalenderstart = (MobileElement) driver
				.findElementById("com.google.android.calendar:id/header");
	
		if (googlecalenderstart.isDisplayed()) {
			MobileElement calendarTagLine = (MobileElement) driver
					.findElementById("com.google.android.calendar:id/body_text_center");
			String calTagLine = calendarTagLine.getText();
			calTagLine.equalsIgnoreCase("Make the most of every day.");

			MobileElement nextpage = (MobileElement) driver.findElementByAccessibilityId("next page");
			nextpage.click();

		}

		MobileElement secondScreen = (MobileElement) driver.findElementById("com.google.android.calendar:id/header");

		if (secondScreen.isDisplayed()) {
			MobileElement secondnextpage = (MobileElement) driver.findElementByAccessibilityId("next page");
			secondnextpage.click();
		}

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calendar:id/done_button")));

		MobileElement gotit = (MobileElement) driver.findElementById("com.google.android.calendar:id/done_button");
		gotit.click();
	}
	
	public void createEvent() {

		MobileElement createEventButton = (MobileElement) driver
				.findElementByAccessibilityId("Create new event and more");
		createEventButton.click();

		MobileElement event = (MobileElement) driver.findElementByAccessibilityId("Create new event and more");
		event.click();
	}
	
	public void saveReccuringEventforFriday() {
		 MobileElement el3 = (MobileElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.Button[2]/android.widget.LinearLayout");
		el3.click();

		MobileElement el4 = (MobileElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[6]");
		el4.click();

		MobileElement selectday = (MobileElement) driver.findElementByAccessibilityId("Friday");
		selectday.click();

		MobileElement deselectday = (MobileElement) driver.findElementByAccessibilityId("Tuesday");
		deselectday.click();

		MobileElement customendDate = (MobileElement) driver.findElementById("com.google.android.calendar:id/date_duration_text");
		customendDate.click();
		
		MobileElement todaydate = (MobileElement) driver.findElementById("com.google.android.calendar:id/date_duration_text");
		todaydate.click();
		MobileElement nextmonth = (MobileElement) driver.findElementByAccessibilityId("Next month");
		nextmonth.click();
		nextmonth.click();
		
		MobileElement endMonthapril = (MobileElement) driver.findElementByAccessibilityId("17 April 2022");
		endMonthapril.click();
		
		MobileElement okdate = (MobileElement) driver.findElementById("android:id/button1");
		okdate.click();
		
		MobileElement setfrequency = (MobileElement) driver.findElementById("com.google.android.calendar:id/frequency");
		setfrequency.click();
		
		MobileElement week = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
		week.click();
		
		MobileElement customRecourencedone = (MobileElement) driver.findElementById("com.google.android.calendar:id/right_button");
		customRecourencedone.click();
		
		MobileElement eventDes = (MobileElement) driver.findElementById("com.google.android.calendar:id/title");
		eventDes.sendKeys("Workshop");

		MobileElement save = (MobileElement) driver.findElementById("com.google.android.calendar:id/save");
		save.click();
		
		MobileElement sendnotification = (MobileElement) driver.findElementById("android:id/button1");
		sendnotification.click();
	}

	public void setTimeforFriday() {
		
		MobileElement starttime = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@content-desc,'Start time')]");
		starttime.click();
		
		MobileElement amlabel = (MobileElement) driver.findElementById("android:id/am_label");
		amlabel.click();

		MobileElement amtime = (MobileElement) driver.findElementByAccessibilityId("9");
		amtime.click();

		MobileElement amminutes = (MobileElement) driver.findElementByAccessibilityId("30");
		amminutes.click();
		MobileElement el17 = (MobileElement) driver.findElementById("android:id/button1");
		el17.click();
		MobileElement endtime = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@content-desc,'End time')]");
		endtime.click();
		MobileElement pmButton = (MobileElement) driver.findElementById("android:id/pm_label");
		pmButton.click();
		MobileElement pmTime = (MobileElement) driver.findElementByAccessibilityId("1");
		pmTime.click();
		MobileElement pmMinutes = (MobileElement) driver.findElementByAccessibilityId("0");
		pmMinutes.click();
		MobileElement okButton = (MobileElement) driver.findElementById("android:id/button1");
		okButton.click();
	}
	
	public void addAttendes(String email1) {
		
		MobileElement addPeople = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Add people\"]/android.widget.FrameLayout");
		addPeople.click();
		MobileElement addListPeople = (MobileElement) driver.findElementById("com.google.android.calendar:id/search_text");
		addListPeople.sendKeys(email1);
		MobileElement selectperson = (MobileElement) driver.findElementById("com.google.android.calendar:id/container");
		selectperson.click();
		MobileElement completeAdd = (MobileElement) driver.findElementById("com.google.android.calendar:id/right_button");
		completeAdd.click();
	}
	
	public void assertFridaymeeting() {
		
		MobileElement worshopMeet = (MobileElement) driver.findElementByXPath("(//android.view.View[@content-desc=\"Workshop, 9:30 AM – 1:00 PM\"])[2]");
		worshopMeet.click();
		MobileElement recurrence = (MobileElement) driver.findElementById("com.google.android.calendar:id/recurrence");
		String actualmeeting = recurrence.getText();
		actualmeeting.equalsIgnoreCase("Repeats weekly on Friday; until 4/17");
		
		System.out.println("Friday meeting is correctly set");
		MobileElement close = (MobileElement) driver.findElementByAccessibilityId("Close");
		close.click();
	}
	
	public void saveEventforMonday() {
		 MobileElement el3 = (MobileElement) driver.findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.Button[2]/android.widget.LinearLayout");
			el3.click();

			MobileElement el4 = (MobileElement) driver.findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[6]");
			el4.click();

			MobileElement selectday = (MobileElement) driver.findElementByAccessibilityId("Monday");
			selectday.click();
			
			MobileElement deselectday = (MobileElement) driver.findElementByAccessibilityId("Tuesday");
			deselectday.click();
			

			MobileElement customendDate = (MobileElement) driver.findElementById("com.google.android.calendar:id/date_duration_text");
			customendDate.click();
			
			MobileElement todaydate = (MobileElement) driver.findElementById("com.google.android.calendar:id/date_duration_text");
			todaydate.click();
			MobileElement nextmonth = (MobileElement) driver.findElementByAccessibilityId("Next month");
			nextmonth.click();
			nextmonth.click();
			
			MobileElement endMonthapril = (MobileElement) driver.findElementByAccessibilityId("17 April 2022");
			endMonthapril.click();
			
			MobileElement okdate = (MobileElement) driver.findElementById("android:id/button1");
			okdate.click();
			
			MobileElement setfrequency = (MobileElement) driver.findElementById("com.google.android.calendar:id/frequency");
			setfrequency.click();
			
			MobileElement week = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
			week.click();
			
			MobileElement customRecourencedone = (MobileElement) driver.findElementById("com.google.android.calendar:id/right_button");
			customRecourencedone.click();
			
			MobileElement eventDes = (MobileElement) driver.findElementById("com.google.android.calendar:id/title");
			eventDes.sendKeys("Stand UP");

			MobileElement save = (MobileElement) driver.findElementById("com.google.android.calendar:id/save");
			save.click();
			
			MobileElement sendnotification = (MobileElement) driver.findElementById("android:id/button1");
			sendnotification.click();
	}
	
public void setTimeforMonday() {
		
		MobileElement starttime = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@content-desc,'Start time')]");
		starttime.click();
		
		MobileElement amlabel = (MobileElement) driver.findElementById("android:id/am_label");
		amlabel.click();

		MobileElement amtime = (MobileElement) driver.findElementByAccessibilityId("9");
		amtime.click();

		MobileElement amminutes = (MobileElement) driver.findElementByAccessibilityId("30");
		amminutes.click();
		MobileElement el17 = (MobileElement) driver.findElementById("android:id/button1");
		el17.click();
		MobileElement endtime = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@content-desc,'End time')]");
		endtime.click();
		
		MobileElement endTime = (MobileElement) driver.findElementByAccessibilityId("9");
		endTime.click();
		MobileElement endMinutes = (MobileElement) driver.findElementByAccessibilityId("45");
		endMinutes.click();
		MobileElement okButton = (MobileElement) driver.findElementById("android:id/button1");
		okButton.click();
	}

public void assertMondaymeeting() {
	MobileElement scrumMeet = (MobileElement) driver.findElementByXPath("(//android.view.View[@contains(@content-desc,'Stand UP')]");
	scrumMeet.click();
	
	MobileElement recurrence = (MobileElement) driver.findElementById("com.google.android.calendar:id/recurrence");
    String actualmeeting = recurrence.getText();
	actualmeeting.equalsIgnoreCase("Repeats weekly on Monday; until 4/17");
	
	System.out.println("Monday Scrum Call meeting is correctly set");
	MobileElement close = (MobileElement) driver.findElementByAccessibilityId("Close");

	close.click();
	
	
	
}

}