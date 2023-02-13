package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

/***
 CleaningServiceScreen.java
 This class defines all the UI elements present on Cleaning Services screen and their actions and verification methods
 @author feroz khan
 @version 1.0
 */
public class CleaningServiceScreen {
    public static Logger log = LogManager.getLogger(CleaningServiceScreen.class);

    AppiumDriver driver;
    public CleaningServiceScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    protected String bedRoomOption = "//android.widget.ImageView[@content-desc='Bedroom']";
    protected String cleaningServiceScreenTitle = "//android.view.View[@content-desc='Where do you want \ncleaned?']";
    protected String cleaningOptions = "//android.widget.ImageView[@content-desc='%s']";
    protected String countToSelect = "//android.view.View[@content-desc='%s']";
    protected String howManyBedroomText = "//android.widget.ImageView[@content-desc='Bedroom\nHow many Bedrooms?']";
    protected String livingRoomOption = "//android.widget.ImageView[@content-desc='Living Room']";
    protected String nextButton = "//android.widget.Button";

    /***
     * Verifies the text 'Where do you want cleaned?'
     * @return true or false
     */
    public boolean verifyCleaningServiceScreenTitle() {
        log.info("Verifying 'Where do you want cleaned?' button is present or not");
        try {
            driver.findElement(AppiumBy.xpath(cleaningServiceScreenTitle));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /***
     * Selects the cleaning type
     * @param type cleaning type to be selected
     * @throws RuntimeException When fails to select cleaning type
     */
    public void selectCleaningOption(String type) {
        log.info("Select the cleaning option " + type);
        try {
            driver.findElement(AppiumBy.xpath(String.format(cleaningOptions, type))).click();
        } catch (NoSuchElementException | NullPointerException e) {
            throw new RuntimeException(String.format("Cleaning option %s not found", type));
        }
    }

    /***
     * Selects the count of bedrooms
     * @param count number to be selected for bedrooms
     * @throws RuntimeException When fails to select count for bedroom
     */
    public void selectCountOfBedroom(String count) {
        log.info("Select the bedroom count " + count);
        try {
            driver.findElement(AppiumBy.xpath(howManyBedroomText))
                    .findElement(AppiumBy.xpath(String.format(countToSelect, count)))
                    .click();
        } catch (NoSuchElementException | NullPointerException e) {
            throw new RuntimeException(String.format("Failed to select bedroom count %s", count));
        }
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

}
