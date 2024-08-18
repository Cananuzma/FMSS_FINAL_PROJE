package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import Pages.SignupPage;

import java.net.MalformedURLException;
import java.net.URL;

public class signupstep {
    private AppiumDriver<MobileElement> driver;
    private SignupPage signupPage;

    public signupstep() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, "path/to/your/app.apk"); //
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        try {

            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        signupPage = new SignupPage(driver);
    }

    @Given("Kullanıcı kayıt ekranındadır")
    public void kullanıcıKayıtEkranındadır() {

    }

    @When("Kullanıcı gerekli tüm alanları doldurur ve {string} butonuna tıklar")
    public void kullanıcıGerekliTumAlanlarıDoldururVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("testuser");
        signupPage.enterEmail("testuser@example.com");
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @Then("Kullanıcının hesabı oluşturulur ve kullanıcı Ana Ekrana yönlendirilir")
    public void kullanıcınınHesabıOlusturulurVeKullanıcıAnaEkranaYonlendirilir() {
    }

    @When("Kullanıcı bazı alanları doldurmaz ve {string} butonuna tıklar")
    public void kullanıcıBazıAlanlarıDoldurmazVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("testuser");
        signupPage.enterEmail("testuser@example.com");
        // Do not enter password and confirm password
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @Then("{string} hata mesajı gösterilir ve kayıt işlemi gerçekleşmez")
    public void hataMesajıGosterilirVeKayıtIslemiGerceklesmez(String errorMessage) {
    }

    @When("Kullanıcı geçersiz bir e-posta adresi girer ve {string} butonuna tıklar")
    public void kullanıcıGecersizBirEPostaAdresiGirerVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("testuser");
        signupPage.enterEmail("invalid-email");
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı şifre alanına ve şifre onayı alanına farklı şifreler girer ve {string} butonuna tıklar")
    public void kullanıcıSifreAlanınaVeSifreOnayıAlanınaFarklıSifrelerGirerVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("testuser");
        signupPage.enterEmail("testuser@example.com");
        signupPage.enterPassword("Password1");
        signupPage.enterPasswordConfirm("DifferentPassword1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı daha önce kayıt olmuş bir e-posta adresi girer ve {string} butonuna tıklar")
    public void kullanıcıDahaOnceKayıtOlmusBirEPostaAdresiGirerVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("testuser");
        signupPage.enterEmail("existinguser@example.com");
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı gerekli tüm alanları doldurur ancak {string}ni kabul etmez ve {string} butonuna tıklar")
    public void kullanıcıGerekliTumAlanlarıDoldururAncakNiKabulEtmezVeButonunaTıklar(String termsCheckbox, String buttonText) {
        signupPage.enterUsername("testuser");
        signupPage.enterEmail("testuser@example.com");
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        // Do not check terms checkbox
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı zayıf bir şifre girer ve {string} butonuna tıklar")
    public void kullanıcıZayıfBirSifreGirerVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("testuser");
        signupPage.enterEmail("testuser@example.com");
        signupPage.enterPassword("weak");
        signupPage.enterPasswordConfirm("weak");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı e-posta adresi alanını boş bırakır ve {string} butonuna tıklar")
    public void kullanıcıEPostaAdresiAlanınıBosBırakırVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("testuser");
        // Empty email field
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı adı olarak sadece iki karakter girer ve {string} butonuna tıklar")
    public void kullanıcıAdıOlarakSadeceIkiKarakterGirerVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("ab"); // Only two characters
        signupPage.enterEmail("testuser@example.com");
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }

    @When("Kullanıcı daha önce kullanılmış bir kullanıcı adı girer ve {string} butonuna tıklar")
    public void kullanıcıDahaOnceKullanılmışBirKullanıcıAdıGirerVeButonunaTıklar(String buttonText) {
        signupPage.enterUsername("existinguser");
        signupPage.enterEmail("testuser@example.com");
        signupPage.enterPassword("ValidPassword1");
        signupPage.enterPasswordConfirm("ValidPassword1");
        signupPage.checkTerms();
        signupPage.clickRegisterButton();
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}