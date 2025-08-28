package pac1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC010_TestNG {
  WebDriver driver;
  @Test(dataProvider = "logindata")
  public void f(String username, String password) {
	  System.out.println("This is the test");
	  
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement uname=driver.findElement(By.name("username"));
		if(uname.isDisplayed())
		{
			uname.sendKeys("Admin");
		System.out.println("Get placeholder:"+uname.getAttribute("placeholder"));
		}
		else
		{
			System.out.println("username is not displayed");
		}
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.name("username")).sendKeys(Keys.ENTER);
		WebElement dashboard=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		if(dashboard.isDisplayed()) {
			AssertJUnit.assertTrue(true);
		}
		else
		{
			AssertJUnit.assertTrue(false);
		}
		
		}
  
  @Test (groups=("smoke"))
  public void register() {
	  System.out.println("Register");
  }
  
  @Test
  public void addToCart() {
	  System.out.println("Add to Cart");
  }
  
  
  @Parameters("browser")
  @BeforeMethod
  public void beforeMethod(String brow) {
	 
	  System.out.println("This is the before method");
	  if(brow.equalsIgnoreCase("chrome")) {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  }
	  
	  if(brow.equalsIgnoreCase("edge")) {
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
		  }
	  
	  if(brow.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
		  }
	  
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is the after method");
	  driver.quit();
  }


  @DataProvider
  public Object[][] logindata() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "Pooja", "123" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is the before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is the after class");

	  
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is after suite");
  }

}
