package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.pageUtility;

public class amazonCartPage {
  WebDriver driver;
  
  @FindBy(xpath="//div[@class='a-row sc-list-item sc-java-remote-feature']") 
  List<WebElement> cartItems;
  
  @FindBy(xpath = "//input[@value='Delete']")
  List<WebElement> delete;
  
  @FindBy(xpath = "//select[@name='quantity']")
  WebElement quantity;
  
  @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
  WebElement quantityBtn;
  
  @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
  WebElement quantityVal;
  
  @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
  WebElement checkoutBtn;

public amazonCartPage(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver,this);
}

public List<WebElement> cartProducts(){
	return cartItems;
}
public List<WebElement> cartItemDeleteButton(){
	return delete;
}
public WebElement quantityButton() {
	return quantityBtn;
}
public String readQuantity() {
	return pageUtility.getElementText(quantityVal);
}
public void clickQuantity() {
	pageUtility.clickOnElement(quantityBtn);
}
public void selectQuantity(String value) {
	pageUtility.selectDropdownbyValue(quantity, value);
}
public void clickonDelete(WebElement target) {
	pageUtility.clickOnElement(target);
}
public WebElement checkoutButton() {
	return checkoutBtn;
}
public void clickonCheckoutBtn() {
	pageUtility.clickOnElement(checkoutBtn);
	
}


}
