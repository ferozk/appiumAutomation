package utils;

import io.appium.java_client.AppiumDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import screens.HomeScreen;

import java.io.File;

/***
 DeviceUtils.java
 This class defines all the common methods related to device operations
 @author feroz khan
 @version 1.0
 */
public class DeviceUtils {
    public static Logger log = LogManager.getLogger(HomeScreen.class);

    AppiumDriver driver;
    public DeviceUtils(AppiumDriver driver) {
        this.driver = driver;
    }

    /***
     * Takes the screenshot of device
     */
    public void takeScreenShot(String testName) {

        try {
            log.info("Taking screenshot");
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File target = new File("logs/screenshots/" + testName +".png");
            FileHandler.copy(file, target);
        } catch (Exception e) {
            log.error("Failed to take screenshot", e);
        }

    }
}
