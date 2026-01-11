package IPages.Actions;

import IPages.HomePage;
import Utilities.BaseTest;
import Utilities.UiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomePageActions implements HomePage {

BaseTest baseTest = new BaseTest();
    @Override
    public void addItemToCart(String itemName) {
        List<WebElement> itemNames = UiActions.getElements("HomePage", "inventoryName");
        List<WebElement> clickAddCart = UiActions.getElements("HomePage", "addToCartButton");

        for(int i =0; i<itemNames.size(); i++){
            if(itemNames.get(i).getText().equalsIgnoreCase(itemName)){
                clickAddCart.get(i).click();
            }

        }

    }
    @Override
    public void verifyRemoveOptionOnItem(String itemName) {
        List<WebElement> itemNames = UiActions.getElements("HomePage", "inventoryName");
        List<WebElement> clickAddCart = UiActions.getElements("HomePage", "addToCartButton");

        for(int i =0; i<itemNames.size(); i++){
            if(itemNames.get(i).getText().equalsIgnoreCase(itemName)){
                Assert.assertEquals(clickAddCart.get(i).getText(), "Remove", "Remove is not displayed after adding to the cart");
           }
       }
    }


    @Override
    public void verifyItemsOnCartIcon() {
     WebElement element = UiActions.getElement("HomePage", "shoppingCartBadge");
      baseTest.waitForElementToBeVisible(element);
      Assert.assertEquals("1", element.getText().trim(), "items added are one");
    }




}
