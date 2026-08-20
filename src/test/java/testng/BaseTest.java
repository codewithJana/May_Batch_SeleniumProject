package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.out.println("******@Before Test*******");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("******@After Test*******");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("******@Before Class*******");
        System.out.println("Starting Test Class: " + this.getClass().getSimpleName());
    }

    @AfterClass
    public void afterClass() {
        System.out.println("******@After Class*******");
        System.out.println("Starting Test Class: " + this.getClass().getSimpleName());
    }

    @BeforeMethod
    public void setup() {
        System.out.println("******@Before Method*******");
        System.out.println("Launch Browser and Navigate to URL");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        //options.addArguments("--headless=new");
        //Initiate chromedriver.exe and open the browser
        driver = new ChromeDriver(options);
        //Launch the URL
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("******@After Method*******");
        System.out.println("Close the browser");
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeSuite
    public void GlobalSetup() {
        System.out.println("******@Before Suite*******");
        System.out.println("Check all my Application or test dependencies");
    }

    @AfterSuite
    public void GlobalCleanUp() {
        System.out.println("******@After Suite*******");
        System.out.println("clean up all my Application or test data");
    }


}
