package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.URL;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeClass
    @Parameters({"platformName"})
    public void setUp(String platformName) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        if (platformName.equalsIgnoreCase("Android")) {

            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "Android Emulator");
            caps.setCapability("automationName", "UiAutomator2");

            caps.setCapability("appPackage", "com.example.app");
            caps.setCapability("appActivity", ".MainActivity");

            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"),
                    caps
            );

        } else if (platformName.equalsIgnoreCase("iOS")) {

            caps.setCapability("platformName", "iOS");
            caps.setCapability("deviceName", "iPhone Simulator");
            caps.setCapability("automationName", "XCUITest");

            caps.setCapability("bundleId", "com.example.app");

            driver = new IOSDriver(
                    new URL("http://127.0.0.1:4723"),
                    caps
            );
        }
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}