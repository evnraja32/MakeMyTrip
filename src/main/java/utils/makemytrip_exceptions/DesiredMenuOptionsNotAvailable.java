package utils.makemytrip_exceptions;

@SuppressWarnings("serial")
public class DesiredMenuOptionsNotAvailable extends Exception {

	public DesiredMenuOptionsNotAvailable() {
		/*This class will be called when certain Options we expected are not visible in the page 
		 */
		System.err.println("The option you are refering to is not available in this page");
	}

}
