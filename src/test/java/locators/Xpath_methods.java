package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Xpath_methods {

    static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        //Launch the URL
        driver.get("https://the-internet.herokuapp.com/");
        //Maximize the window
        driver.manage().window().maximize();
        //Get the page title
        System.out.println("Page title:" + driver.getTitle());

        //----------text() method------------
        driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
        //driver.findElement(By.xpath("//a[@href='/dropdown]'")).click();
        //driver.findElement(By.linkText("Dropdown")).click();

        driver.navigate().back();
        //----------contains()-----------------
        driver.findElement(By.xpath("//a[contains(text(),'Scroll')]")).click();
        //----------starts-with---------------
        driver.navigate().back();
        driver.findElement(By.xpath("//a[starts-with(text(),'Forgot')]")).click();

        //----------normalize-space()-----------
        driver.navigate().to("https://automationexercise.com/");
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        //--------- preceding-siblings-------------
        driver.findElement(By.xpath("//input[@name='password']/preceding-sibling::input[@name='email']")).sendKeys("testuser1100@gmail.com");
        driver.findElement(By.xpath("//input[@name='name']//following-sibling::input[@name='email']")).sendKeys("testuser1100@gmail.com");

        //---------parent-----------------
        String loginHeader = driver.findElement(By.xpath("//input[@name='password']/parent::form/preceding-sibling::h2")).getText();
        System.out.println(loginHeader);

        Thread.sleep(2000);
        //quit browser
        driver.quit();

    }
}
