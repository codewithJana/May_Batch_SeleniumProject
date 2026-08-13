package basic_interactions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Set;

public class Basic_Interaction_3 {
    public static void main(String[] args) throws InterruptedException {
        //Initiate chromedriver.exe and open the browser
        WebDriver driver = new ChromeDriver();
        //Launch the URL
        driver.get("https://testautomationpractice.blogspot.com/#");
        //Maximize the window
        driver.manage().window().maximize();
        //Get the page title
        System.out.println(driver.getTitle());
        //terminate chromedriver.exe and close browser

        //action class
        Actions actions = new Actions(driver);
        //-------------- Mouse events : Mouse hover------------------
        driver.findElement(By.id("field1")).clear();
        driver.findElement(By.id("field1")).sendKeys("testing");
        WebElement copytextBtn = driver.findElement(By.xpath("//button[text()='Copy Text']"));

        actions.doubleClick(copytextBtn).perform();
        Thread.sleep(2000);
        WebElement field2Input = driver.findElement(By.id("field2"));
        System.out.println(field2Input.getText());

        //-------------- Mouse events : drag and drop------------------

        WebElement source = driver.findElement(By.xpath("//*[text()='Drag me to my target']"));
        WebElement target = driver.findElement(By.xpath("//*[text()='Drop here']"));

        actions.clickAndHold(source).
                moveToElement(target).
                release().
                build().
                perform();

        /* using default draganddrop method
            actions.dragAndDrop(source,target).perform();
         */






        Thread.sleep(2000);
        driver.quit();

    }
}
