package OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;


public class Test8 {

	WebDriver driver = new FirefoxDriver();

	WebDriverWait wait = new WebDriverWait(driver,10);

	Actions actions = new Actions(driver);

	@BeforeMethod

	public void beforeMethod() {

	driver.get("http://alchemy.hguy.co/orangehrm");

	WebElement username=driver.findElement(By.id("txtUsername"));

	WebElement password=driver.findElement(By.id("txtPassword"));

	username.sendKeys("orange");

	password.sendKeys("orangepassword123");

	driver.findElement(By.id("btnLogin")).click();
}
	
	@Test

	public void testActivity8() {


	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));
	WebElement dashboard=driver.findElement(By.cssSelector("#menu_dashboard_index"));

	actions.doubleClick(dashboard).perform();

	driver.findElement(By.xpath("//a[contains(@href,'applyLeave')]/img")).click();

	WebElement leaveType=driver.findElement(By.id("applyleave_txtLeaveType"));
	Select dropdown = new Select(leaveType);
	dropdown.selectByVisibleText("Paid Leave");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date fromDate = new Date();
	Date toDate = new Date();

	  driver.findElement(By.id("applyleave_txtFromDate")).clear();

	  driver.findElement(By.id("applyleave_txtFromDate")).sendKeys(dateFormat.format(fromDate));

	  driver.findElement(By.id("applyleave_txtToDate")).clear();

	  driver.findElement(By.id("applyleave_txtToDate")).sendKeys(dateFormat.format(toDate));

	  driver.findElement(By.xpath("//input[@id='applyBtn']")).click();

	  driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']")).click();

	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calFromDate")));

	  driver.findElement(By.id("calFromDate")).clear();
	  driver.findElement(By.id("calFromDate")).sendKeys(dateFormat.format(fromDate));
	  driver.findElement(By.id("calToDate")).clear();
	  driver.findElement(By.id("calToDate")).sendKeys(dateFormat.format(toDate));
	  driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
	  List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));

	  for (int i=1;i<=tableRows.size();i++){
		  WebElement status =driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[6]"));
		  WebElement dates =driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]"));
		  Reporter.log("Leave status of application number "+i+" for date(s) "+dates.getText()+" is : " + status.getText());
	  }

  }

  @AfterMethod

  public void afterMethod() {

	  driver.close();

  }
}

