package Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SupportLib.ElementsAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class getHelpPageiOS extends ElementsAction implements getHelpPage {

	ElementsAction actions;
	
	 public getHelpPageiOS(IOSDriver driver) {
		super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        actions=new ElementsAction(driver);
        boolean isPageVisible = actions.isElementVisible(getHelpScreenTitle);
        if (!isPageVisible) {
            throw new RuntimeException("GetHelp Page is not ready");
        }	        
	}

	@Override
	public void verifyElementsInGetHelpPage() {
		Assert.assertTrue(actions.isElementVisible(getHelpScreenTitle),"Verify if 'Get Help' screen title is displayed");
	}
	
	@FindBy(id = "action_bar")
	public MobileElement getHelpScreenTitle;
}
