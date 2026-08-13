package basic_interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecution {
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

        //****************JacascriptExecutor************

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement nameField = driver.findElement(By.id("name"));
        js.executeScript("arguments[0].click();",nameField);
        Thread.sleep(2000);
        js.executeScript("arguments[0].value='admin';", nameField);

        String getTitle = (String) js.executeScript("return document.title;");
        System.out.println(getTitle);

        String getCurrentURL = (String) js.executeScript("return window.location.href;");
        System.out.println(getCurrentURL);

        js.executeScript("arguments[0].style.border='3px solid red';",nameField);

        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(2000);


        Thread.sleep(3000);
        driver.quit();
    }
}
