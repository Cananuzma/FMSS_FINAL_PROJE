Feature: Kayıt ol fonksiyonunun çağırılması

  Scenario: : Uygulamaya başarılı bir şekilde kayıt olma
  Given Kullanıcı kayıt ekranındadır
  When  Kullanıcı gerekli tüm alanları doldurur ve "Kayıt Ol" butonuna tıklar
  Then  Kullanıcının hesabı oluşturulur ve kullanıcı Ana Ekrana yönlendirilir

  Scenario: : Eksik bilgiyle kayıt olmaya çalışma
    Given Kullanıcı kayıt ekranındadır
    When  Kullanıcı bazı alanları doldurmaz ve "Kayıt Ol" butonuna tıklar
    Then  "Lütfen tüm alanları doldurun" hata mesajı gösterilir ve kayıt işlemi gerçekleşmez

  Scenario: : Geçersiz e-posta adresiyle kayıt olmaya çalışma
    Given Kullanıcı kayıt ekranındadır
    When  Kullanıcı geçersiz bir e-posta adresi girer ve "Kayıt Ol" butonuna tıklar
    Then  "Geçerli bir e-posta adresi girin" hata mesajı gösterilir ve kayıt işlemi gerçekleşmez

  Scenario: : Şifre ve şifre onayı uyuşmazlığı
    Given Kullanıcı kayıt ekranındadır
    When  Kullanıcı şifre alanına ve şifre onayı alanına farklı şifreler girer ve "Kayıt Ol" butonuna tıklar
    Then  "Şifreler uyuşmuyor" hata mesajı gösterilir ve kayıt işlemi gerçekleşmez

  Scenario: : Var olan e-posta adresiyle kayıt olmaya çalışma
    Given Kullanıcı kayıt ekranındadır
    When  Kullanıcı daha önce kayıt olmuş bir e-posta adresi girer ve "Kayıt Ol" butonuna tıklar
    Then  "Bu e-posta adresi zaten kullanılıyor" hata mesajı gösterilir ve kayıt işlemi gerçekleşmez

  Scenario: : Kullanıcı sözleşmesini kabul etmeden kayıt olmaya çalışma
    Given Kullanıcı kayıt ekranındadır
    When  Kullanıcı gerekli tüm alanları doldurur ancak "Kullanıcı Sözleşmesi"ni kabul etmez ve "Kayıt Ol" butonuna tıklar
    Then  "Kullanıcı Sözleşmesi'ni kabul etmelisiniz" hata mesajı gösterilir ve kayıt işlemi gerçekleşmez

  Scenario: : Güçlü olmayan bir şifreyle kayıt olmaya çalışma
    Given Kullanıcı kayıt ekranındadır
    When  Kullanıcı zayıf bir şifre girer ve "Kayıt Ol" butonuna tıklar
    Then  "Şifreniz en az 8 karakter, bir büyük harf, bir küçük harf ve bir rakam içermelidir" hata mesajı gösterilir ve kayıt işlemi gerçekleşmez

  Scenario: : E-posta adresi olmadan kayıt olmaya çalışma
    Given Kullanıcı kayıt ekranındadır
    When  Kullanıcı e-posta adresi alanını boş bırakır ve "Kayıt Ol" butonuna tıklar
    Then  "E-posta adresi gereklidir" hata mesajı gösterilir ve kayıt işlemi gerçekleşmez

  Scenario: : Çok kısa bir kullanıcı adıyla kayıt olmaya çalışma
    Given Kullanıcı kayıt ekranındadır
    When  Kullanıcı adı olarak sadece iki karakter girer ve "Kayıt Ol" butonuna tıklar
    Then  "Kullanıcı adı en az 3 karakter olmalıdır" hata mesajı gösterilir ve kayıt işlemi gerçekleşmez

  Scenario: : Zaten kayıtlı bir kullanıcı adıyla kayıt olmaya çalışma
    Given Kullanıcı kayıt ekranındadır
    When  Kullanıcı daha önce kullanılmış bir kullanıcı adı girer ve "Kayıt Ol" butonuna tıklar
    Then  "Bu kullanıcı adı zaten kullanılıyor" hata mesajı gösterilir ve kayıt işlemi gerçekleşmez










