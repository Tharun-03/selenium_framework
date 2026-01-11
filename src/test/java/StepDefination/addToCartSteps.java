package StepDefination;

import IPages.Actions.HomePageActions;
import IPages.Actions.addToCartActions;
import IPages.GlobalActions;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Objects;

public class addToCartSteps {
    public static GlobalActions globalActions = new GlobalActions();

    static {
        if (Objects.isNull(globalActions.getIaddToCartPage())) {
            globalActions.setIaddToCartPage(new addToCartActions());
        }
    }

    @When("User clicks on the add to cart icon")
    public void userClicksOnTheAddToCartIcon() {
        globalActions.clickOnAddToCartIcon();

    }

    @Then("User verifies the UI layout of the add to cart page")
    public void userVerifiesTheUILayoutOfTheAddToCartPage() {
        globalActions.verifyUILayoutOfAddToCartPage();
    }
}
