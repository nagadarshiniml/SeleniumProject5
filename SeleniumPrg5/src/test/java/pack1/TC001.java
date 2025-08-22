package pack1;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.UUID;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;




public class TC001 {

    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       


        // Navigate to the website
      //  driver.get("https://www.google.com/");
        

        // Locate the search box using By.id and perform search
        //WebElement search = driver.findElement(By.id("APjFqb"));
        //search.sendKeys("Automation Testing Tools");
        //search.submit();
        driver.get("https://tutorialsninja.com/demo/index.php?");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
        System.out.println("title is:"+driver.getTitle());
     // ❌ Step 2: Negative Test - Too long first name
        try {
            WebElement firstName = driver.findElement(By.id("input-firstname"));
            firstName.clear();
            firstName.sendKeys("ThisIsWayMoreThanThirtyThreeCharactersLong");

            driver.findElement(By.id("input-lastname")).clear();
            driver.findElement(By.id("input-lastname")).sendKeys("ML");

            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            WebElement error = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"));
            System.out.println("✅ Negative Test Passed: " + error.getText());
        } catch (Exception e) {
            System.out.println("❌ Negative test failed or error not found.");
        }

        // ✅ Step 3: Valid Registration Details
        try {
            System.out.println("🟢 Now proceeding with valid data...");

            // First Name
            driver.findElement(By.id("input-firstname")).clear();
            driver.findElement(By.id("input-firstname")).sendKeys("Darshini");

            // Last Name
            driver.findElement(By.id("input-lastname")).clear();
            driver.findElement(By.id("input-lastname")).sendKeys("ML");

            // Email (Note: Change this if account already exists)
            String email = "nagadarshiniml@gmail.com";
            driver.findElement(By.id("input-email")).clear();
            driver.findElement(By.id("input-email")).sendKeys(email);

            // Phone
            driver.findElement(By.id("input-telephone")).clear();
            driver.findElement(By.id("input-telephone")).sendKeys("8971795343");

            // Password & Confirm
            driver.findElement(By.id("input-password")).clear();
            driver.findElement(By.id("input-password")).sendKeys("Test1234");
            driver.findElement(By.id("input-confirm")).clear();
            driver.findElement(By.id("input-confirm")).sendKeys("Test1234");

            // Newsletter - Yes
            WebElement newsletterYes = driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
            if (!newsletterYes.isSelected()) {
                newsletterYes.click();
            }

            // Agree to Privacy Policy
            WebElement privacyPolicy = driver.findElement(By.name("agree"));
            if (!privacyPolicy.isSelected()) {
                privacyPolicy.click();
            }

            // Submit
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            // Check success
            WebElement successMsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
            if (successMsg.isDisplayed()) {
                System.out.println("✅ Account successfully created!");
            }

            // Continue button
            driver.findElement(By.xpath("//a[text()='Continue']")).click();
            System.out.println("✅ Clicked Continue to go to My Account page");

            // Order History
            List<WebElement> orderHistory = driver.findElements(By.linkText("View your order history"));
            if (!orderHistory.isEmpty()) {
                orderHistory.get(0).click();
                System.out.println("✅ Navigated to Order History page.");
            } else {
                System.out.println("ℹ️ Order history link not shown (no orders yet).");
            }

        } catch (Exception e) {
            System.out.println("❌ Account might already exist or an error occurred: " + e.getMessage());
        }

       
    }
}