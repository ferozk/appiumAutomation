package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/***
 DateTimeScreen.java
 This class defines all the UI elements present on Date Time screen and their actions and verification methods
 @author feroz khan
 @version 1.0
 */
public class DateTimeScreen {
    public static Logger log = LogManager.getLogger(DateTimeScreen.class);

    AppiumDriver driver;
    public DateTimeScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    protected String selectDateTimeTitle = "//android.view.View[@content-desc='Select Date \nand Time']";
    protected String selectedDate = "//android.view.View[@content-desc='%s']";
    protected String selectedTime = "//android.view.View[@content-desc='%s']";

    /***
     * Verifies the 'Select Date Time' Text is present or not
     * @return true or false
     */
    public boolean verifySelectDateTimeTitle() {
        log.info("Verifying 'Select Date and Time' button is present or not");
        try {
            driver.findElement(AppiumBy.xpath(selectDateTimeTitle));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /***
     * Verifies the selected date
     * @param date Date which need to verify as selected
     * @return true or false
     */
    public boolean verifySelectedDate(String date) {
        log.info("Verify the selected date " + date);
        try {
            driver.findElement(AppiumBy.xpath(String.format(selectedDate, date.replace(" ", "\n"))));
            // cannot verify the date is selected or not as there no attribute difference between selected and non-selected element
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /***
     * Verifies the selected time
     * @param time Time which need to verify as selected
     * @return true or false
     */
    public boolean verifySelectedTime(String time) {
        log.info("Verify the selected date " + time);
        try {
            driver.findElement(AppiumBy.xpath(String.format(selectedTime, time)));
            // cannot verify the time is selected or not as there no attribute difference between selected and non-selected element
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
