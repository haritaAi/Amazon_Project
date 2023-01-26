package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.pageUtility;

public class amzonUserAccount {
WebDriver driver;
  
@FindBy(xpath = "//a[@class='ya-card__whole-card-link']//child::span[text()='Edit addresses for orders and gifts']")
WebElement addressBook;

public amzonUserAccount(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver,this);
}

public void clickOnYourAddress() {
	pageUtility.clickOnElement(addressBook);
}




}
