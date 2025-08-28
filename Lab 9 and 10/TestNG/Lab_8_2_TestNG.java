package pac1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_8_2_TestNG {
	WebDriver driver;
	WebDriverWait wait;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  System.out.println("This is the test");
	  driver.get("https://tutorialsninja.com/demo/index.php?");
      
      WebElement componentsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops")));
      componentsLink.click();
      driver.findElement(By.linkText("Mac (1)")).click();
      
      WebElement msg1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h2")));
      System.out.println("The heading appeared is: "+msg1.getText());
      
      WebElement sortDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-sort")));
      Select select = new Select(sortDropdown);
      select.selectByVisibleText("Name (A - Z)");
      
      driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
      
      driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Mobile");
      driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
      
      driver.findElement(By.xpath("//*[@id='input-search']")).clear();
      
      driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
      
      driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Monitors");
      driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
      
      driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
      
      WebElement msg=driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
		if(msg.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is Before Method");
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is After Method");
	  driver.quit();
	  

  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is After Test");
	  
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is After Suite");
	  
  }
}
