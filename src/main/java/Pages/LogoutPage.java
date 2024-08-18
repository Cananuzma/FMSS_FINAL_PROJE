package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoutPage {
    private AppiumDriver driver;

    public LogoutPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.id("logout_button_id"));
    }

    public WebElement getInternetConnectionError() {
        return driver.findElement(By.id("internet_error_id"));
    }

    public WebElement getAlertDialogCancelButton() {
        return driver.findElement(By.id("cancel_button_id"));
    }

    public WebElement getAlertDialogOkButton() {
        return driver.findElement(By.id("ok_button_id"));
    }

    public WebElement getLoginScreen() {
        return driver.findElement(By.id("login_screen_id"));
    }

    public void clickLogoutButton() {
        getLogoutButton().click();
    }

    public void clickCancelButton() {
        getAlertDialogCancelButton().click();
    }

    public void clickOkButton() {
        getAlertDialogOkButton().click();
    }

    public boolean isInternetConnectionErrorDisplayed() {
        return getInternetConnectionError().isDisplayed();
    }

    public boolean isLoginScreenDisplayed() {
        return getLoginScreen().isDisplayed();
    }
}