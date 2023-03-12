package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage {

    private WebDriver driver;
    private final By header = By.className("Home_Header__iJKdX");
    private final By headerOrderBtn = By.className("Button_Button__ra12g");
    private final By roadMapOrderBtn = By.xpath(
            ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickHeaderOrderBtn(){
        driver.findElement(headerOrderBtn).click();
    }

    public void clickRoadMapOrderBtn(){
        scrollToOrderBtn();
        driver.findElement(roadMapOrderBtn).click();
    }

    public void scrollToOrderBtn(){
        WebElement element = driver.findElement(roadMapOrderBtn);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitLoadMainPages(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(header));
    }
}