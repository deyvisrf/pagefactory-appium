package helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class AppiumDriverHelper {

    private static AppiumDriver<MobileElement> driver;

    private static void startAppium() throws IOException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "VirtualDevice");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("app", "../pagefactory-appium/AppiumAndroid/FasTip.apk");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AppiumDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            try {
                startAppium();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    @After
    public static void tearDown() {
        driver.quit();
        driver = null;
    }
}
