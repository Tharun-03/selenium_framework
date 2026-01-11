package StepDefination;

import IPages.Actions.LoginActions;
import IPages.GlobalActions;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Objects;

public class LoginSteps {
    public static GlobalActions globalActions = new GlobalActions();

    static {
        if (Objects.isNull(globalActions.getiLoginPage())) {
            globalActions.setiLoginPage(new LoginActions());
        }
    }

    @When("User submits the valid credentials")
        public void userSubmitsValidCredentials(){
          globalActions.loginWithValidCredentials();
        }

    @Then("User navigates to the home page")
    public void userNavigatesToTheHomePage() {
       globalActions.verifyAppLogo();
    }


}
