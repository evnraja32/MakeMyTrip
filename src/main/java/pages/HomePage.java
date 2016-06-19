package pages;

import org.testng.Assert;

import utils.makemytrip_exceptions.UnidentifiedPageEncountered;
import wrappers.MakeMyWrapper;

public class HomePage extends MakeMyWrapper{

	public HomePage() {
		/*To confirm that we have successfully landed into home we 
		 * verify the title of the page 
		 */
	if(verifyPageTitle("MakeMyTrip, India's No 1 Travel Site | Book Hotels, Flights, Holiday Packages & Bus Tickets")
				||verifyPageTitle("MakeMyTrip, India's No 1 Travel Site | Book Flights, Hotels, Holiday Packages & Bus Tickets")){
	System.out.println("Expected page");
	}
	else{
		try {
			throw new UnidentifiedPageEncountered();
		} catch (UnidentifiedPageEncountered e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

	public TravelTab switchToTravelTab(){
		return new TravelTab();
	}

}
