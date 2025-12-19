package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {

    private WebDriver driver;

    // private By finishMessage = By.className("complete-header"); 
    private By backHomeButton = By.id("back-to-products"); 

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    // public String getFinishMessage() {
    //     return driver.findElement(finishMessage).getText();
    // }

    public void backHomeButton() {
        driver.findElement(backHomeButton).click();
    }

}   