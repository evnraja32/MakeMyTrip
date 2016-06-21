package testcases;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.java.wrapper.interfaces.TargetBrowser;
import wrappers.TestWrapper;

public class IETest extends TestWrapper{
	@BeforeClass
	public void setCapabilities(){
		platform = Platform.WINDOWS;
		browser = BrowserType.IE;
		browserName = TargetBrowser.INTERNETEXPLORER;
	}

	@Test
	public void testSteps() {
		new HomePage()
		.switchToTravelTab();
	}
}
