package IPages;

public class GlobalActions implements ILaunch, ILoginPage, HomePage, IaddToCartPage{
    private ILoginPage iLoginPage;
    private ILaunch ilaunch;
    private HomePage homePage;


    private IaddToCartPage iaddToCartPage;



    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public ILaunch getiLaunch(){
        return ilaunch;
    }

    public void setLaunch(ILaunch launch){
       this.ilaunch = launch;
    }

    public ILoginPage getiLoginPage() {
        return iLoginPage;
    }

    public void setiLoginPage(ILoginPage iLoginPage) {
        this.iLoginPage = iLoginPage;
    }

    public IaddToCartPage getIaddToCartPage() {
        return iaddToCartPage;
    }

    public void setIaddToCartPage(IaddToCartPage iaddToCartPage) {
        this.iaddToCartPage = iaddToCartPage;
    }


    @Override
    public void launchBrowser() {
        this.ilaunch.launchBrowser();
    }

    @Override
    public void loginWithValidCredentials() {
       this.iLoginPage.loginWithValidCredentials();
    }

    @Override
    public void verifyAppLogo() {
        this.iLoginPage.verifyAppLogo();
    }


    @Override
    public void addItemToCart(String itemName) {
       this.homePage.addItemToCart(itemName);
    }

    @Override
    public void verifyItemsOnCartIcon() {
        this.homePage.verifyItemsOnCartIcon();
    }

    @Override
    public void verifyRemoveOptionOnItem(String itemName) {
        this.homePage.verifyRemoveOptionOnItem(itemName);
    }


    @Override
    public void clickOnAddToCartIcon() {
        this.iaddToCartPage.clickOnAddToCartIcon();
    }

    @Override
    public void verifyUILayoutOfAddToCartPage() {
        this.iaddToCartPage.verifyUILayoutOfAddToCartPage();
    }
}
