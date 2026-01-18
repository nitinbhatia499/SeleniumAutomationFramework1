package Selenium_Basic_03;

import com.test.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class MiniProject03 extends CommonToAll {
    @Owner("Nitin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that Error Message for Free trial Account creation")
    @Test
    public void SeleniumProject03() throws InterruptedException {

        ChromeDriver driver= new ChromeDriver();
        openBrowser(driver,"https://selectorshub.com/xpath-practice-page/");

        // Dummay Form

      WebElement username= driver.findElement(By.xpath("//input[@dataid='sh_email1']"));
      username.sendKeys("Nitin", Keys.TAB);

      WebElement password= driver.findElement(By.id("pass"));
      password.sendKeys("Bhatia");

      WebElement company= driver.findElement(By.xpath("(//input[@name='company'])[1]"));
      company.sendKeys("ABC");

      WebElement mobilenumber= driver.findElement(By.xpath("(//input[@name='mobile number'])[1]"));
        mobilenumber.sendKeys("12345678");

       //Static WebTable

        WebElement resulttable = driver.findElement(By.xpath("//table[@id='resultTable']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", resulttable);

       List<WebElement> userroles= driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
        List<String> employeeName= new LinkedList<>();
        int len=userroles.size();
       for(int i=0;i<len;i++)
       {
           customWait(2000);
           WebElement userrole=userroles.get(i);
           String role = userrole.findElement(By.xpath("./td[3]")).getText();
           if(role.equalsIgnoreCase("ESS"))
           {
             String ename=  userrole.findElement(By.xpath("./td[4]")).getText();
               employeeName.add(ename);
               userrole.findElement(By.xpath("./td[1]/input")).click();
           }
       }
       System.out.println(employeeName);

    }
}
