package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected JavascriptExecutor javascriptExecutor;

    public BaseTest(){
        this.driver = DriverFactory.getInstance().getDriver();
       this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.javascriptExecutor = (JavascriptExecutor)driver;
    }
    public void waitForElementToBeVisible(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clickElementByJS(String value, WebElement element) {
        javascriptExecutor.executeScript(value, element);
    }
}
