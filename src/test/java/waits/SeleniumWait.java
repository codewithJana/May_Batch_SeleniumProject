package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWait {
    public static void main(String[] args) throws InterruptedException {

        //Initiate chromedriver.exe and open the browser
        WebDriver driver = new ChromeDriver();
        //Launch the URL
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        //Maximize the window
        //driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Get the page title
        System.out.println(driver.getTitle());
        //terminate chromedriver.exe and close browser

        driver.findElement(By.tagName("button")).click();
        //Thread.sleep(10000);
        String helloText = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
        System.out.println(helloText);

        //navifate to loading page
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.tagName("button")).click();
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));

        String helloText1 = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
        System.out.println(helloText1);

        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");

        //click remove button
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //FluentWait
        FluentWait<WebDriver> fWait = new FluentWait<>(driver);
        fWait.
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).
                ignoring(Exception.class);

        //lamda function
        WebElement element = fWait.until(driver1 -> {
                    WebElement chkBox = driver.findElement(By.id("checkbox"));
                    if (chkBox.isEnabled()){
                        return chkBox;
                    }
                    return  null;
                });

        driver.quit();

    }


}
