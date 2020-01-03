package com.anubhav.calculator.CalculatorTestingApium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class Calculator2 {
	AppiumDriver<MobileElement> driver;
	
@BeforeClass
public void setUp() throws MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("deviceName","Moto G5s plus");
//	capabilities.setCapability("deviceId", "192.168.1.4:5555");
	capabilities.setCapability("udid","ZY32299VD6");
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("platformVersion","8.1.0");

	//capabilities.setCapability("noReset","true");
   capabilities.setCapability("appPackage", "com.google.android.calculator");
 // capabilities.setCapability("appPackage", "com.android.bbkcalculator");
// This package name of your app (you can get it from apk info app)
	capabilities.setCapability("appActivity","com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	System.out.println("Application Started.....");
}

@Test
public void testCal() throws Exception {
   //locate the Text on the calculator by using By.name()
	driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
    driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
    driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
    driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
   //locate the edit box of the calculator by using By.tagName()
     MobileElement results=driver.findElement(By.id("com.google.android.calculator:id/result_final"));
	//Check the calculated value on the edit box
     assert results.getText().equals("13"):"Actual value is : "+results.getText()+" did not match with expected value: 13";

}


@AfterClass
public void teardown(){
	//close the app
	driver.quit();
}
}