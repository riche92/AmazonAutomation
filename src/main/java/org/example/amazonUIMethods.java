package org.example;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class amazonUIMethods extends amazonSetUp {


    /*
        @Parameters({"URL"})
        @BeforeTest
        public void amazonSite(String urlname){
            driver.get(urlname);


        }
    */
    @BeforeTest
    public void urlsite() {
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void search() {
        timer.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Gift Card");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Test
    public void accountMenu() {
        Actions am = new Actions(driver);
        WebElement move = driver.findElement(By.id("nav-link-accountList"));
        am.moveToElement(move).contextClick().build().perform();
    }

    @Test
    public void navigationShopTabs() {
        WebElement shopTabs = driver.findElement(By.xpath("//*[@id='nav-main']/div[2]"));
        shopTabs.findElements(By.tagName("a")).size();
        try {
            for (int i = 1; i < shopTabs.findElements(By.tagName("a")).size(); i++) {
                String ctrlclick = Keys.chord(Keys.CONTROL, Keys.ENTER);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                shopTabs.findElements(By.tagName("a")).get(i).sendKeys(ctrlclick);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            }


        Set<String>  windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());

        }
    }

        @AfterTest
        public void endofAutomation() {
            driver.quit();
        }

}

