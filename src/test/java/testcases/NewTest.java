package testcases;

import org.testng.annotations.Test;

import pages.HomePage;
import wrappers.TestWrapper;

public class NewTest extends TestWrapper{
  @Test
  public void f() {
	  new HomePage()
	  .switchToTravelTab();
  }
}
