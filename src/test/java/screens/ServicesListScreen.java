package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.offset.PointOption.point;

/***
 ServicesListScreen.java
 This class defines all the UI elements present on Services List screen and their actions and verification methods
 @author feroz khan
 @version 1.0
 */
public class ServicesListScreen {
    public static Logger log = LogManager.getLogger(ServicesListScreen.class);

    AppiumDriver driver;
    public ServicesListScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    protected String nextButton = "//android.widget.Button";
    protected String serviceListScreenTitle = "//android.view.View[@content-desc='Which service \ndo you need?']";
    protected String serviceType = "//android.widget.ImageView[@content-desc='%s']";

    /***
     * Scroll the screen up till element is not found or loop count 10 ends
     * @param elementLocator element to be located while scrolling
     * @return WebElement found by elementLocator
     */
    public WebElement scrollToElement(By elementLocator) {
        int numberOfTimes = 10;
        Dimension size = driver.manage().window().getSize();
        int anchor = size.width / 2;
        int startPoint = size.height - 10;
        int endPoint = 10;
        WebElement element = null;
        for (int i = 0; i < numberOfTimes; i++) {
            try {
                new TouchAction((PerformsTouchActions) driver)
                        .longPress(point(anchor, startPoint))
                        .moveTo(point(anchor, endPoint))
                        .release()
                        .perform();
                element = driver.findElement(elementLocator);
                i = numberOfTimes;
            } catch (NoSuchElementException ex) {
                System.out.println(String.format("Element not available. Scrolling (%s) times...", i + 1));
            }
        }
        return element;
    }

    /***
     * Selects the service type
     * @param type service type to be selected
     * @throws RuntimeException When fails to find service type
     */
    public void locateAndChooseService (String type) {
        log.info("Select the service type " + type);
        WebElement element = scrollToElement(AppiumBy.xpath(String.format(serviceType, type)));
        if (element == null)
            throw new RuntimeException(String.format("%s Service element not found", type));
        else
            element.click();
    }

    /***
     * Clicks the next button
     * @throws RuntimeException When fails to click next button
     */
    public void clickNextButton() {
        log.info("Clicks the next button");
        try {
            driver.findElement(AppiumBy.xpath(nextButton)).click();
        } catch (NoSuchElementException | NullPointerException e) {
            throw new RuntimeException("Next button not found on services list screen");
        }
    }

    /***
     * Verifies the text 'Which service do you need?'
     * @return true or false
     */
    public boolean verifyServicesListScreenTitle() {
        log.info("Verifying 'Which service do you need?' text is present or not");
        try {
            driver.findElement(AppiumBy.xpath(serviceListScreenTitle));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
