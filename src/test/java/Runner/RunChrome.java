package Runner;

import Utilities.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = {"StepDefination", "hooks"},
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class RunChrome extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void setBrowser(@Optional("chrome") String browser) {
        DriverFactory.getInstance().setBrowser(browser);
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();  // Parallel scenarios only within Chrome
    }
}
