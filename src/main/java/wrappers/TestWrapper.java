package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.java.wrapper.interfaces.TargetBrowser;

public class TestWrapper extends MakeMyWrapper {
	protected static TargetBrowser browserName;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Initiate Test Reporter");
		loadObjects("object");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test Do nothing");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Start Test Case in the reporter.");
		launchBrowser(browserName);
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite end the reporter");
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
