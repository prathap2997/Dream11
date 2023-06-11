package com.Dream11;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass {

	public static AndroidDriver driver;
	public static  AndroidDriver appLaunch() throws MalformedURLException {
		String appPath = System.getProperty("user.dir");
		DesiredCapabilities cap = new DesiredCapabilities();
	
//		cap.setCapability("platformVersion", "");
//		cap.setCapability("udid", "");
		//Use this in case of real device
		
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:app", appPath+"\\dream11.apk");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("appium:enforceAppInstall", true);
		cap.setCapability("appium:appWaitForLaunch","false");
		URL u = new URL("http://0.0.0.0:4723/wd/hub");
		 driver= new AndroidDriver(u,cap);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 return driver;

	}
	
	public static void clickElement(WebElement ref) {
		ref.click();
	}
	
	public static void clickAndSendKeys(WebElement ref,String input) {
	     ref.click();
	     ref.sendKeys(input);

	}
	
	public static void swipeDown(WebElement ref) {
		Dimension size= driver.manage().window().getSize();
		int startY=(int)(size.height*0.8);
		int endY=(int)(size.height*0.1);
		int centreX=size.width/2;
		do {
			new TouchAction(driver).press(PointOption.point(centreX,startY))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(centreX, endY))
			.release()
			.perform();
			
		} while (ref==null);
		
	}
	
}
