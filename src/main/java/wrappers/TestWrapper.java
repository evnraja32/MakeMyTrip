package wrappers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.browserinterface.TargetBrowser;

public class TestWrapper extends MakeMyWrapper {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Initiate Test Reporter");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test Start Test Case in reporter");
	}

	@BeforeMethod
	public void beforeMethod() {
		platform = Platform.WINDOWS;
		browser = BrowserType.CHROME;
		loadObjects("object");
		launchBrowser(TargetBrowser.CHROME);
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}


	@AfterMethod
	public void afterMethod(){
		quitTheBrowser();
	}


	@DataProvider
	public String[] fetchData() {
		return new String[] {

		};
	}

}
