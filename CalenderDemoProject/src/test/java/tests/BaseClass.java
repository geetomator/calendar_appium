package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

@Listeners(listners.TestNGListeners.class)
public class BaseClass {
	AppiumDriver<MobileElement> driver;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;

	@BeforeTest
	public void setup() {
		htmlReporter = new ExtentSparkReporter("extent.html");
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		try {

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_30");
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			caps.setCapability("appPackage", "com.google.android.calendar");
			caps.setCapability("appActivity", "com.android.calendar.LaunchActivity");

			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, caps);
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

		} catch (Exception exp) {

			System.out.println("Cause is :" + exp.getCause());
			System.out.println("Message is :" + exp.getMessage());
			exp.printStackTrace();

		}

	}

	@AfterTest
	public void teardown() {
		//driver.close();
		//driver.quit();
		extent.flush();

	}

}
