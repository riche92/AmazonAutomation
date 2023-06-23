package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;
import java.util.Date;

public class amazonBackend extends amazonUIMethods {



    public void failedScreenshot(String text) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");
        try {
            FileUtils.copyFile(src, new File("C://Users/wild_/OneDrive/Documents/Screenshots/"  + text +  "_" + TimeStamp + ".png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
