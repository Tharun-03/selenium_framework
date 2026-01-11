package IPages.Actions;

import IPages.ILaunch;
import Utilities.ConfigReader;
import Utilities.DriverFactory;

public class LaunchAction implements ILaunch {
    @Override
    public void launchBrowser() {
        DriverFactory.getInstance().getDriver().get(ConfigReader.get("app.url"));
    }
}
