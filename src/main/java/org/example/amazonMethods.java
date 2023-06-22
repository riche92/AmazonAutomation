package org.example;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class amazonMethods {

    WebDriver driver;
   // WebDriver fireDriver;
    WebDriverWait timer;

    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/wild_/OneDrive/Documents/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/Users/wild_/OneDrive/Documents/geckodriver.exe");
        driver = new ChromeDriver();
       // fireDriver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        timer = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @BeforeTest
    public void amazonSite(){
        driver.get("https://www.amazon.com/ref=nav_logo");
    }

    @Test
    public void search(){
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Gift Card");
        driver.findElement(By.cssSelector(".nav-search-submit-button")).click();
    }
}
