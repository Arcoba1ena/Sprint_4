package tests;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import pages.MainPage;
import pages.OrderUserInfoPage;
import org.openqa.selenium.WebDriver;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Parameterized.class)
public class OrderUserInfoPageTest {
    @Before
    public void setConfig() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;
    private final String name;
    private final String surName;
    private final String address;
    private final String phoneNumber;
    private final Integer indexSelect;

    public OrderUserInfoPageTest(String name, String surName, String address,
                                 String phoneNumber, Integer indexSelect) {
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.indexSelect = indexSelect;
    }

    @Parameterized.Parameters(name = "{0}-{1}-{2}-{3}-{4}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Александр", "Сергеевич", "Москва", "+79951899955", 1},
                {"Лев", "Толстой", "Санкт-Петербург", "+79951899956", 2},
                {"Николай", "Гоголь", "Казань", "+79951899957", 3},
                {"Федор", "Достоевский", "Краснодар", "+79951899958", 4},
                {"Иван", "Тургенев", "Ростов", "+79951899959", 5}
        };
    }

    public void getStarted(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void addUserInfo(){
        OrderUserInfoPage orderPage = new OrderUserInfoPage(driver);
        orderPage.clickToCookiesBtn();
        orderPage.addInformationToForm(name, surName, address, phoneNumber, indexSelect);
    }

    @Test
    public void checkUserInfoPageHeaderBtn() {
       getStarted();
       MainPage mainPage = new MainPage(driver);
       mainPage.waitLoadMainPages();
       mainPage.clickHeaderOrderBtn();
       addUserInfo();
    }

    @Test
    public void checkUserInfoPageRoadMapBtn() {
        getStarted();
        MainPage mainPage = new MainPage(driver);
        mainPage.waitLoadMainPages();
        mainPage.clickRoadMapOrderBtn();
        addUserInfo();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}