package com.test.Selenium_Basic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumMiniproject01 {

    @Test
    public void seleniumProject_01()
    {

        ChromeDriver driver= new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
      driver.manage().window().maximize();

        driver.close();
    }

}
