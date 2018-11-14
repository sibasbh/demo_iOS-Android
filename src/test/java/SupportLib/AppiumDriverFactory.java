package SupportLib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AppiumDriverFactory {
	
	public enum OperatingSystem {
        ANDROID,
        IOS,
    }
	
	public static OperatingSystem executionOS = OperatingSystem.ANDROID ;
	
	   public static AppiumDriver<WebElement> driver;
	  // public static AppiumDriverFactory instance = new AppiumDriverFactory();
	   public WebDriverWait wait = new WebDriverWait(driver, 30);

	    public static void start() throws MalformedURLException {
	        if (driver != null) {
	            return;
	        }
	        DesiredCapabilities cap = new DesiredCapabilities();
	        switch(executionOS){
	            case ANDROID:
	            	File appDir = new File("src");
	                File app = new File (appDir , "MyTelstra.apk");	                 
	         	    cap.setCapability(MobileCapabilityType.PLATFORM,MobilePlatform.ANDROID);
	         	    cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
	         	    cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
	         	    cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	         	    driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	                break;
	            case IOS:
	            	appDir = new File("src");
	                app = new File (appDir , "MyTelstra.ipa");	                 
	         	    cap.setCapability(MobileCapabilityType.PLATFORM,MobilePlatform.IOS);
	         	    cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iOS Siumlator");
	         	    cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
	         	    cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	         	    driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	                break;
	        }
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    }
	    
	    
	    public static void stop() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
}
