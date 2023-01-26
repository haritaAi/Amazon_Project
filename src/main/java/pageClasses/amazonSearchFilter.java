package pageClasses;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import utilities.pageUtility;
import utilities.waitUtility;

public class amazonSearchFilter {
 WebDriver driver;
  @FindBy(xpath = "//a[@class='a-link-normal s-navigation-item']//child::span[text()='Activity Trackers']")
  WebElement categoryLink;
  
  @FindBy(xpath = "//div[@id='reviewsRefinements']//child::a")
  WebElement reviewFilter;
  
  @FindBy(xpath = "//span[text()='Wings']//ancestor::a")
  WebElement brandFilter;
  
  @FindBy(xpath = "//span[text()='₹1,000 - ₹5,000']//ancestor::a")
  WebElement priceFilter;
  
  @FindBy(xpath = "//input[@id='low-price']")
  WebElement lowPrice;
  
  @FindBy(xpath = "//input[@id='high-price']")
  WebElement highPrice;
  
  @FindBy(xpath = "//span[@id='a-autoid-1']//child::input")
  WebElement goBtn;
  
  @FindBy(xpath = "//a[@class='a-link-normal s-navigation-item']//child::div[@class='colorsprite aok-float-left']")
  List<WebElement> colorBtnList;
  
  @FindBy(xpath="//span[text()='Clear']")
  WebElement reviewFilterClearBtn;

  @FindBy(xpath = "//span[text()='Any Price']")
  WebElement priceFilterAnyPriceBtn;
  
  
  
public amazonSearchFilter(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver,this);
}

public void clickonCategory() {
	pageUtility.clickOnElement(categoryLink);
}
  
public void clickOnReviewFilter() {
	pageUtility.clickOnElement(reviewFilter);
}  

public void clickonBrandFilter() {
	pageUtility.clickOnElement(brandFilter);
}
  
public void clickonPriceFilter() {
	pageUtility.clickOnElement(priceFilter);
}
public void enterLowPrice() throws InterruptedException {
	pageUtility.scrollToFindElement(driver, lowPrice);
	pageUtility.enterText(lowPrice, "500");
	waitUtility.HardWait();
}
public void enterHighPrice() throws InterruptedException {
	pageUtility.scrollToFindElement(driver, highPrice);
	pageUtility.enterText(highPrice, "4000");
	waitUtility.HardWait();
	pageUtility.EnterKeyPress(driver, highPrice);
	
}
public void clickonGoBtn() {
	pageUtility.clickOnElement(goBtn);
}
 
public void clickonColourButton() {
    Iterator<WebElement> it = colorBtnList.iterator();
    WebElement selectColor = it.next();
    selectColor = it.next();
    pageUtility.clickOnElement(selectColor);
}
public boolean isReviewClearBtn() {
   return 	pageUtility.isElementEnabled(reviewFilterClearBtn);
}
public boolean  ispriceFilterAnyPriceBtn() {
	return pageUtility.isElementEnabled(priceFilterAnyPriceBtn);
}



}
