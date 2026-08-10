package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BasicLocators {
    static void main(String[] args) throws InterruptedException {
        /* Locator Methods
        1. ID(M+A)               5. PartialLink(M)
        2. Name(M+A)             6. TagName(M+Tag)
        3. ClassName(M+A)        7. CSS(M)
        4. Linktext(M)           8. XPATH(M)
         */

        //Initiate chromedriver.exe and open the browser
        WebDriver driver = new EdgeDriver();
        //Launch the URL
        driver.get("https://www.saucedemo.com/");
        //Maximize the window
        driver.manage().window().maximize();
        //Get the page title
        System.out.println("Page title:" + driver.getTitle());

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.name("password"));
        //WebElement loginButton = driver.findElement(By.className("submit-button btn_action")); // Error: Compound classname not permitted
        WebElement loginButton = driver.findElement(By.name("login-button"));

        //enter Username
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        WebElement HeaderText = driver.findElement(By.className("app_logo"));
        String getHeaderText = HeaderText.getText();
        System.out.println("Login Successful and the Sauce demo page Header is: " + getHeaderText);

        //Navigate to Internet Herup App
        driver.navigate().to("https://the-internet.herokuapp.com/");
        String pageHeader = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Internet HerukuApp page header is : "+pageHeader);

        //click Checkboxes link
        driver.findElement(By.linkText("Checkboxes")).click();
        String checkBoxPageHeader = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Checkbox page header is "+ checkBoxPageHeader);

        //navigate back
        driver.navigate().back();

        //click context menu page
        driver.findElement(By.partialLinkText("Context")).click();
        String contextMenuPageHeader = driver.findElement(By.tagName("h3")).getText();
        System.out.println("ContextMenu page header is "+ contextMenuPageHeader);

        //alternate way
        //driver.findElement(By.id("user-name")).sendKeys("");
        //driver.findElement(By.name("password")).sendkeys("");

        //static wait
        Thread.sleep(2000);
        //terminate chromedriver.exe and close browser
        driver.quit();

    }
}
