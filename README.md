<div id="top"></div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This code contains mobile automation code to schedule recurring Google calendar meeting invites


<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

This section lists tools and libraries used:
  
* io.appium
* org.seleniumhq.selenium
* org.testng
* commons-io
* com.aventstack
* maven build
* iTestListener
* ExtentReportListener

  

<!-- ACKNOWLEDGMENTS -->
## Future releases may address


* Passing data from excel using apache poi
* Screenshots for failed test cases using 
    public void onTestFailure(ITestResult result) {
		System.out.println("Test failed**" +result.getName());
		}

<p align="right">(<a href="#top">back to top</a>)</p>
  
  Future revsions may address:
  
  1. Data can be passed from Excel sheet or excel as well using apache poi dependency and creating a reader class.
  
  2. Screenshot for failed test case could have been implented and stored as output:
  
  ```java
public void onTestFailure(ITestResult result) {
System.out.println("Test failed**" +result.getName());
}
      
public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
//Convert web driver object to TakeScreenshot
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//Call getScreenshotAs method to create image file
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
File DestFile=new File(fileWithPath);
//Copy file at destination
FileUtils.copyFile(SrcFile, DestFile);
}
```
 

<p align="right">(<a href="#top">back to top</a>)</p>



