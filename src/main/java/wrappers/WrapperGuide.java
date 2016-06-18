/**
 * 
 */
package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.browserinterface.Browser;
import utils.browserinterface.BrowserInspect;
import utils.browserinterface.TargetBrowser;

/**
 * @author RAJA
 *
 */
public class WrapperGuide implements Browser, BrowserInspect{
	protected static Properties prop;
	protected String siteURL, remoteHUB,driverpath;
	protected String browser,version;
	protected Platform platform;
	protected RemoteWebDriver driver;
	protected String parentWindow;
	/**
	 * 
	 */
	public WrapperGuide() {
		loadObjects("config");
		remoteHUB = prop.getProperty("HUB");
		siteURL = prop.getProperty("URL");
		driverpath=prop.getProperty("driverpath");
	}

	@Override
	public void loadObjects(String objectFileName) {
		// TODO Auto-generated method stub
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/test/java/properties/"+objectFileName+".properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean launchBrowser(TargetBrowser browserName) {
		boolean launchStatus = false;
		try{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(platform);
		dc.setBrowserName(browser);
		dc.setVersion(version);

		if(browserName == TargetBrowser.FIREFOX){
			driver = new FirefoxDriver();
		}else if(browserName == TargetBrowser.CHROME){
			System.setProperty("webdriver.chrome.driver", driverpath+"chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName == TargetBrowser.INTERNETEXPLORER){
			System.setProperty("webdriver.ie.driver", driverpath+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(browserName == TargetBrowser.EDGE){
			System.setProperty("webdriver.edge.driver", driverpath+"MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}else if(browserName == TargetBrowser.REMOTE){
			try {
				driver = new RemoteWebDriver(new URL(remoteHUB),dc);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		driver.manage().window().maximize();
		driver.get(siteURL);
		browserWait(30); 

		
		parentWindow = driver.getWindowHandle();

		launchStatus = true;
		
		}catch(WebDriverException e){
			e.printStackTrace();
		}

		return launchStatus;
	}

	@Override
	public void browserWait(int timeInSec) {
		driver.manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
	}

	@Override
	public void closeTheWindow() {
		driver.close();
	}

	@Override
	public void quitTheBrowser() {
		driver.quit();
	}

	@Override
	public WebElement locateWebElementBy(String locatorType, String locatorValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> locateWebElementsListBy(String locatorType, String locatorValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyPageTitle(String pageTitle) {
		if(driver.getTitle().equals(pageTitle)){
			return true;
		}
		return false;
	}


}
