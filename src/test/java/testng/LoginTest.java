package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginTest extends BaseTest{

    @Test
    public void ValidLoginTest(){

        Assert.assertEquals(driver.getTitle(),"Swag Labs"); // 1st Assertion
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String pageHeader = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(pageHeader,"Swag Labs","The actual data in Application is "+pageHeader); //2nd Assertion
        System.out.println("This message is after my assertion");
    }

    @Test
    public void InValidLoginTest(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"Swag Labs"); //1st Assertion
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String pageHeader = driver.findElement(By.tagName("h3")).getText();
        System.out.println(pageHeader);
        Assert.assertEquals(pageHeader,"Epic sadface: Sorry, this user has been locked out.","The actual data in Application is "+pageHeader);  //2nd Assertion
        System.out.println("This message is after my assertion");
        softAssert.assertAll();
    }

}
