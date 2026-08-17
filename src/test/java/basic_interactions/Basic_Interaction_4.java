package basic_interactions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Basic_Interaction_4 {
    public static void main(String[] args) throws InterruptedException {
        //Initiate chromedriver.exe and open the browser
        WebDriver driver = new ChromeDriver();
        //Launch the URL
        driver.get("https://the-internet.herokuapp.com/iframe");
        //Maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Get the page title
        System.out.println(driver.getTitle());
        //terminate chromedriver.exe and close browser

        WebElement elem = driver.findElement(By.id("mce_0_ifr"));

        //switch to iframe
        driver.switchTo().frame(elem);

        //get the iframe text
        String editorText = driver.findElement(By.xpath("//body[@id='tinymce']/p")).getText();
        System.out.println(editorText);

        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

        WebElement topElem = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(topElem);

        WebElement leftElem = driver.findElement(By.name("frame-left"));
        driver.switchTo().frame(leftElem);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();

        WebElement middleElem = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middleElem);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();

        WebElement rightElem = driver.findElement(By.name("frame-right"));
        driver.switchTo().frame(rightElem);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();


        Thread.sleep(3000);

        driver.quit();

    }
}
