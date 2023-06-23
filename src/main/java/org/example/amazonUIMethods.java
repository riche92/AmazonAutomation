package org.example;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class amazonUIMethods {

   public static WebDriver driver;
   // WebDriver fireDriver;
    public static WebDriverWait timer;

    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/wild_/OneDrive/Documents/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/Users/wild_/OneDrive/Documents/geckodriver.exe");
       // fireDriver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        timer = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Parameters({"URL"})
    @BeforeTest
    public void amazonSite(String urlname){
        driver.get(urlname);

    }

    @Test
    public void search(){
        timer.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Gift Card");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Test
    public void accountMenu(){
        Actions am = new Actions(driver);
        WebElement move = driver.findElement(By.id("nav-link-accountList"));
        am.moveToElement(move).contextClick().build().perform();
    }
    @Test
    public void navigationShopTabs(){


    }

    @AfterTest
    public void endofAutomation(){
        driver.quit();
    }
}
