package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    public void launchAppiumDriverAndInstallApk(AppiumDriver driver) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName","UiAutomator2");
        capabilities.setCapability("appium:deviceName","Pixel_7");
        capabilities.setCapability("appium:udid", "Android Emulator");
        capabilities.setCapability("appium:avd", "Pixel_6_Pro_API_32");
        capabilities.setCapability("appium:app", "/Users/Desktop/appiumapk/selendroid-test-app.apk");
        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public WebElement userNameEl(){
        WebElement mobileElement = null;
        return mobileElement;
    }

    public WebElement passwordEl(){
        WebElement mobileElement = null;
        return mobileElement;
    }

    public void fillUserNameAndPass(String value) {
        userNameEl().sendKeys(value);
    }

    public void fillPassword(String value) {
        passwordEl().sendKeys(value);
    }
}

