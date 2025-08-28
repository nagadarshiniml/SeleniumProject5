package pac1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/index.php?");
        
        WebElement componentsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops")));
        componentsLink.click();
        driver.findElement(By.linkText("Mac (1)")).click();
        
        WebElement sortDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-sort")));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (A - Z)");
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
        

	}

}
