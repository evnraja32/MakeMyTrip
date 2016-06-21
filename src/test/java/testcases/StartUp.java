package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.java.wrapper.interfaces.TargetBrowser;
import wrappers.TestWrapper;

public class StartUp extends TestWrapper{
	@BeforeClass
	public void setCapabilities(){
//		platform = Platform.WINDOWS;
//		browser = BrowserType.CHROME;
//		version = "51";
		browserName = TargetBrowser.CHROME;
	}

	@Test
	public void testSteps() {
		new HomePage()
		.switchToTravelTab();
	}
}
