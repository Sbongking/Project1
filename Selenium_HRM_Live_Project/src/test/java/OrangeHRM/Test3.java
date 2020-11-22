

package OrangeHRM;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Test3 {
	  WebDriver driver = new FirefoxDriver();
	  WebDriverWait wait;
	  WebElement userName;
	  WebElement password;
	  WebElement login;
	  WebElement loggedIn;

	

  @BeforeMethod

  public void beforeMethod() {
	  driver.get("http://alchemy.hguy.co/orangehrm");
	  wait = new WebDriverWait(driver,10);
	  userName = driver.findElement(By.id("txtUsername"));
	  password = driver.findElement(By.id("txtPassword"));
	  login = driver.findElement(By.id("btnLogin"));

  }
  @Test
  public void check() {

	  userName.sendKeys("orange");
	  password.sendKeys("orangepassword123");
	  login.click();

	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));

	  Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());

  }
  @AfterMethod

  public void afterMethod() {

	  driver.close();

  }
}

