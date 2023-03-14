package tests;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import pages.MainPage;
import pages.OrderRentPage;
import pages.OrderUserInfoPage;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class OrderRentPageTest {
    @Before
    public void setConfig() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;
    private final String date;
    private final String colour;
    private final Integer rentalDays;
    private final String commentValue;

    public OrderRentPageTest(String date, Integer rentalDays, String colour, String commentValue) {
        this.date = date;
        this.rentalDays = rentalDays;
        this.colour = colour;
        this.commentValue = commentValue;
    }

    @Parameterized.Parameters(name = "{0}-{1}-{2}-{3}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"среда, 1-е марта 2023 г.", 1, "black", "Домофон не работает"},
                {"четверг, 16-е марта 2023 г.", 4, "grey", "Домофон работает"},
                {"пятница, 31-е марта 2023 г.", 7, "black", "Цокольный этаж"},
        };
    }

    @Test
    public void checkOrdersRentPage(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.waitLoadMainPages();
        mainPage.clickHeaderOrderBtn();

        OrderUserInfoPage orderPage = new OrderUserInfoPage(driver);
        orderPage.clickToCookiesBtn();
        orderPage.addInformationToForm("Александр","Пушкин",
                "Москва", "+79951899955",1);

        OrderRentPage orderRentPage = new OrderRentPage(driver);
        orderRentPage.addRentInformationToForm(date,rentalDays, colour,commentValue);

        MatcherAssert.assertThat("mustBePassed",
        orderRentPage.getTextOrdersSuccessForm(), containsString("Заказ оформлен"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}