Feature: Login functionality verification

  Scenario: Başarılı oturum açma
    Given Kullanıcı oturum açma sayfasında
    When  Kullanıcı geçerli bir e-posta ve şifre ile oturum aç butonuna tıklar.
    Then  Kullanıcı Ana Sayfaya yönlendirilir.

  Scenario: Başarısız oturum açma
    Given Kullanıcı oturum açma sayfasında
    When  Kullanıcı geçersiz bir e-posta veya yanlış şifre ile oturum aç butonuna tıklar.
    Then  Kullanıcıya "Geçersiz E-Posta veya Şifre" uyarısı ekranda gösterilir.


    Scenario: Kullanıcı ilgili alana geçersiz karakter girişi yaptı
      Given Kullanıcı oturum açma sayfasında
      When  Kullanıcı ilgili alana geçersiz bir karakter  yazmıştır.
      Then  Kullanıcıya "Lütfen geçerli bir karakter giriniz" uyarısı ekranda gösterilir.


      Scenario:Kullanıcı ilgili alanları doldurmadan kullanıcı girişi yaptı
        Given Kullanıcı oturum açma sayfasında
        When  Kullanıcı ilgili alanlarda gerekli bilgileri doldurmadı.
        Then  Kullanıcıya "Lütfen gerekli alanları doldurunuz" uyarısı ekranda gösterilir.

  Scenario: Şifre alanına minimum karakter girmeyerek başarısız oturum açma
    Given Kullanıcı oturum açma sayfasında
    When  Kullanıcı geçerli bir e-posta ile şifre alanına minimum karakterden az giriş yapar ve oturum aç butonuna tıklar.
    Then  Kullanıcıya "Şifre minimum 6 karakter olmalıdır" uyarısı ekranda gösterilir.
