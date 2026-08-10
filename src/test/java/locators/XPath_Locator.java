package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class XPath_Locator {
    static void main(String[] args) throws InterruptedException {
//Initiate chromedriver.exe and open the browser
        WebDriver driver = new EdgeDriver();
        //Launch the URL
        driver.get("https://www.saucedemo.com/");
        //Maximize the window
        driver.manage().window().maximize();
        //Get the page title
        System.out.println("Page title:" + driver.getTitle());

        //xpath for login
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();

        //verify successful Login
        WebElement HeaderText = driver.findElement(By.className("app_logo"));
        String getHeaderText = HeaderText.getText();
        System.out.println("Login Successful and the Sauce demo page Header is: " + getHeaderText);

        //click on cart link
        driver.findElement(By.xpath("//a[@class='shopping_cart_link' and @data-test='shopping-cart-link']")).click();

        driver.navigate().to("https://the-internet.herokuapp.com/");
        String pageHeader = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Internet HerukuApp page header is : "+pageHeader);

               Thread.sleep(2000);
        //quit browser
        driver.quit();
    }
}
