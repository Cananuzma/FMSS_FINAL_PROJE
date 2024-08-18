Feature: : Çıkış yapma fonksiyonunun doğrulanması

Scenario: : Uygulamadan başarılı çıkış yapma
Given Kullanıcı başarılı bir şekilde login olup Ana Ekrandadır
When  Kullanıcı "Çıkış" butonuna tıklar
Then  Uygulamada oturum kapatılır ve kullanıcı giriş ekranına yönlendirilir

Scenario: : İnternet bağlantısı olmadan çıkış yapma
  Given Kullanıcı başarılı bir şekilde login olup Ana Ekrandadır ve internet bağlantısı yoktur
  When  Kullanıcı "Çıkış" butonuna tıklar
  Then  "İnternet bağlantısı yok, çıkış yapılamadı" hata mesajı gösterilir
  And  Uygulamada oturum açık kalır

Scenario: : Çıkış işlemini iptal etme
  Given Kullanıcı başarılı bir şekilde login olup Ana Ekrandadır
  When  Kullanıcı "Çıkış" butonuna tıklar ve çıkış işlemini onaylamadan "İptal" butonuna basar
  Then  Uygulamada oturum açık kalır
  And  Kullanıcı Ana Ekranda kalır

Scenario: : Tekrar giriş yapmadan çıkış yapmaya çalışma
  Given Kullanıcı oturumunu kapatmıştır ve Ana Ekranda değildir
  When  Kullanıcı uygulamayı yeniden açıp "Çıkış" butonuna tıklar
  Then  "Oturum açık değil" hata mesajı gösterilir
  And  Kullanıcı giriş ekranında kalır

Scenario: : Uygulama kapanırken çıkış yapma
  Given Kullanıcı başarılı bir şekilde login olup Ana Ekrandadır
  When  Kullanıcı uygulamayı kapatmadan önce "Çıkış" butonuna tıklar
  Then  Uygulamada oturum kapatılır
  And  Uygulama kapatılır
  And  Kullanıcı uygulamayı tekrar açtığında giriş ekranında olur





