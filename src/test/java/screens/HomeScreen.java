package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

/***
    HomeScreen.java
    This class defines all the UI elements present on home screen and their actions and verification methods
    @author feroz khan
    @version 1.0
 */
public class HomeScreen {

    public static Logger log = LogManager.getLogger(HomeScreen.class);

    AppiumDriver driver;
    public HomeScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    protected String getStartedButton = "//android.widget.Button[@content-desc='Get Started']";
    protected String homeScreenText = "//android.view.View[@content-desc='Easy, reliable way to take \ncare of your home']";
    protected String homeScreenSubText = "//android.view.View[@content-desc='We provide you with the best people to help take care of your home.']";


    /***
     * Verifies the home screen text is present or not using xpath
     * @return true or false
     */
    public boolean verifyHomeScreenHeaderText () {
        log.info("verifyHomeScreenSubHeadingText(): Verifying 'Easy, reliable way to take care of your home' text is present or not");
        try {
            driver.findElement(AppiumBy.xpath(homeScreenText));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /***
     * Verifies the home screen sub heading text is present or not using xpath
     * @return true or false
     */
    public boolean verifyHomeScreenSubHeadingText () {
        log.info("Verifying 'We provide you with the best people to help take care of your home' text is present or not");
        try {
            driver.findElement(AppiumBy.xpath(homeScreenSubText));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /***
     * Verifies the Get Started Button is present or not using xpath
     * @return true or false
     */
    public boolean verifyGetStartedButton () {
        log.info("Verifying 'Get Started' button is present or not");
        try {
            driver.findElement(AppiumBy.xpath(getStartedButton));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /***
     * Clicks the next button
     * @throws RuntimeException When fails to click next button
     */
    public void clickGetStartedButton () {
        log.info("Clicks the 'Get started' button");
        try {
            WebElement element = driver.findElement(AppiumBy.xpath(getStartedButton));
            element.click();
        } catch (NoSuchElementException | NullPointerException e) {
            throw new RuntimeException("'Get Started Button' Not Found on home screen");
        }
    }

}
