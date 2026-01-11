package IPages.Actions;

import IPages.IaddToCartPage;
import Utilities.UiActions;
import org.testng.Assert;

public class addToCartActions implements IaddToCartPage {
    @Override
    public void clickOnAddToCartIcon() {
        UiActions.getElement("HomePage", "shoppingCartLink").click();
    }

    @Override
    public void verifyUILayoutOfAddToCartPage() {
        Assert.assertEquals("Your Cart", UiActions.getElement("AddCartPage","titleOfThePage").getText(), "The title is not Your cart");
        Assert.assertEquals("Continue Shopping", UiActions.getElement("AddCartPage","continueShopping").getText(), "Continue Shopping is not displayed");
        Assert.assertEquals("Go back", UiActions.getElement("AddCartPage", "goBackButton").getAttribute("alt"),"Go back button is not displayed");
        Assert.assertEquals("Checkout", UiActions.getElement("AddCartPage", "checkout").getText(), "Checkout option is not displayed");
    }
}
