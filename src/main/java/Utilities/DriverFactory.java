package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

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
            System.out.println("Browser value received = " + browserName.get());
            if (browser == null || browser.isEmpty()) {
                browser = "chrome";
            }
            boolean isGridEnabled =
                    Boolean.parseBoolean(System.getProperty("selenium.grid.enabled", "false"));

            if (isGridEnabled) {
                driver.set(createRemoteDriver(browser));
            } else {
                driver.set(createDriver(browser.toLowerCase()));
            }
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

    private WebDriver createRemoteDriver(String browser) {
        try {
            String gridUrl = System.getProperty(
                    "selenium.grid.url",
                    "http://hub:4444"
            );

            MutableCapabilities options;

            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--incognito");
                    options = chromeOptions;
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--private");
                    options = firefoxOptions;
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            return new RemoteWebDriver(new URL(gridUrl), options);

        } catch (Exception e) {
            throw new RuntimeException("Failed to create RemoteWebDriver", e);
        }
    }

    public void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
