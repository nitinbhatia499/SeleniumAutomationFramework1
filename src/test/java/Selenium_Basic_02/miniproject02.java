package Selenium_Basic_02;

import com.test.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class miniproject02 extends CommonToAll {

    @Owner("Nitin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that Error Message for Free trial Account creation")
    @Test
    public void SeleniumProject02() throws InterruptedException {
        ChromeDriver driver= new ChromeDriver();
        CommonToAll.openBrowser(driver,"https://app.vwo.com/#/login");

        //Click on Start trial button

        WebElement trial_link= driver.findElement(By.xpath("//a[@data-qa='bericafeqo']"));
        trial_link.click();
        CommonToAll.waitForVisibility(driver,3,"//input[@data-qa='page-su-step1-v1-email']");

        //Email text
        WebElement email=driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("Abc");

        //checkbox
        WebElement checkbox=driver.findElement(By.xpath("(//input[contains(@id,'consent-checkbox')])[1]"));
        checkbox.click();

        //Free trailAccountButton
        WebElement btn_trail_account= driver.findElement(By.xpath("(//button[@data-qa='page-su-submit'])[1]"));
        btn_trail_account.click();
        CommonToAll.waitForVisibility(driver,3,"(//div[contains(@class,'invalid-reason')])[1]");
        //ErrorMsg
        WebElement error_msg=driver.findElement(By.xpath("(//div[contains(@class,'invalid-reason')])[1]"));
        String str=error_msg.getText();

        Assert.assertEquals(str,"The email address you entered is incorrect.");
       CommonToAll.closeBrowser(driver);

    }

}
