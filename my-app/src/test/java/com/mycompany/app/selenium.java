package com.mycompany.app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
 
@Listeners({util.Listener.class})
class FirstTestScriptUsingWebDriver {
   public static WebDriver driver = null;
   @BeforeTest
   public void setUp() throws Exception {
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
   }
    @Test
   public void firstTestCase() {
       try {
           System.out.println("Logging into Lambda Test Sign Up Page");
           driver.get("https://accounts.lambdatest.com/register");
           WebElement pageHeader= driver.findElement(By.xpath("//a[text()='Sign In']"));
           pageHeader.click();
           System.out.println("Clicked on the Sign In Button.");
       } catch (Exception e) {
       }
   }
   @AfterTest
   public void closeBrowser() {
       driver.close();
       System.out.println("Hello World");
   }
}
