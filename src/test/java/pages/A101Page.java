package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class A101Page {

    public A101Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='Kabul Et']")
    public WebElement cookiesAccept;


    @FindBy(xpath = "//a[@title='GİYİM & AKSESUAR']")
    public WebElement giyimAksesuarButonu;

    @FindBy(xpath = "//a[@data-value='1565']")
    public WebElement kadinIcGiyimButonu;

    @FindBy(xpath = "//a[@data-value='1567']")
    public WebElement dizAltiCorapButonu;

    @FindBy(xpath = "//a[@title='Penti Kadın 50 Denye Pantolon Çorabı Siyah']")
    public WebElement siyahCorapButonu;

    @FindBy(xpath = "//div[@class='selected-variant-text']")
    public WebElement corapRenkKontrol;

    @FindBy(xpath = "//i[@class='icon-sepetekle']")
    public WebElement corabiSepeteEkleButonu;

    @FindBy(xpath = "(//*[text()='Sepeti Görüntüle'])[2]")
    public WebElement sepetiGoruntuleButonu;

    @FindBy(xpath = "(//a[@title='Sepeti Onayla'])[2]")
    public WebElement sepetiOnaylaButonu;

    @FindBy(xpath = "//a[@title='ÜYE OLMADAN DEVAM ET']")
    public WebElement uyeOlmadanDevamEtButonu;

    @FindBy(xpath = "//input[@name='user_email']")
    public WebElement mailTextBox;

    @FindBy(xpath = "//button[@class='button block green']")
    public WebElement mailTextBoxDevamEtButonu;

    @FindBy(xpath = "//a[@class='new-address js-new-address']")
    public WebElement adresOlusturButonu;

    @FindBy(xpath = "//input[@name='title']")
    public WebElement adresOlusturAdresBasligiBox;

    @FindBy(xpath = "//input[@name='first_name']")
    public WebElement adresOlusturIsimBox;

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement adresOlusturSoyadBox;

    @FindBy(xpath = "//input[@name='phone_number']")
    public WebElement adresOlusturCepTelBox;

    @FindBy(xpath = "//select[@name='city']")
    public WebElement adresOlusturIlDropDown;

    @FindBy(xpath = "//select[@name='township']")
    public WebElement adresOlusturIlceDropDown;

    @FindBy(xpath = "//select[@class='js-district']")
    public WebElement adresOlusturMahalleDropDown;

    @FindBy(xpath = "//textarea[@name='line']")
    public WebElement adresOlusturAdresBox;


    @FindBy(css = ".button.block.green.js-proceed-button")
    public WebElement kargoKaydetVeDevamButonu;

    @FindBy(xpath = "(//input[@name='name'])[2]")
    public WebElement kartBilgileriAdSoyad;


    @FindBy(xpath = "(//div[@data-type='masterpass'])[1]")
    public WebElement kartIleOdemeText;

    @FindBy(xpath = "(//select[@class='js-payment-month'])[2]")
    public WebElement sonKullanmaTarihiAyDropDown;

    @FindBy(xpath = "(//select[@name='card_year'])[2]")
    public WebElement sonKullanmaTarihiYilDropDown;


    @FindBy(xpath = "(//input[@name='card_cvv'])[2]")
    public WebElement krediKartiCvv;

    @FindBy(xpath = "(//*[@class='js-checkout-cargo-item'])[1]")
    public WebElement kargo;

    @FindBy(xpath = "//label[@for='agrement2']")
    public static WebElement onBilgileriKabul;

    @FindBy(xpath = "//button[@title='Close (Esc)']")
    public WebElement mesafeliSatisSözlesmesi;

    @FindBy(xpath = "//div[@class='payment-area js-payment-tab-content active']//button[@type='submit']")
    public WebElement siparisiTamamlaButton;

    @FindBy(xpath = "(//*[@class='error checkout__error js-error-card_number '])[2]")
    public WebElement kartBilgileriniKontrolEdiniz;


}
