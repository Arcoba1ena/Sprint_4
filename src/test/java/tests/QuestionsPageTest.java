package tests;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import pages.MainPage;
import pages.QuestionsDirectory;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class QuestionsPageTest {
    @Before
    public void setConfig() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;
    private final Integer indexNumber;
    private final String checkedText;

    public QuestionsPageTest(Integer indexNumber, String checkedText) {
        this.indexNumber = indexNumber;
        this.checkedText = checkedText;
    }

    @Parameterized.Parameters(name = "Текст начинается со слов: {1}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {0,"Сутки — 400 рублей"},
                {1,"Пока что у нас так"},
                {2,"Допустим, вы оформляете заказ"},
                {3,"Только начиная с завтрашнего дня"},
                {4,"Пока что нет! Но если что-то срочное"},
                {5,"Самокат приезжает к вам с полной зарядкой"},
                {6,"Да, пока самокат не привезли"},
                {7,"Да, обязательно. Всем самокатов!"},
        };
    }

    @Test
    public void checkQuestionsText() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.waitLoadMainPages();

        QuestionsDirectory questionsDirectory = new QuestionsDirectory(driver);
        questionsDirectory.scrollToAccordion();
        MatcherAssert.assertThat("mustBePassed",
                questionsDirectory.checkAccordionText(indexNumber), startsWith(checkedText));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}