package SupportLib;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public abstract class AppiumBaseClass {
	protected AppiumDriver<WebElement> driver() {
		return AppiumDriverFactory.driver;
	}
}
