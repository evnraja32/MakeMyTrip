package pages;

import org.openqa.selenium.WebElement;

import utils.makemytrip_exceptions.DesiredMenuOptionsNotAvailable;
import wrappers.MakeMyWrapper;

public class TravelTab extends MakeMyWrapper{

	public TravelTab() {
		WebElement tab = 
		locateWebElementBy(prop.getProperty("TravelTabs.TabMenu.locatorType"), prop.getProperty("TravelTabs.TabMenu.locatorValue"));
		if(!tab.isDisplayed()){
			try {
				throw new DesiredMenuOptionsNotAvailable();
			} catch (DesiredMenuOptionsNotAvailable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("Successfull....");
		}
	
	}

}
