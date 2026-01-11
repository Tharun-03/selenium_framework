package StepDefination;

import IPages.Actions.LaunchAction;
import IPages.Actions.LoginActions;
import IPages.GlobalActions;
import io.cucumber.java.en.Given;

import java.util.Objects;

public class LaunchSteps {
    public static GlobalActions globalActions = new GlobalActions();

    static {
        if (Objects.isNull(globalActions.getiLaunch())) {
            globalActions.setLaunch(new LaunchAction());
        }
    }
    @Given("User launches the Sauce application")
    public void launchApplication(){
        globalActions.launchBrowser();
    }
}
