package pageClasses;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.pageUtility;

public class amazoLanguageSetting {
  WebDriver driver;
 
    @FindBy(xpath = "//input[@name='lop']")
    List<WebElement> radioBtnList;
    
    @FindBy(xpath= "//span[@class='a-label a-radio-label']")
    List<WebElement> languageLabelList;
    
    @FindBy(xpath = "//input[@class='a-button-input']")
    WebElement saveBtn;

	public amazoLanguageSetting(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
    
	public List< WebElement> getRadioBtnList() {
		return radioBtnList;
	}
	public List<WebElement> getLanguageLableList() {
		return languageLabelList;
	}
    public WebElement selectedRadioBtn() {
    	
    	Iterator<WebElement>  it =  radioBtnList.iterator();
    	 WebElement selected = it.next();
    	while(it.hasNext()){
    		boolean isSelected =  selected.isSelected();
    		if(isSelected) {
    			return selected;
    		}
    		 
    	}
    	return null;
    }
    public void selectLanguage(String lang) {
    	
		Iterator<WebElement> it = radioBtnList.iterator();
		WebElement  select =  it.next();
	     while(it.hasNext()) {
			String  val = select.getAttribute("value");
			
			if (val.equals(lang)) {
				
				pageUtility.moveToWebElement(select, driver);
				
				break;
			}
			select = it.next();
		}
	}
    
    public void clickonSaveLanguage() {
		 pageUtility.clickOnElement(saveBtn);
		 
	}
    
    
}
