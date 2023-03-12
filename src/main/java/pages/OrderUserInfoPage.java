package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderUserInfoPage {
    private final WebDriver driver;

    private final By cookiesBtn = By.className("App_CookieButton__3cvqF");
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By stationName = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By continueBtn = By.xpath(
            ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private By stationValue(Integer indexSelect) {
        return By.xpath(String.format(".//div[@class='select-search__select']/ul/li[%s]",indexSelect));
    }

    public OrderUserInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addInformationToForm(String userName, String userSurname, String addressValue,
                                     String phoneNumberValue, Integer indexSelect){
        driver.findElement(name).sendKeys(userName);
        driver.findElement(surname).sendKeys(userSurname);
        driver.findElement(address).sendKeys(addressValue);
        driver.findElement(stationName).click();
        driver.findElement(stationValue(indexSelect)).click();
        driver.findElement(phoneNumber).sendKeys(phoneNumberValue);
        driver.findElement(continueBtn).click();
    }

    public void clickToCookiesBtn() {
        driver.findElement(cookiesBtn).click();
    }
}