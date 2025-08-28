package pac1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_4 {
	public static void main(String [] args) {
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
		
	}
	

}
