package listners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestNGListeners implements ITestListener {
	AppiumDriver<MobileElement> driver;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test started**" +result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is successful**" +result.getName());
		
	}

	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed**" +result.getName());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test skipped******" +result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Completed******"+context.getName());
		
	}

	
	
	
	

}
