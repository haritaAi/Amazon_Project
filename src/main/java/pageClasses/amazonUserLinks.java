package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.pageUtility;

public class amazonUserLinks {
	WebDriver driver;
	
	@FindBy(xpath= "//a[@class='nav-link nav-item']//child::span[text()='Your Account']")
	WebElement userAccount;
	@FindBy(xpath = "//a[@class='nav-link nav-item']//child::span[text()='Your Orders']")
	WebElement userOrders;
	@FindBy(xpath = "//a[@class='nav-link nav-item']//child::span[text()='Your Wish List']")
	WebElement userWishList;
	@FindBy(xpath = "//a[@class='nav-link nav-item']//child::span[text()='Your Recommendations']")
	WebElement userRecomndtn;
	
	//constructor
	
	public amazonUserLinks(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void  gotoUserAccount() {		
		  pageUtility.clickUsingJavaScriptExecutor(driver, userAccount);          		
	}
	public void gotoUserOrders() {
		pageUtility.clickUsingJavaScriptExecutor(driver, userOrders);
	}
    public void gotoUserWishlist() {
    	pageUtility.clickUsingJavaScriptExecutor(driver, userWishList);		
	}
    public void gotoUserRecmdtn() {
		pageUtility.clickUsingJavaScriptExecutor(driver, userRecomndtn);
	}
}
