package com.test.Selenium_Basic;

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

import static org.testng.Assert.assertEquals;

public class miniproject01 {

    @Owner("Nitin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that with Invalid email, pass to check error msg is loaded")
    @Test
    public void seleniumProject_01() throws InterruptedException {

        ChromeDriver driver= new ChromeDriver();
        CommonToAll.openBrowser(driver,"https://app.vwo.com/#/login");


        //Usernam and passwword

        WebElement username= driver.findElement(By.id("login-username"));
        username.sendKeys("Nitin");
        WebElement password= driver.findElement(By.id("login-password"));
        password.sendKeys("Bhatia");
        WebElement btn_signIn= driver.findElement(By.id("js-login-btn"));
        btn_signIn.click();
      CommonToAll.customWait(2000);
        WebElement msg=driver.findElement(By.id("js-notification-box-msg"));

        String msgValue=msg.getText();
        System.out.println(msgValue);

       Assert.assertEquals(msgValue,"Your email, password, IP address or location did not match");


        driver.close();
    }

}
