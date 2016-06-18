package pages;

import utils.makemytrip_exceptions.UnidentifiedPageEncountered;
import wrappers.WrapperGuide;

public class HomePage extends WrapperGuide{

	public HomePage() {
		/*To confirm that we have successfully landed into home we 
		 * verify the title of the page 
		 */
		if(!verifyPageTitle("MakeMyTrip, India's No 1 Travel Site | Book Flights, Hotels, Holiday Packages & Bus Tickets")){
			try {
				throw new UnidentifiedPageEncountered();
			} catch (UnidentifiedPageEncountered e) {
				e.printStackTrace();
			}
		}
	}

}
