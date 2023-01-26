package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.pageUtility;
import utilities.waitUtility;

public class amazonAddressFormPage {
 WebDriver driver;
   
  @FindBy(xpath = "//select[@id='address-ui-widgets-countryCode-dropdown-nativeId']")
  WebElement  country;
  @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
  WebElement fullName;
  @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
  WebElement mobileNumber;
  @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']")
  WebElement zipcode;
  @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine1']")
  WebElement addressLine1;
  @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine2']")
  WebElement addressLine2;
  @FindBy(xpath="//input[@id='address-ui-widgets-landmark']")
  WebElement landmark;
  @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressCity']")
  WebElement city;
  @FindBy(xpath="//select[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId']")
  WebElement state;
  @FindBy(xpath = "//input[@id='address-ui-widgets-use-as-my-default']")
  WebElement defaultAddress;
  @FindBy(xpath = "//select[@name='address-ui-widgets-addr-details-address-type-and-business-hours']")
  WebElement addressType;
  @FindBy(xpath = "//span[@id='address-ui-widgets-form-submit-button']//child::input")
  WebElement addAddressBtn;
  @FindBy(xpath = "//h4[text()='Address saved']")
  WebElement saveConfirmation;
  
  public amazonAddressFormPage(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver,this);
}

  public void addCountry(String val) {
	 
	  pageUtility.selectDropdownbyText(country, val);
}
  public void addFullName(String Val) {
	  pageUtility.clearText(fullName);
	pageUtility.enterText(fullName, Val);
}
  public void addMobileNumber(String mobileNum) {
	  pageUtility.clearText(mobileNumber);
	pageUtility.enterText(mobileNumber, mobileNum);
}
  
  public void addZipcode(String val) {
	  pageUtility.clearText(zipcode);
	pageUtility.enterText(zipcode, val);
}
  public void addAddressLine1(String val) {
	  pageUtility.clearText(addressLine1);
	pageUtility.enterText(addressLine1, val);
	
}
  public void addAddressLine2(String val) {
	  pageUtility.clearText(addressLine2);
		pageUtility.enterText(addressLine2, val);
		
	}
  public void addLandmark(String val) {
	  pageUtility.clearText(landmark);
		pageUtility.enterText(landmark, val);
		
	}
  public void addCity(String val) {
	  pageUtility.clearText(city);
		pageUtility.enterText(city, val);
		
	}
  
  public void addState(String val) {
	 
		pageUtility.enterText(state, val);
		
	}
  
  public void makeDefaultAddress() {
	  
	  pageUtility.clickOnElement(defaultAddress);
  }
  
  public void addAddressType(String val) {
	  waitUtility.waitForElementToBeClickable(driver, addressType);
	 pageUtility.selectDropdownbyText(addressType, val);
}
 public void clickonAddAddressBtn()  {	
	
	 pageUtility.clickOnElement(addAddressBtn);
	 System.out.println("Address btn clikced");
 }
 public WebElement saveConfirmBtn() {
	return saveConfirmation;
} 
 public boolean isAddressSaved() {
	 
	 return pageUtility.isElementDisplayed(saveConfirmation);
 }
  
}
