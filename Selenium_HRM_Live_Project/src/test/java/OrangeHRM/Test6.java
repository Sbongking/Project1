package OrangeHRM;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Test6 {

	WebDriverWait wait;
	WebDriver driver;

	  @BeforeMethod
	  public void beforeMethod() {
		  driver = new FirefoxDriver();
		  wait = new WebDriverWait(driver,10);
		  driver.get("http://alchemy.hguy.co/orangehrm");
	  }
	  
  @Test

  public void f() {

	  WebElement username = driver.findElement(By.id("txtUsername"));
	  WebElement password = driver.findElement(By.id("txtPassword"));
      username.sendKeys("orange");
	  password.sendKeys("orangepassword123");
	  
	  driver.findElement(By.id("btnLogin")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_directory_viewDirectory")));
      driver.findElement(By.id("menu_directory_viewDirectory")).click();
      String txt = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1")).getText();
      txt.equals("Search Directory");

  }

  
  @AfterMethod

  public void afterMethod() {
	  driver.close();
  }
}

