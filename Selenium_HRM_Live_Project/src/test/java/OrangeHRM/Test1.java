package OrangeHRM;
import org.testng.annotations.Test;
import junit.framework.Assert;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
public class Test1 {

	WebDriver driver = new FirefoxDriver();

	WebDriverWait wait = new WebDriverWait(driver,10);
	
	@BeforeMethod

	  public void beforeMethod() {

		  driver.get("http://alchemy.hguy.co/orangehrm");

	  }
  @Test
  public void check() {

	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInPanelHeading")));
	  String actualtitle=driver.getTitle();

	  String expectedtitle="OrangeHRM";
	  Assert.assertEquals(expectedtitle,actualtitle);
      }
  @AfterMethod

  public void afterMethod() {

	  driver.close();

  }
}

