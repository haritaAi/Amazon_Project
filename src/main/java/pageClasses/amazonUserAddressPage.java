package pageClasses;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.pageUtility;

public class amazonUserAddressPage {
  WebDriver driver;
  
  @FindBy(xpath="//a[@id='ya-myab-address-add-link']//parent::div")
  WebElement addAddressButton;
  @FindBy(xpath="//a[starts-with(@id,'ya-myab-address-edit-btn')]")
  List<WebElement> editableAdrsList;
  @FindBy(xpath ="//a[starts-with(@id,'ya-myab-address-delete-btn')]")
  List<WebElement> removeAdrsList;
  @FindBy(xpath = "//a[starts-with(@id,'ya-myab-set-default-shipping-btn')]")
  List<WebElement> setDefaultList;
  
  @FindBy(xpath = "//span[text()='boAt']//ancestor::a")
  WebElement brand1btn;
  
  @FindBy(xpath = "//div[@class='a-box a-spacing-none normal-desktop-address-tile']")
  List<WebElement> addressList;
  
  @FindBy(xpath = "//a[@id='ya-myab-address-delete-btn-1']")
  WebElement removeBtn;
  
  @FindBy(xpath = "//a[@id='ya-myab-address-edit-btn-1']")
  WebElement editBtn;
  
  @FindBy(xpath = "(//span[@class='a-button-inner']//child::input)[3]")
  WebElement yesConfirmDeleteBtn;
  
  @FindBy(xpath = "//div[@class='a-popover-wrapper']//input[@class='a-button-input']")
  WebElement containerModalYesBtn;
  
  @FindBy(xpath="//span[@id='deleteAddressModal-1-submit-btn']")
  WebElement spanContainer;
  
public amazonUserAddressPage(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver,this);
}

  
public void addNewAddress() {
	pageUtility.clickOnElement(addAddressButton);
}

public List<WebElement>  getEditableAdrs() {
	return editableAdrsList;
	
}
public List<WebElement> getRemoveAdrsList() {
	 return removeAdrsList;
}
public List<WebElement> getSetDefaultList() {
	return setDefaultList;
}

public void clickonEditAddress(WebElement editAdrs) {
	pageUtility.clickOnElement(editAdrs);
}
  
public void clickonRemoveAddress(WebElement removeAdrs) {
	pageUtility.clickOnElement(removeAdrs);
	
}
public void clickonSetDefault(WebElement setDef) {
	pageUtility.clickOnElement(setDef);
}

public void clickEditAddress() {
	  pageUtility.clickOnElement(editBtn);
}
public void clickRemoveAddress() {
	pageUtility.clickOnElement(removeBtn);
}
public void confirmDeleteBtn() {

	pageUtility.clickOnElement(spanContainer);
	pageUtility.EnterKeyPress(driver, spanContainer);
	pageUtility.EnterKeyRelease(driver, spanContainer);
}



}
