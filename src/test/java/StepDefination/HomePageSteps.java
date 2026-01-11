package StepDefination;

import IPages.Actions.HomePageActions;
import IPages.GlobalActions;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Objects;

public class HomePageSteps {
    public static GlobalActions globalActions = new GlobalActions();

    static {
        if (Objects.isNull(globalActions.getHomePage())) {
            globalActions.setHomePage(new HomePageActions());
        }
    }

    @When("User add the {string} to the cart")
    public void userAddTheToTheCart(String item) {
       globalActions.addItemToCart(item);
    }

    @Then("User should see the Remove option for the item added to cart {string}")
    public void userShouldSeeTheRemoveOptionForTheItemAddedToCart(String itemName) {
      globalActions.verifyRemoveOptionOnItem(itemName);
    }

    @And("User verifies number of items added to cart")
    public void userVerifiesNumberOfItemsAddedToCart() {
       globalActions.verifyItemsOnCartIcon();
    }


}
