package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonHomePage {
	
	WebDriver driver;
  
	
	public amazonHomePage(WebDriver driver) {
		//super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public String  getHomepageTitle() {
		return driver.getTitle();
	}

}
