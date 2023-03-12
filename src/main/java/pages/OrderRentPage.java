package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderRentPage {

    private final WebDriver driver;
    private final By rentalPeriod = By.className("Dropdown-placeholder");
    private final By accept = By.xpath(".//button[contains(text(),'Да')]");
    private final By cancel = By.xpath(".//button[contains(text(),'Нет')]");
    private final By orderSuccess = By.xpath(".//div[contains(text(),'Заказ оформлен')]");
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By calendar = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalOrderBtn = By.xpath(
            ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private By calendarBtn(String date) {
        return By.xpath(String.format(".//div[@aria-label='Choose %s']", date));
    }

    private By rentalPeriodBtn(Integer rentalDays) {
        return By.xpath(String.format(".//div[@class='Dropdown-option'][%s]", rentalDays));
    }

    private By checkBoxColour(String colour) {
        return By.id(colour);
    }

    public OrderRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addRentInformationToForm(String date,Integer rentalDays,String colour,String commentValue){
        driver.findElement(calendar).click();
        driver.findElement(calendarBtn(date)).click();
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalPeriodBtn(rentalDays)).click();
        driver.findElement(checkBoxColour(colour)).click();
        driver.findElement(comment).sendKeys(commentValue);
        driver.findElement(rentalOrderBtn).click();
        driver.findElement(accept).click();
        waitOrdersSuccessForm(orderSuccess);
    }

    public String getTextOrdersSuccessForm(){
        WebElement element = driver.findElement(orderSuccess);
        return element.getText();
    }

    public void waitOrdersSuccessForm(By locator){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}