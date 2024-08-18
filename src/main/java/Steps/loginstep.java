package Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import Pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class loginstep
{
    static AppiumDriver driver;
   public LoginPage loginPage ;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Given("Kullanıcı oturum açma sayfasında")
    public void kullanıcıOturumAcmaSayfasında() {
        BaseOptions options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:deviceName", "Pixel 6")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:udid", "Android Emulator")
                .amend("appium:avd", "Pixel_6_Pro_API_32")
                .amend("appium:fastReset", true)
                .amend("appium:app", "/Users/cananuzma/Desktop/appiumapk/fmss-test-app.apk");

        driver = new AndroidDriver(this.getUrl(), options);
        loginPage.launchAppiumDriverAndInstallApk(driver);
    }

    @When("Kullanıcı geçerli bir e-posta ve şifre ile oturum aç butonuna tıklar.")
    public void kullanıcıGecerliBirEPostaVeSifreIleOturumAcButonunaTıklar() {
        loginPage.fillUserNameAndPass("gecerli_Eposta");
        loginPage.fillPassword("gecerli_Sifre");
        driver.findElement(By.id("login_button_id")).click();
    }

    @Then("Kullanıcı Ana Sayfaya yönlendirilir.")
    public void kullanıcıAnaSayfayaYonlendirilir() {

        String expectedUrl = "http://unicarrental.com/home";
        String actualUrl = driver.getCurrentUrl();
        assert expectedUrl.equals(actualUrl);
    }

    @When("Kullanıcı geçersiz bir e-posta veya yanlış şifre ile oturum aç butonuna tıklar.")
    public void kullanıcıGecersizBirEPostaVeyaYanlısSifreIleOturumAcButonunaTıklar() {
        loginPage.fillUserNameAndPass("gecersizEposta");
        loginPage.fillPassword("yanlisSifre");
        driver.findElement(By.id("login_button_id")).click();
    }

    @Then("Kullanıcıya {string} uyarısı ekranda gösterilir.")
    public void kullanıcıyaUyarısıEkrandaGosterilir(String uyarıMesajı) {
        String actualMessage = driver.findElement(By.id("uyari_mesaji_id")).getText();
        assert actualMessage.equals(uyarıMesajı);
    }
}
