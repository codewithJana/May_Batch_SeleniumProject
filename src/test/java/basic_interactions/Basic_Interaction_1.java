package basic_interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Basic_Interaction_1 {
    static void main(String[] args) throws InterruptedException {
        //Initiate chromedriver.exe and open the browser
        WebDriver driver = new ChromeDriver();
        //Launch the URL
        driver.get("https://testautomationpractice.blogspot.com/#");
        //Maximize the window
        driver.manage().window().maximize();
        //Get the page title
        System.out.println(driver.getTitle());
        //terminate chromedriver.exe and close browser

        //-------------------select the checkbox
        String strDays = "Friday";
        WebElement checkBox_mon = driver.findElement(By.xpath("//label[text()='"+strDays+"']//preceding-sibling::input"));
        if(!checkBox_mon.isSelected()){
            checkBox_mon.click();
        }
        System.out.println("Status of the checkBox after selecting: "+checkBox_mon.isSelected());

        //-------------------select the Radiobutton
        String strGender = "Female";
        WebElement radio_female = driver.findElement(By.xpath("//label[text()='" + strGender +"']//preceding-sibling::input"));
        radio_female.click();
        System.out.println("Status of the Radiobutton after selecting: " +radio_female.isSelected());

        //-------------------select the Dropdown
        //Use select class[special class in selenium for dropdowns] only if the element tag is "select"
        WebElement country = driver.findElement(By.id("country"));
        Select dp_Country = new Select(country);
        dp_Country.selectByVisibleText("Brazil");
        System.out.println(dp_Country.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        dp_Country.selectByValue("uk");
        System.out.println(dp_Country.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        dp_Country.selectByIndex(0);
        System.out.println(dp_Country.getFirstSelectedOption().getText());

        //-------------------select the Multiselect
        WebElement colors = driver.findElement(By.id("colors"));
        Select dp_Colors = new Select(colors);
        dp_Colors.selectByVisibleText("Red");
        dp_Colors.selectByValue("blue");
        dp_Colors.selectByIndex(3);
        dp_Colors.selectByVisibleText("Green");
        Thread.sleep(1000);
        //unselect Green
        dp_Colors.deselectByValue("green");
        //deselect all options
        dp_Colors.deselectAll();


        Thread. sleep(3000);
        driver.quit();

    }
}
