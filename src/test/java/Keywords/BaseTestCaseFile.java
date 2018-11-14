package Keywords;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.getHelpPage;
import Pages.getHelpPageAndroid;
import Pages.getHelpPageiOS;
import Pages.navigateTabPage;
import Pages.navigateTabPageAndroid;
import Pages.navigateTabPageiOS;
import SupportLib.AppiumBaseClass;
import SupportLib.AppiumDriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseTestCaseFile extends AppiumBaseClass{
		
	getHelpPage getHelp;
	navigateTabPage navigateTab;
	
    @SuppressWarnings("rawtypes")
	@BeforeClass
    public void setUp() throws Exception {
        AppiumDriverFactory.start();
        switch (AppiumDriverFactory.executionOS) {
            case ANDROID:
            	navigateTab = new navigateTabPageAndroid((AndroidDriver) driver());
            	getHelp = new getHelpPageAndroid((AndroidDriver) driver());
                break;
            case IOS:
            	navigateTab = new navigateTabPageiOS((IOSDriver) driver());
            	getHelp = new getHelpPageiOS((IOSDriver) driver());
                break;

        }
    }

    @AfterClass
    public void tearDown() {
    	AppiumDriverFactory.stop();
    }
}

