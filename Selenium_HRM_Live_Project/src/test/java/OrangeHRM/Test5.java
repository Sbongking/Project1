package OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Test5 {
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	Actions actions = new Actions(driver);
	
	
	  @BeforeMethod
  public void beforeMethod() {
	  driver.get("http://alchemy.hguy.co/orangehrm");
  }
	
  @Test
  public void check() {
	  WebElement username=driver.findElement(By.id("txtUsername"));
	  WebElement password=driver.findElement(By.id("txtPassword"));
	  username.sendKeys("orange");
	  password.sendKeys("orangepassword123");

	  driver.findElement(By.id("btnLogin")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));
	  WebElement myinfo=driver.findElement(By.cssSelector("#menu_pim_viewMyDetails"));
	  actions.doubleClick(myinfo).perform();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'viewPersonalDetails')]")));

	  driver.findElement(By.xpath("//a[contains(@href,'viewPersonalDetails')]")).click();
	  
	  driver.findElement(By.id("btnSave")).click();
	  Random rand = new Random();
	  int int1 = rand.nextInt(10000);
	  int int2 = rand.nextInt(10000);
	  driver.findElement(By.id("personal_txtEmpFirstName")).clear();
	  driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Subho"+int1);
	  driver.findElement(By.id("personal_txtEmpLastName")).clear();
	  driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Mridha"+int2);
	  driver.findElement(By.id("personal_optGender_1")).click();
	  WebElement nationality=driver.findElement(By.id("personal_cmbNation"));
	  Select dropdown=new Select(nationality);
	  dropdown.selectByVisibleText("Indian");  
	  driver.findElement(By.id("personal_DOB")).clear();
	  driver.findElement(By.id("personal_DOB")).sendKeys("1993-04-08");

	  driver.findElement(By.id("btnSave")).click();
	  	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
