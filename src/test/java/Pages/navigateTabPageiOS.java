
package Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SupportLib.ElementsAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class navigateTabPageiOS extends ElementsAction implements navigateTabPage{
		
	//public static final String GET_HELP_TAB = "Get Help";
	private IOSDriver driver;
	
	@SuppressWarnings("rawtypes")
	public navigateTabPageiOS(IOSDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public ElementsAction goToPage(String pageName) {
		ElementsAction pageToGoTo = null;
        if (pageName == null) {
            throw new NullPointerException("Input pageName is must not be null!");
        }
        switch (pageName) { 
            case GET_HELP_TAB:
            	Assert.assertTrue(isElementVisible(btnGetHelpTab), "Verify 'Get Help' Tab is displayed ");
            	btnGetHelpTab.click();
			    pageToGoTo = new getHelpPageiOS(driver);
                break;
            default:
                throw new RuntimeException("There is no such '" + pageName + "'!");
        }
        return pageToGoTo;
    }
	
	@FindBy(id = "action_bar")
	public MobileElement btnGetHelpTab;

}
