package basic_interactions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Set;

public class Basic_Interaction_2 {
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

        //-----------Simple Alert-----------------
        driver.findElement(By.id("alertBtn")).click();

        //switch to Alert
        Alert alert = driver.switchTo().alert();
        System.out.println("Simple Alert message is "+ alert.getText());
        //Thread.sleep(1000);
        alert.accept();

        //----------Confirmation Alert-----------
        driver.findElement(By.id("confirmBtn")).click();

        //switch to confirmation alert
        Alert conf_alert = driver.switchTo().alert();
        //Thread.sleep(1000);
        conf_alert.dismiss();
        System.out.println("Confirmation Alert action is :"+driver.findElement(By.id("demo")).getText());

        //----------Prompt Alert-----------
        driver.findElement(By.id("promptBtn")).click();

        //switch to confirmation alert
        Alert prmpt_alert = driver.switchTo().alert();
        //Thread.sleep(1000);
        prmpt_alert.sendKeys("James");
        conf_alert.accept();
        System.out.println("Confirmation Alert action is :"+driver.findElement(By.id("demo")).getText());

        //---------------New browser Tab----------------------------
        //Every bowser window/Tab has a unique identifier called a "Window handle"
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window "+ driver.getTitle() + " handle is: "+parentWindow);

        //add new tab
        driver.findElement(By.xpath("//button[text()='New Tab']")).click();
        //add new popup window
        driver.findElement(By.xpath("//button[text()='Popup Windows']")).click();

        Set<String> allwindows = driver.getWindowHandles();
        System.out.println("Total no of windows opened: "+allwindows.size());

        for(String window : allwindows){
            if(!window.equals(parentWindow)){
                driver.switchTo().window(window);
                System.out.println("Child window "+ driver.getTitle() + " handle is: "+driver.getWindowHandle());
            }
        }

        //switch back to parent browser tab
        driver.switchTo().window(parentWindow);
        System.out.println("Parent browser window title: "+driver.getTitle());

        /*
        Better way to handle multiple window (assume 10 tabs)
        for ( String window : driver.getWindowHandles()){
            driver.switchTo().window(window);
            if(driver.getTitle().contains("SDET-QA Blog"){
                break;
                }
        }
        driver.findElem.... --> focus only on "SDET-QA Blog" webpage
         */

        //-------------- Mouse events : Mouse hover------------------
        Actions actions = new Actions(driver);
        WebElement pointMe_btn = driver.findElement(By.xpath("//button[text()='Point Me']"));
        WebElement laptop_optn = driver.findElement(By.xpath("//a[text()='Laptops']"));

        /* --- individual method calling , so no need of build() method
        actions.moveToElement(pointMe_btn).perform();
        Thread.sleep(5000);
        actions.moveToElement(laptop_optn).perform();
        actions.click(laptop_optn).perform();
         */

        actions.moveToElement(pointMe_btn).
                pause(Duration.ofSeconds(5)).
                moveToElement(laptop_optn).
                click(laptop_optn).
                build().
                perform();

        Thread.sleep(2000);
        driver.quit();

    }
}
