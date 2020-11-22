package OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Test4 {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);

	  @BeforeMethod

  public void beforeMethod() {
	  driver.get("http://alchemy.hguy.co/orangehrm");

  }
	//test failing as the user name has already been created
	  
	  
  @Test

  public void check() {

	  WebElement username=driver.findElement(By.id("txtUsername"));
	  WebElement password=driver.findElement(By.id("txtPassword"));
	  username.sendKeys("orange");
	  password.sendKeys("orangepassword123");
	  driver.findElement(By.id("btnLogin")).click();

	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));

	  driver.findElement(By.id("menu_pim_viewPimModule")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_addEmployee")));

	  driver.findElement(By.id("menu_pim_addEmployee")).click();

	  driver.findElement(By.id("firstName")).sendKeys("Subhankar");

	  driver.findElement(By.id("lastName")).sendKeys("Mridha");
	  WebElement checkbox= driver.findElement(By.id("chkLogin"));

	  if (!checkbox.isSelected())

	  checkbox.click();
	  driver.findElement(By.id("user_name")).sendKeys("Subhankar Mridha");

	  driver.findElement(By.id("user_password")).sendKeys("Test@1234");

	  driver.findElement(By.id("re_password")).sendKeys("Test@1234");
      
	  WebElement statuscheckbox=driver.findElement(By.id("status"));
	  Select dropdown=new Select(statuscheckbox);
	  dropdown.selectByValue("Enabled");
	  driver.findElement(By.id("btnSave")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='personalDetails']")));

	  driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchSystemUser_userName")));

	  driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Subhankar Mridha");

	  driver.findElement(By.id("searchBtn")).click();

	  WebElement textvalue=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]"));

	  String expected="Subhankar Mridha";

	  if (expected.equals(textvalue.getText()))

		  Reporter.log("Employee profile successfully created");

	  else

		  Reporter.log(textvalue.getText()+" does not match with the expected value"); 
      }
	  
  @AfterMethod

  public void afterMethod() {

	  driver.close();

  }

}

