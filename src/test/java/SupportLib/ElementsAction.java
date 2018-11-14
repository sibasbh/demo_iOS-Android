package SupportLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ElementsAction {
	public FluentWait<WebDriver> wait;
	
	public ElementsAction(AppiumDriver driver) {
		 this.wait = new FluentWait(driver);

	}


	public boolean isElementVisible(MobileElement element) {
        try {
            //String newXPath = convertXPath(xpath);
            boolean isVisible = false;
            boolean isElementVisible = false;
            boolean isOnScreen = false;
            boolean isHidden = false;
            try {
            	
				wait.until(ExpectedConditions.visibilityOf(element));
				
                    isOnScreen = element.isDisplayed();
                    isHidden = element.isEnabled();
                    isVisible = element.isDisplayed();
                
            } catch (RuntimeException re) {
                // no need to handle exception
            }
            isElementVisible = ((isVisible || !isHidden) && (isOnScreen));
            return isElementVisible;
        } catch (Exception ex)
        {
        	return false;
        	
        }
     
    }
}
