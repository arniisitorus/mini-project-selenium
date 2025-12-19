package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.CheckoutPage;
import base.BaseTest;

public class CheckoutTest extends BaseTest {

    @Test
    void testCheckout() throws InterruptedException {

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

        Thread.sleep(10000); 

    }
    
}
