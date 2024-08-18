package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SignupPage {
    private AppiumDriver driver;

    public SignupPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void launchAppiumDriverAndInstallApk() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName","UiAutomator2");
        capabilities.setCapability("appium:deviceName","Pixel_7");
        capabilities.setCapability("appium:udid", "Android Emulator");
        capabilities.setCapability("appium:avd", "Pixel_6_Pro_API_32");
        capabilities.setCapability("appium:app", "/path/to/your/app.apk");

        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("com.example.app:id/username"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("com.example.app:id/email"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("com.example.app:id/password"));
    }

    public WebElement getPasswordConfirmField() {
        return driver.findElement(By.id("com.example.app:id/password_confirm"));
    }

    public WebElement getRegisterButton() {
        return driver.findElement(By.id("com.example.app:id/register_button"));
    }

    public WebElement getTermsCheckbox() {
        return driver.findElement(By.id("com.example.app:id/terms_checkbox"));
    }

    public void enterUsername(String username) {
        getUsernameField().sendKeys(username);
    }

    public void enterEmail(String email) {
        getEmailField().sendKeys(email);
    }

    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public void enterPasswordConfirm(String passwordConfirm) {
        getPasswordConfirmField().sendKeys(passwordConfirm);
    }

    public void clickRegisterButton() {
        getRegisterButton().click();
    }

    public void checkTerms() {
        if (!getTermsCheckbox().isSelected()) {
            getTermsCheckbox().click();
        }
    }

    public void uncheckTerms() {
        if (getTermsCheckbox().isSelected()) {
            getTermsCheckbox().click();
        }
    }
}
