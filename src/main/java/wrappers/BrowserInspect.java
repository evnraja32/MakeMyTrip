package wrappers;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface BrowserInspect {
	
	
	/**@author E V N Raja
	 * 
	 * @param locatorType- {@value - id, name, classname, linktext, partiallinktext, tagname, xpath, cssselector}
	 * @param locatorValue
	 * @return
	 */
	abstract WebElement locateWebElementBy(String locatorType, String locatorValue);
	
	abstract List<WebElement> locateWebElementsListBy(String locatorType, String locatorValue);

	



}