package hooks;

import Utilities.DriverFactory;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class cukeHooks {
    @Before()
    public void beforeScenario(Scenario scenario) {
        String browser = DriverFactory.getInstance().getBrowser();
        if (browser == null) {
            browser = "chrome";
        }
        ExtentCucumberAdapter.getCurrentScenario()
                .log(Status.INFO, "Execution Started: " + scenario.getName());
        ExtentCucumberAdapter.getCurrentScenario()
                .assignCategory(browser.toUpperCase());
    }


    @AfterStep
    public void addScreenshot(Scenario scenario) {
    }
    @After
    public void afterScenario(Scenario scenario){
        ExtentCucumberAdapter.getCurrentScenario().log(Status.INFO,"Finished: " + scenario.getStatus());
        DriverFactory.getInstance().closeDriver();
    }
}
