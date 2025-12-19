package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.CheckoutPage;
import pages.CompletePage;
import pages.CheckoutOverviewPage;
import base.BaseTest;

public class CompleteCheckoutTest extends BaseTest {

    @Test
    void testCompleteCheckout() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSauceDemo();
        loginPage.login("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        assertTrue(productPage.isOnProductPage(), "Login failed: Not on product page"); 
        productPage.addProductToCart();
        productPage.openCart();

        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.isProductDisplayed(), "Product not found");
        cartPage.checkoutButtonClick();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutInformation("Arnii", "Febryartii", "12345");  
        checkoutPage.clickContinueButton();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickFinishButton();

        CompletePage completePage = new CompletePage(driver);
        // String finishMessage = completePage.getFinishMessage();
        // assertTrue(finishMessage.contains("THANK YOU FOR YOUR ORDER"), "Checkout failed: Confirmation message not found");
        completePage.backHomeButton();

        Thread.sleep(10000); 

    }
    
}
