package utils.browserinterface;

public interface BrowserActions {
	/**
	 * @author E V N Raja
	 * 
	 * The clickOnElement() method clicks the identified WebElement
	 * 
	 * @param Weblelement
	 * @return boolean value
	 */
	boolean clickOnElement();
	
	/**
	 * @author E V N Raja
	 * 
	 * The sendKeysToElement method enters text into the Element
	 * 
	 * @param String keysToSend
	 * @return boolean value
	 */
	boolean sendKeysToElement(String keyToSend);
	
	/**
	 * @author E V N Raja
	 * 
	 * The selectDropDownOptionByIndex() select the available options from the DropDown
	 * 
	 * @param int index
	 * @return String value
	 */
	String selectDropDownOptionByIndex(int index);
	
	/**
	 * @author E V N Raja
	 * 
	 * The selectDropDownOptionByVisibleText() select the available options from the DropDown
	 * 
	 * @param String visibleText
	 * @return String value
	 */
	String selectDropDownOptionByVisibleText(String visibleText);
	
	/**
	 * @author E V N Raja
	 * 
	 * The selectDropDownOptionByValue() select the available options from the DropDown
	 * 
	 * @param String visibleText
	 * @return String value
	 */
	String selectDropDownOptionByValue(String value);

}
