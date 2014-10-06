package pen;



import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Olympus_gen {
  private WebDriver driver;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://cameras.olympus.com/en-us/omd/em10/specifications";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/");
    try {
      assertEquals("Powerful performance and premium, super sleek design make the OM-D E-M10 a perfect fit for those who appreciate attention to detail.", driver.findElement(By.cssSelector("p")).getText());
      System.out.println("WOW, text matched 100%");
    } catch (Error e) {
      verificationErrors.append(e.toString());
        System.out.println("Error found, text did not match");
    }
    
    try {
        assertTrue(isElementPresent(By.cssSelector("div.panelImage > img")));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
  }

  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      System.out.println("Panel image found, test passed");
	      return true;
	    } catch (NoSuchElementException e) {
	      System.out.println("NO PANEL image found, test FAILED");
	      return false;
	    }
	  }

@After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}