package tests;

import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AddToCartTest extends BaseTest {
    @Test
    void testAddToCart() throws InterruptedException {

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

        Thread.sleep(10000);  
    }
    
}
