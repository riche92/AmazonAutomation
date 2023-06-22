package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class amazonBackend extends amazonUIMethods {

    @Test
    public void failedScreenshot(String test) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");
        try {
            FileUtils.copyFile(src, new File("C://Users/wild_/OneDrive/Documents/Screenshots/" + test + "_" + TimeStamp + ".png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
