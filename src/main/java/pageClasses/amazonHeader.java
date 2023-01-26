package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.pageUtility;
import utilities.waitUtility;

public class amazonHeader {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	WebElement logo;
	@FindBy(xpath = "//input[@id = 'twotabsearchtextbox']")
	WebElement searchInput;
	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement user;
	@FindBy(xpath = "//a[@id='nav-orders']")
	WebElement returnOrders;
    @FindBy(xpath="//a[@id='nav-cart']")
    WebElement cartButton;
    @FindBy(xpath="//a[@id='icp-nav-flyout']")
    WebElement languageButton;
    
  	@FindBy(xpath = "//a[@id='nav-link-accountList']")
  	WebElement helloSigninLabel;
  	
  	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
  	WebElement helloUser;
  	
  	@FindBy(xpath="//span[@class='nav-action-inner' and text() = 'Sign in']")
  	WebElement singIn;
  	
  	@FindBy(xpath = "//span[text()='Sign Out']")
  	WebElement signOut;
  	
  	@FindBy(xpath="//span[@id='nav-cart-count']")
  	WebElement cartCount;
    
	public amazonHeader(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement logoButton() {
		return logo;
	}
	
	public WebElement searchInputField() {
		return searchInput;
	}
	public void enterTextSearchInputField(String searchword) {
		waitUtility.waitForElementToBeClickable(driver, searchInput);
		pageUtility.enterText(searchInput, searchword);
		pageUtility.EnterKeyRelease(driver, searchInput);
	}
	public WebElement userName() {
		return user;
	}
	public WebElement returnOrdersButton() {
		return returnOrders;
	}
	public WebElement cart() {
		return cartButton;
	}
	
	public void goToCart() {
		pageUtility.clickOnElement(cartButton);
	}
	public WebElement Language() {
		return languageButton;
	}
	public WebElement helloSigninButton() {
		return helloSigninLabel;
	}
	public void moveToUserLabel() {
		pageUtility.moveToWebElement(helloSigninLabel, driver);
	}
	
	public void clickOnHelloSigninButton() {
		pageUtility.clickOnElement(helloSigninLabel);
	}
	public WebElement helloUserLabel() {
		return helloUser;
	}
	public WebElement signInButton() {
		return singIn;
	}
	public WebElement signoutButton() {
		return signOut;
	}
	public WebElement cartCountNumber() {
		return cartCount;
	}
	public void moveToLanguageButton() {
		pageUtility.moveToWebElement(languageButton, driver);
	}
	
}
