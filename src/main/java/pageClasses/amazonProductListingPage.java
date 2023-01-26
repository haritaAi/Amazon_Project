package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.pageUtility;

public class amazonProductListingPage {
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")	
	List<WebElement> productList;
	
	@FindBy(xpath="//div[@class='a-section aok-relative s-image-fixed-height']")
	List<WebElement> productImageList;
	
	@FindBy(xpath="//select[@id='s-result-sort-select']")
	WebElement sortSelect;
	
	public amazonProductListingPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
    	
	public  List<WebElement>  searchResultTitles() {
		return productList;
	}
	public List<WebElement> searchResultImages(){
		return productImageList;
	}
	public int searchResultSize() {
		return productList.size();
	}
    public void selectSortingFilter(String val) {
    	
    	pageUtility.selectDropdownbyText(sortSelect, val);
    	
    }
}
