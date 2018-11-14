package Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SupportLib.ElementsAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class getHelpPageAndroid extends ElementsAction implements getHelpPage {

	
	 @SuppressWarnings("rawtypes")
	public getHelpPageAndroid(AndroidDriver driver) {
		 	super(driver);
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	        boolean isPageVisible = isElementVisible(getHelpScreenTitle);
	        if (!isPageVisible) {
	            throw new RuntimeException("GetHelp Page is not ready");
	        }
	    }

	@Override
	public void verifyElementsInGetHelpPage() {
		Assert.assertTrue(isElementVisible(getHelpScreenTitle),"Verify if 'Get Help' screen title is displayed");
	}
	
	@FindBy(id = "action_bar")
	public MobileElement getHelpScreenTitle;
}
