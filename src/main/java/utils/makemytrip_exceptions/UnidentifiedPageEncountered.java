package utils.makemytrip_exceptions;

@SuppressWarnings("serial")
public class UnidentifiedPageEncountered extends Exception{

	public UnidentifiedPageEncountered() {
		/*This class will be called when any navigation happened to unexpected page
		 * 
		 */
		System.err.println("This is not your intended page");
	}

}
