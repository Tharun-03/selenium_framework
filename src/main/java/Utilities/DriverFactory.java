package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static DriverFactory instance = null;

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private ThreadLocal<String> browserName = new ThreadLocal<>();


    public DriverFactory() {

    }

    public void setBrowser(String browser) {
        browserName.set(browser);
    }
    public String getBrowser() {
        return browserName.get();
    }

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = browserName.get();
            if (browser == null || browser.isEmpty()) {
                browser = "chrome";
            }
            driver.set(createDriver(browser.toLowerCase()));
        }
        return driver.get();
    }

    private WebDriver createDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--incognito", "--start-maximized");
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--private");
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            browserName.remove();
        }
    }

}
