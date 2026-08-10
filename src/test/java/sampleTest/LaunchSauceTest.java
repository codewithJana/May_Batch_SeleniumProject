package sampleTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchSauceTest {
    static void main(String[] args) {
        //Initiate chromedriver.exe and open the browser
        WebDriver driver = new ChromeDriver();
        //Launch the URL
        driver.get("https://www.saucedemo.com/");
        //Maximize the window
        driver.manage().window().maximize();
        //Get the page title
        System.out.println(driver.getTitle());
        //terminate chromedriver.exe and close browser
        driver.quit();

    }
}
