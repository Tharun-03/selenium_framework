package IPages.Actions;

import IPages.ILoginPage;
import Utilities.ConfigReader;
import Utilities.UiActions;
import org.testng.Assert;

public class LoginActions implements ILoginPage {

    @Override
    public void loginWithValidCredentials() {
        UiActions.getElement("LoginPage", "userName").sendKeys(ConfigReader.get("Username"));
        UiActions.getElement("LoginPage", "password").sendKeys(ConfigReader.get("Password"));
        UiActions.getElement("LoginPage","submitButton").click();
    }

    @Override
    public void verifyAppLogo() {
        Assert.assertEquals("Swag Labs", UiActions.getElement("HomePage","appLogo").getText(), "Swag Labs app logo is not present");

    }
}
