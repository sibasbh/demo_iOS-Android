package Keywords;

import org.testng.annotations.Test;

public class GetHelpFeatures extends BaseTestCaseFile {
	@Test
	public void verifyGetHelpFeatures() {
		navigateTab.goToPage(navigateTab.GET_HELP_TAB);
		getHelp.verifyElementsInGetHelpPage();	
	}
}
