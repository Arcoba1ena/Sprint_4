package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuestionsDirectory {

    private final WebDriver driver;
    private By accordionBtn(int indexAccordionNumber) {
        return By.id(String.format("accordion__heading-%s", indexAccordionNumber));
    }

    private By accordionTxt(int indexAccordionNumber) {
        return By.xpath(String.format(".//*[@id='accordion__panel-%s']/p", indexAccordionNumber));
    }

    public QuestionsDirectory(WebDriver driver){
        this.driver = driver;
    }

    public String checkAccordionText(int indexAccordionNumber){
        driver.findElement(accordionBtn(indexAccordionNumber)).click();
        waitAccordionElements(accordionTxt(indexAccordionNumber));
        WebElement element = driver.findElement(accordionTxt(indexAccordionNumber));
        return element.getText();
    }

    public void scrollToAccordion(){
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitAccordionElements(By locator){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}