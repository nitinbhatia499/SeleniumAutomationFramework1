package Selenium_Basic_04;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static com.test.CommonToAll.customWait;
import static com.test.CommonToAll.openBrowser;

public class ShadowDom {

    @Owner("Nitin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Shadow Dom")
    @Test
    public void SeleniumProject03() throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        openBrowser(driver, "https://selectorshub.com/xpath-practice-page/");

        WebElement shadowrootelement = driver.findElement(By.id("userName"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", shadowrootelement);

        //ShadowHost

        WebElement shadowhost1= driver.findElement(By.cssSelector("#userName"));
        SearchContext shadowRoot1=shadowhost1.getShadowRoot();

        WebElement shadowElement = shadowRoot1.findElement(By.cssSelector("#kils"));
        shadowElement.sendKeys("Nitin");
      //Nested Shadow Dom
        WebElement shadowhost2= shadowRoot1.findElement(By.cssSelector("#app2"));
        SearchContext shadowRoot2=shadowhost2.getShadowRoot();

        WebElement inputboxpizza= shadowRoot2.findElement(By.cssSelector("#pizza"));
        inputboxpizza.sendKeys("framhouse");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys("Bhatia").build().perform();

        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys("Lekhni").build().perform();

        //Bottom Model

       WebElement modal= driver.findElement(By.xpath("//button[@id='myBtn']"));
        js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click();", modal);
        customWait(2000);
        driver.findElement(By.xpath("//span[@class='close']")).click();

        // Payment Page
       WebElement cardname= driver.findElement(By.id("cardName"));
        js.executeScript("arguments[0].scrollIntoView(true);", cardname);
        cardname.sendKeys("Nitin Bhatia");
        customWait(5000);
        driver.findElement(By.id("cardNumber")).sendKeys("1234567891232343");
        customWait(5000);
        driver.findElement(By.id("expiry")).sendKeys("03/27");
        driver.findElement(By.id("cvv")).sendKeys("123");
        WebElement submitbtn= driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].scrollIntoView(true);arguments[0].click();", submitbtn);
        customWait(5000);






    }
}