package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.CleaningServiceScreen;
import screens.DateTimeScreen;
import screens.HomeScreen;
import screens.ServicesListScreen;
import utils.Config;
import utils.DeviceUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Test
public class BaseTest {

    public static Logger log = LogManager.getLogger(BaseTest.class);

    AppiumDriver driver;
    CleaningServiceScreen cleaningServiceScreen;
    DateTimeScreen dateTimeScreen;
    DeviceUtils deviceUtils;
    HomeScreen homeScreen;
    ServicesListScreen servicesListScreen;

    @BeforeClass
    public void setup() throws MalformedURLException {
        log.info("setup()");
        try {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability("automationName", "UiAutomator2");
            dc.setCapability("platformName", Config.DevicePlatform);
            dc.setCapability("platformVersion", Config.DeviceOSVersion);
            dc.setCapability("deviceName", Config.DeviceName);
            dc.setCapability("udid", Config.DeviceUDID);
            dc.setCapability("app", new File(Config.BuildPath).getAbsolutePath());
            driver = new AndroidDriver(new URL(Config.AppiumServerURL), dc);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            cleaningServiceScreen = new CleaningServiceScreen(driver);
            dateTimeScreen = new DateTimeScreen(driver);
            homeScreen = new HomeScreen(driver);
            servicesListScreen = new ServicesListScreen(driver);
            deviceUtils = new DeviceUtils(driver);
        } catch (Exception e) {
            log.error("Setup() Failed ", e);
            throw e;
        }
    }

    @AfterClass
    public void tearDown() {
        log.info("tearDown()");
        if (driver != null)
            driver.quit();
    }

}
