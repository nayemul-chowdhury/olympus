package pen;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Olympus_pen {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://qa.olympuspen.ny.akqa.com/en-us";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testOlympusPen() throws Exception {
    driver.get(baseUrl + "/en-us");
    try {
      assertEquals("Introducing The PEN Lite E-PL7\nÑThe New Smart. >", driver.findElement(By.cssSelector("span.tout-text")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.cssSelector("div.shadow")));
    try {
      assertTrue(isElementPresent(By.cssSelector("a.panel-image-link.play-video > img.logo")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("span.tout-text")).click();
    try {
      assertTrue(isElementPresent(By.cssSelector("div.shadow")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("div.panelContent")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("#connect-and-control > div.commercecta > a.preorder")).click();
    driver.findElement(By.cssSelector("#the-superior-selfie > div.commercecta > a.preorder")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
