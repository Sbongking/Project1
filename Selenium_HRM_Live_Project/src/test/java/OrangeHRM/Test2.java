package OrangeHRM;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);

	  @BeforeMethod

	  public void beforeMethod() {

		  driver.get("http://alchemy.hguy.co/orangehrm");
		  }
  @Test

  public void check() {

	  String title = driver.getTitle();
      System.out.println("Title is: " + title);

	  WebElement imgurl = driver.findElement(By.xpath("//img[@src=\"/orangehrm/symfony/web/webres_5d69118beeec64.10301452/themes/default/images/login/logo.png\"]"));

	  System.out.println(" url of the header image is" +  imgurl.getAttribute("src"));

        

  }
  @AfterMethod

  public void afterMethod() {

	  driver.close();

  }

}