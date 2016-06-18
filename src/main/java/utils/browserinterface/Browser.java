package utils.browserinterface;

public interface Browser {
	/** @author E V N Raja
	 * The method loadObjects should load the object properties saved in object.properties file
	 * contents of object.properties file are the locators which we should be using 
	 * for locating the web elements should be saved in this properties file
	 * 
	 * {@value
	 * Login.UserName.Id=username
	 * Login.Password.Id=password
	 * Login.LoginButton.Class=decorativeSubmit
	 * }
	 * 
	 */
	void loadObjects(String objectFileName);
	/** @author E V N Raja
	 * The launchBrowser method should launch the desired browser
	 * with DesiredCapabilities followed by loading the Url
	 * and then maximises the window, prepares the WindowHandle() of the parent window
	 * and stores it for future use returns a boolean value - true after successful  launch of site
	 *  
	 * 
	 * @see DesiredCapabilites
	 * @param browser
	 * {@value - chrome, firefox, default - ie}
	 * @return boolean
	 */
	boolean launchBrowser(TargetBrowser browser);
	/** @author E V N Raja
	 * In this implicit wait is invoked to instruct the browser to wait desired time
	 * @param timeInSec
	 */
	void browserWait(int timeInSec);
	/** @author E V N Raja
	 * In case of more than 1 session is in open this method is used to close the
	 * current session. In case of 1 session available this method will not close
	 * the browser session
	 */
	void closeTheWindow();
	/** @author E V N Raja
	 * This will close the browser. All the window sessions which are running will be closed
	 */
	void quitTheBrowser();

}
