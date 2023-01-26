package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.pageUtility;

public class amazonLoginPage {
	WebDriver driver;
	@FindBy(id = "ap_email")
	WebElement signinEmail;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(id="ap_password")
	WebElement signinPassword;
	
	@FindBy(id="signInSubmit")
	WebElement singinSubmit;
	
	public amazonLoginPage(WebDriver driver) {
		//super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public  WebElement signInEmailInput() {
		return signinEmail;
	}
	public void enterTextSigninEmailInput(String email) {
		pageUtility.enterText(signinEmail, email );
	}
	public WebElement continueButtonElement() {
		return continueButton;
	}
	
	public  WebElement signInPasswordInput() {
		return signinPassword;
	}
	public void enterTextSigninPasswordInput(String password) {
		pageUtility.enterText(signinPassword, password);
	}
	public  WebElement signInSubmit() {
		return singinSubmit;
	}
	
}
