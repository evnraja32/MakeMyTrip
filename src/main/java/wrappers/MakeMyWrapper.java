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

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.java.wrapper.interfaces.Browser;
import utils.java.wrapper.interfaces.BrowserInspect;
import utils.java.wrapper.interfaces.LocatorType;
import utils.java.wrapper.interfaces.TargetBrowser;

/**
 * @author RAJA
 *
 */
public class MakeMyWrapper implements Browser, BrowserInspect{
	protected static Properties prop = new Properties();;
	protected String siteURL, remoteHUB,driverpath;
	protected String browser,version;
	protected Platform platform;
	protected static RemoteWebDriver driver;
	protected String parentWindow;
	protected WebElement element;
	/**
	 * 
	 */
	public MakeMyWrapper() {
		loadObjects("config");
		remoteHUB = prop.getProperty("HUB");
		siteURL = prop.getProperty("URL");
		driverpath=prop.getProperty("driverpath");
	}

	@Override
	public void loadObjects(String objectFileName) {
		// TODO Auto-generated method stub
		
		try {
			prop.load(new FileInputStream(new File("./src/main/java/properties/"+objectFileName+".properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean launchBrowser(TargetBrowser browserName) {
		try{
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setPlatform(platform);
			dc.setBrowserName(browser);
			dc.setVersion(version);

			if(browserName == TargetBrowser.FIREFOX){
				driver = new FirefoxDriver();
			}else if(browserName == TargetBrowser.CHROME){
				System.setProperty("webdriver.chrome.driver", driverpath+"chromedriver.exe");
		        // To remove message "You are using an unsupported command-line flag: --ignore-certificate-errors.
		        // Stability and security will suffer."
		        // Add an argument 'test-type'
//		        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		        ChromeOptions options = new ChromeOptions();
//		        options.addArguments("test-type");
//		        capabilities.setCapability("chrome.binary",  driverpath+"chromedriver.exe");
//		        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//
//		        driver = new ChromeDriver(capabilities);
				
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
			browserWait(30); 
			driver.get(siteURL);
			parentWindow = driver.getWindowHandle();
			System.out.println(driver.getTitle());
			return true;

		}catch(WebDriverException e){
			e.printStackTrace();
		} 
//		catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		return false;
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

	public By by(String locatorType, String locatorValue) {
		System.out.println(locatorType+" \n"+LocatorType.id);
		
		if(locatorType.equals("id")){
			return By.id(locatorValue);
		}else if(locatorType.equals(LocatorType.name)){
			return By.name(locatorValue);
		}else if(locatorType.equals(LocatorType.className)){
			return By.className(locatorValue);
		}else if(locatorType.equals(LocatorType.cssSelector)){
			return By.cssSelector(locatorValue);
		}else if(locatorType.equals(LocatorType.linkText)){
			return By.linkText(locatorValue);
		}else if(locatorType.equals(LocatorType.partialLinkText)){
			return By.partialLinkText(locatorValue);
		}else if(locatorType.equals(LocatorType.tagName)){
			return By.tagName(locatorValue);
		}else if(locatorType.equals(LocatorType.xpath)){
			return By.xpath(locatorValue);
		}

		return null;
	}

	@Override
	public WebElement locateWebElementBy(String locatorType, String locatorValue) {
		try{
			element = driver.findElement(by(locatorType,locatorValue)); 
		}catch(NoSuchElementException nse){
			nse.printStackTrace();
		}catch(StaleElementReferenceException sere){
			sere.printStackTrace();
		}
		return element;
	}

	@Override
	public List<WebElement> locateWebElementsListBy(String locatorType, String locatorValue) {
		try{
			return driver.findElements(by(locatorType,locatorValue)); 
		}catch(NoSuchElementException nse){
			nse.printStackTrace();
		}catch(StaleElementReferenceException sere){
			sere.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean verifyPageTitle(String pageTitle) {
		String title = driver.getTitle();
		if(title.equals(pageTitle)){
			return true;
		}
		return false;
	}


}
