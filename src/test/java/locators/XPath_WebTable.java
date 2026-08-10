package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class XPath_WebTable {

    static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        //Launch the URL
        driver.get("https://the-internet.herokuapp.com/tables");
        //Maximize the window
        driver.manage().window().maximize();

        /*
         List<WebElement> listofLinks = driver.findElements(By.tagName("a"));
        System.out.println("No. of links in the page: "+ listofLinks.size());

        for( WebElement link : listofLinks )   //WebElement link = driver.findelement("By.tagname("a"))[1]))
        {
            System.out.println(link.getText());
        }
         */

       int rowCnt = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
       int colCnt = driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();

        System.out.println("No.of Rows: "+rowCnt+ " and No.of Columns: "+colCnt);

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for(WebElement row : rows){
            List<WebElement> cols = row.findElements(By.tagName("td"));
                for(WebElement col : cols){
                    System.out.print(col.getText() + " ");
                }
            System.out.println();
        }

        String name = "Frank";
        System.out.println(driver.findElement(By.xpath("//table[@id='table1']//td[text()='"+name+"']/following-sibling::td[2]")).getText());

        driver.quit();

    }
}
