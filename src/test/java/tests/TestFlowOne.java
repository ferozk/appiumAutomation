package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import utils.Constants;

public class TestFlowOne extends BaseTest {

    public static Logger log = LogManager.getLogger(TestFlowOne.class);

    @Test
    public void TestFlow () {
        try {
            log.info("Test Starts");
            assert homeScreen.verifyGetStartedButton() : "'Get started' button not present on home screen";
            assert homeScreen.verifyHomeScreenHeaderText() : "Failed to verify home screen title text: "
                    + Constants.homeScreenTitleText;
            assert homeScreen.verifyHomeScreenSubHeadingText() : "Failed to verify home screen sub title text: "
                    + Constants.homeScreenSubTitleText;
            homeScreen.clickGetStartedButton();
            assert servicesListScreen.verifyServicesListScreenTitle() : "Failed to verify service list screen title text: "
                    + Constants.serviceListScreenTitleText;
            servicesListScreen.locateAndChooseService(Constants.cook);
            servicesListScreen.clickNextButton();
            assert cleaningServiceScreen.verifyCleaningServiceScreenTitle() : "Failed to verify cleaning services screen title text: "
                    + Constants.cleaningServicesScreenTitle;
            cleaningServiceScreen.selectCleaningOption(Constants.livingRoom);
            cleaningServiceScreen.selectCleaningOption(Constants.bedroom);
            cleaningServiceScreen.selectCountOfBedroom("4");
            cleaningServiceScreen.clickNextButton();
            assert dateTimeScreen.verifySelectDateTimeTitle() : "Failed to verify date time screen title text: "
                    + Constants.selectDateTimeTitle;
            assert dateTimeScreen.verifySelectedDate("2 Sat") : "Failed to verify selected date '2 Sat'";
            assert dateTimeScreen.verifySelectedTime("13:30") : "Failed to verify selected time '13:30'";
            log.info("Test completed");
        } catch (Exception | Error e) {
            log.error("Test Failed" );
            deviceUtils.takeScreenShot("TestFlow");
        }
    }

}
