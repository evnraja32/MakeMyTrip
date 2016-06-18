package wrappers;

import org.openqa.selenium.Platform;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class TestWrapper extends WrapperGuide {

	@BeforeSuite
	public void beforeSuite() {
		loadObjects("google");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@BeforeMethod
	public void beforeMethod() {
		platform = Platform.WINDOWS;
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
