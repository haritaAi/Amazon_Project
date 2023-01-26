package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.pageUtility;
import utilities.waitUtility;

public class amazonProductDetailPage {
 WebDriver driver;
 
 @FindBy(xpath = "//input[@id='add-to-cart-button']")
 WebElement addToCart;
 @FindBy(xpath="//input[@name='proceedToRetailCheckout']")
 WebElement checkout;
 @FindBy(xpath="//span[@id='attach-sidesheet-view-cart-button']//parent::form")
 WebElement modalCart;
@FindBy(xpath="//a[@id='attach-close_sideSheet-link']")
WebElement closeBtn;

public amazonProductDetailPage(WebDriver driver) {
	//super();
	this.driver = driver;
    PageFactory.initElements(driver,this);
    
}

public WebElement addToCartButton() {
	return addToCart;
}
public void clickonModalCart() {
	waitUtility.waitForElementToBeClickable(driver, modalCart);
	pageUtility.clickUsingJavaScriptExecutor(driver, modalCart);
}
public void proceedCheckout() {
	pageUtility.clickUsingJavaScriptExecutor(driver, checkout);
	
}
public void closeModal() {
	//waitUtility.waitForElementToBeClickable(driver, closeBtn);
	pageUtility.clickUsingJavaScriptExecutor(driver, closeBtn);
}
 
}
