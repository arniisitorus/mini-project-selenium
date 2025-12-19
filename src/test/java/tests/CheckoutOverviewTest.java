package tests;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CheckoutOverviewTest extends BaseTest{

    @Test   
    void testCheckoutOverview() throws InterruptedException {

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
        
        Thread.sleep(10000);
    
    } 
    
}
