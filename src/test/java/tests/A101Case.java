package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.A101Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class A101Case extends TestBaseRapor {

    @Test
    public void a101Case() throws IOException, InterruptedException {

//1-A101 Anasayfasina gidilir

        extentTest = extentReports.createTest("A101 Otomasyon", "Uctan uca odeme sistemi");
        Driver.getDriver().get(ConfigReader.getProperty("A101Url"));
        extentTest.info("A101 anasayfasina gidildi");
        A101Page a101Page = new A101Page();
        ReusableMethods.waitFor(2);
        a101Page.cookiesAccept.click();


//2-Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.

        a101Page.giyimAksesuarButonu.click();
        extentTest.info("Giyim-Aksesuar butonu tiklanir");
        a101Page.kadinIcGiyimButonu.click();
        extentTest.info("Kadin ic giyim butonu tiklanir");
        ReusableMethods.waitFor(3);
        a101Page.dizAltiCorapButonu.click();
        extentTest.info("Dizalti corap bolumune girilir");
        a101Page.siyahCorapButonu.click();
        extentTest.info("Siyah corap butonuna tiklanir");


//3-Acilan urunun siyah oldugu dogrulanir

        String acilanCorabRengi = a101Page.corapRenkKontrol.getText();
        Assert.assertTrue(acilanCorabRengi.contains("SİYAH"));
        extentTest.info("urunun siyah oldugu kontrol edilir");
        ReusableMethods.getScreenshot("CorapRenkKotrolu");
        extentTest.info("Urunun fotografi cekilerek kayit altina alinir");


//4-Sepete ekle butonuna tiklanir

        ReusableMethods.waitFor(2);
        a101Page.corabiSepeteEkleButonu.click();
        extentTest.info("Sepete ekle butonuna tiklanir");


//5-Sepeti Goruntule butonuna tiklanir

        a101Page.sepetiGoruntuleButonu.click();
        extentTest.info("Sepeti goruntule butonuna tiklanir");


//6-Sepeti onayla butonuna tiklanir

        a101Page.sepetiOnaylaButonu.click();
        extentTest.info("Sepeti onayla butonuna tiklanir");


//7-Uye olmadan devam et butonuna tiklanir

        ReusableMethods.waitFor(2);
        a101Page.uyeOlmadanDevamEtButonu.click();
        extentTest.info("Uye olmadan devam et butonuna tiklanir");


//8-Mail ekranı gelir. Ekranın geldiği doğrulanır ve bir mail adresi girilir.

        ReusableMethods.waitFor(2);
        Assert.assertTrue(a101Page.mailTextBox.isDisplayed()); // mail kutusunun gorunur oldugu test edlir
        extentTest.info("Mail kutusunun gorunur oldugu test edilir");
        a101Page.mailTextBox.sendKeys(ConfigReader.getProperty("mail"));
        a101Page.mailTextBoxDevamEtButonu.click();
        extentTest.info("Bir mail adresi girilir");


//9-Adres ekrani gelir, adres olustur dedikten sonra odeme ekrani gelir

        a101Page.adresOlusturButonu.click();
        a101Page.adresOlusturAdresBasligiBox.sendKeys("Ev Adresi");
        a101Page.adresOlusturIsimBox.sendKeys("isim");
        a101Page.adresOlusturSoyadBox.sendKeys("soyad");
        ReusableMethods.waitFor(3);
        a101Page.adresOlusturCepTelBox.sendKeys("5054443322");
        extentTest.info("Adres ekrani gelir, adres olustur dedikten sonra odeme ekrani gelir");


        Select select;
        select = new Select(a101Page.adresOlusturIlDropDown);
        List<WebElement> IlSayisi = select.getOptions();
        Random random = new Random();
        int index = random.nextInt(IlSayisi.size());
        while (index == 1) {
            index = random.nextInt(IlSayisi.size());
        }
        extentTest.info("Random olarak bir il secimi yapar");


        select.selectByIndex(index);
        select = new Select(a101Page.adresOlusturIlceDropDown);
        List<WebElement> ilceSayisi = select.getOptions();
        random = new Random();
        index = random.nextInt(ilceSayisi.size());
        while (index == 1) {
            index = random.nextInt(ilceSayisi.size());
        }
        extentTest.info("Random olarak bir ilce secimi yapar");


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(a101Page.adresOlusturMahalleDropDown));

        select.selectByIndex(index);
        select = new Select(a101Page.adresOlusturMahalleDropDown);
        List<WebElement> mahalleSayisi = select.getOptions();
        random = new Random();
        index = random.nextInt(mahalleSayisi.size());
        while (index == 1) {
            index = random.nextInt(mahalleSayisi.size());
        }

        //Mahalle Drop Down'ında StaleElementReferenceException verdigi icin bu sekilde Handle edildi
        for (int retry = 0; retry < 10; retry++) {
            try {
                select.selectByIndex(index);
                break;
            } catch (StaleElementReferenceException e) {
                e.toString();
            }
        }
        extentTest.info("Random olarak bir mahalle secimi yapar");


        // fake bir adres yazdirdik
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(a101Page.adresOlusturAdresBox).
                sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        extentTest.info("Fake bir adres yazdirilir");


        //Kargo seçimi
        WebElement kargo = a101Page.kargo;

        for (int retry = 0; retry < 5; retry++) {
            try {
                if (!kargo.isSelected()) kargo.click();
                break;
            } catch (StaleElementReferenceException ex) {
                ex.toString();
            }
        }

        extentTest.info("Kargo secenekleri arasindan secim yapildi");

        //Kaydet ve devam et butonu tıklanır

        Thread.sleep(5000);
        a101Page.kargoKaydetVeDevamButonu.click();
        Thread.sleep(5000);


        //10-Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiğini ,doğru ekrana yönlendiklerini kontrol edecekler.

        int krediKartiHaneSayisi=16;

        actions.click(a101Page.kartBilgileriAdSoyad)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digits(krediKartiHaneSayisi)).perform();
        extentTest.info("Ad Soyad ve Kart Numarasi bilgileri doldurulur");

        select.selectByIndex(index);
        select = new Select(a101Page.sonKullanmaTarihiAyDropDown);
        List<WebElement> ayListesi = select.getOptions();
        random = new Random();
        index = random.nextInt(ayListesi.size());
        while (index == 1) {
            index = random.nextInt(ayListesi.size());
        }


        extentTest.info("Random olarak bir ay girilir");
        select.selectByIndex(index);
        select = new Select(a101Page.sonKullanmaTarihiYilDropDown);
        List<WebElement> yilListesi = select.getOptions();
        random = new Random();
        index = random.nextInt(yilListesi.size());
        while (index == 1) {
            index = random.nextInt(yilListesi.size());
        }

        extentTest.info("Random olarak bir yil girilir");


        int cvv=3;
        a101Page.krediKartiCvv.sendKeys(faker.number().digits(cvv));
        extentTest.info("Random olarak CVV girilir");



        //Odeme ekranında olundugu kontrol edilir

        String expectedText="Kart ile ödeme";
        String actualText= a101Page.kartIleOdemeText.getText();
        Assert.assertEquals(actualText,expectedText);
        extentTest.info("Odeme ekranında olundugu kontrol edilir");

        ReusableMethods.jsclick(a101Page.onBilgileriKabul);

        extentTest.info("On bilgileri kabul secenegi tiklandi.");

        try {
            a101Page.mesafeliSatisSözlesmesi.click();
                    } catch (Exception e) {
            throw new RuntimeException(e);
        }

        extentTest.info("Cıkan mesafeli satis sözlesmesi kapatildi.");

        a101Page.siparisiTamamlaButton.sendKeys(Keys.ENTER);

        extentTest.info("Siparisi tamamla butonu tiklandi.");

        ReusableMethods.getSoftAssert().assertTrue(a101Page.kartBilgileriniKontrolEdiniz.isDisplayed());

        extentTest.info("Siparis bilgilerinin dogru olmadıgı kart bilgilerini kontrol ediniz yazisi uzerinden dogrulandi.");

        Driver.closeDriver();

        extentTest.info("Sayfa kapatildi.");

        extentTest.pass("Test Başarılı.");
    }
}