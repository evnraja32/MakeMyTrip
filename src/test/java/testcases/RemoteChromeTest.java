package testcases;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.browserinterface.TargetBrowser;
import wrappers.TestWrapper;

public class RemoteChromeTest extends TestWrapper{
	@BeforeClass
	public void setCapabilities(){
		platform = Platform.WINDOWS;
		browser = BrowserType.CHROME;
		browserName = TargetBrowser.REMOTE;
	}

	@Test
	public void testSteps() {
		new HomePage()
		.switchToTravelTab();
	}
}
