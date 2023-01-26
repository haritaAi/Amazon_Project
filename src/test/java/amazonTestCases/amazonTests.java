package amazonTestCases;






import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationCore.baseClass;
import pageClasses.amazoLanguageSetting;
import pageClasses.amazonAddressFormPage;
import pageClasses.amazonCartPage;
import pageClasses.amazonHeader;
import pageClasses.amazonHomePage;
import pageClasses.amazonLoginPage;
import pageClasses.amazonProductDetailPage;
import pageClasses.amazonProductListingPage;
import pageClasses.amazonSearchFilter;
import pageClasses.amazonUserAddressPage;
import pageClasses.amazonUserLinks;
import pageClasses.amzonUserAccount;
import utilities.pageUtility;
import utilities.waitUtility;


public class amazonTests extends baseClass{
	
	WebDriver driver;
    amazonHomePage  objAmazonHomePage;
    amazonLoginPage objAmazonLoginPage;
    amazonHeader objAmazonHeader;
    amazonProductListingPage objAmazonProductListingPage;
	amazonProductDetailPage objProductDetailPage;
	amazonCartPage objAmazonCartPage;
    amazonUserLinks objUserLinks;
    amzonUserAccount objUserAccount;
    amazonUserAddressPage objUserAddressPage;
    amazoLanguageSetting objLanguage;
    amazonSearchFilter objFilter;
    amazonAddressFormPage  objAddressForm;
    
	 @BeforeMethod
     @Parameters({"browser"})
     public void initializeBrowser(String browser) throws IOException {
		 
		 
  	   driver = browserInitialization(browser);  	 
  	   driver.get(prop.getProperty("url"));
  	   driver.manage().window().maximize();
  	   objAmazonHomePage = new amazonHomePage(driver);
  	   objAmazonLoginPage = new amazonLoginPage(driver);
  	   objAmazonHeader = new amazonHeader(driver);
  	   objAmazonProductListingPage = new amazonProductListingPage(driver);
  	   objProductDetailPage = new amazonProductDetailPage(driver);   
  	   objAmazonCartPage = new amazonCartPage(driver);
  	   objUserLinks  = new amazonUserLinks(driver);
  	   objUserAccount = new amzonUserAccount(driver);
  	   objUserAddressPage = new amazonUserAddressPage(driver);
  	   objLanguage = new amazoLanguageSetting(driver);
  	   objFilter = new amazonSearchFilter(driver);
  	   objAddressForm = new amazonAddressFormPage(driver);
  	   
  	   
     }
	//Verify  the Title of the page
	 @Test
	 public void tc01() throws InterruptedException {		 
		 String expectedTitle = prop.getProperty("homepageTitle");		
		 String actualPageTitle = pageUtility.getPageTitle(driver);
		 
		 Assert.assertEquals(actualPageTitle, expectedTitle);
		 System.out.println("AMZN_TC01 : PASSED " );
	 }
	 //Verify the logo is a hot link
	 @Test
	 public void tc02() throws InterruptedException {
		waitUtility.waitForanElementVisible(driver, objAmazonHeader.logoButton());
		pageUtility.clickOnElement(objAmazonHeader.cart());
	    String expectedCartPageTitle = prop.getProperty("cartTitle");
	    String actualCartPageTitle = pageUtility.getPageTitle(driver);
	    
		Assert.assertEquals(actualCartPageTitle,expectedCartPageTitle);
		System.out.println("On Cart page");
		
    	pageUtility.clickOnElement(objAmazonHeader.logoButton());
    	String expectedHomePageTitle = prop.getProperty("homepageTitle");
    	String actualPageTitle = pageUtility.getPageTitle(driver);
    	
    	Assert.assertEquals(actualPageTitle, expectedHomePageTitle);
    	System.out.println("AMZN_TC02 : PASSED");
	}
	 //Verify that a user can search  using search component and the products are listed
	 @Test
     public void tc03() throws InterruptedException {
    	 waitUtility.waitForanElementVisible(driver, objAmazonHeader.searchInputField());
    	// pageUtility.clearText(objAmazonHeader.searchInputField());
    	 waitUtility.HardWait();
    	 String searchWord = prop.getProperty("searchWord");
    	 pageUtility.enterText(objAmazonHeader.searchInputField(),searchWord );
    	 pageUtility.EnterKeyPress(driver,objAmazonHeader.searchInputField());
    	 waitUtility.HardWait();
    	 int searchSize = objAmazonProductListingPage.searchResultSize();
    	 System.out.println("Number of products : "+ searchSize);
         Assert.assertTrue(searchSize >0);
         System.out.println("AMZN_TC03 : PASSED");
    	 
    	 
     }
	 //Verify a registered user can  login  on the website 

	 @Test  
	  public void tc04() throws InterruptedException
	 {  
		 amazonLogin();
		 System.out.println("AMZN_TC04 : PASSED");
		 
	 }
	 //Verify that the user' s name is displayed on the page after login
	 @Test
	 public void tc05() throws InterruptedException {
		 amazonLogin();
		 waitUtility.waitForanElementVisible(driver, objAmazonHeader.helloUserLabel());
			
		 String expectedUserName = "Hello, "+prop.getProperty("user");
		 String actualUserName = objAmazonHeader.helloUserLabel().getText();
		 Assert.assertEquals(actualUserName,expectedUserName);
		 System.out.println("AMZN_TC05 : PASSED");
		 
	 }
	//Verify that the cart  functionality is accessible from the Home page
     @Test
	 public void tc06() throws InterruptedException {
    	 
		pageUtility.clickOnElement(objAmazonHeader.cart());
		String pageTitle = pageUtility.getPageTitle(driver);
		String expectedPageTitle = prop.getProperty("cartTitle");
		Assert.assertEquals(pageTitle, expectedPageTitle);
		System.out.println("AMZN_TC06 : PASSED");
	}
     //Verify that user is able to add a product to cart without logging in the website 
     @Test
     public void tc07() throws InterruptedException {
    	
    	 String initialCount = pageUtility.getElementText(objAmazonHeader.cartCountNumber());
         int initialCartCount = Integer.parseInt(initialCount);  
    	 String buttonText =  pageUtility.getElementText(objAmazonHeader.helloUserLabel());
    	 System.out.println("buttonText : "+ buttonText);
    	 if(!buttonText.equals("Hello, sign in")) {
    		 pageUtility.moveToWebElement(objAmazonHeader.helloSigninButton(), driver);
    		 pageUtility.clickOnElement(objAmazonHeader.signoutButton());
    	 }
    
    	 System.out.println("Login status : " + objAmazonHeader.signInButton().isEnabled());
    	
    	 waitUtility.waitForanElementVisible(driver, objAmazonHeader.searchInputField());     	
     	 waitUtility.HardWait();
     	 String searchWord = prop.getProperty("searchWord");
     	 pageUtility.enterText(objAmazonHeader.searchInputField(),searchWord );
     	 pageUtility.EnterKeyPress(driver,objAmazonHeader.searchInputField());
     	 waitUtility.HardWait();
     	 int searchSize = objAmazonProductListingPage.searchResultSize();
     	
         if(searchSize > 0) {
        	List<WebElement> products =  objAmazonProductListingPage.searchResultTitles();
            Iterator<WebElement> prdct =  products.iterator();
            WebElement product1 = prdct.next();
            pageUtility.clickOnElement(product1);
            
            Set<String> tabs =  driver.getWindowHandles();
            Iterator<String> it = tabs.iterator();
            String parent = it.next();
            String tab1 = it.next();
            driver.switchTo().window(tab1);
            
           
            waitUtility.waitForElementToBeClickable(driver,objProductDetailPage.addToCartButton());
            pageUtility.clickOnElement(objProductDetailPage.addToCartButton());
            waitUtility.HardWait();
            String cartCount = pageUtility.getElementText(objAmazonHeader.cartCountNumber());
            System.out.println("CArt Count :"+ cartCount);
            int actualCartCount = Integer.parseInt(cartCount);  
            if(actualCartCount == initialCartCount +1 ) {
            	System.out.println("AMZN_TC07 : PASSED");
            }
         }
    	
    	 
     }
     //Verify that the user can  place order only after logging / sign in/ registration
    @Test
     public void tc08() throws InterruptedException {
		//verify that user has not logged in
    	//add to cart
    	//check out
    	addToCartAnItem();
    	objProductDetailPage.proceedCheckout();
    	String pageTitle = pageUtility.getPageTitle(driver);
    	Assert.assertEquals(pageTitle, "Amazon Sign In");
    	System.out.println("AMZN_TC08 :  PASSED");
    	
	}
    //Verify that the user  can add an address to  addressbook in user profile
    @Test (dataProvider = "getAddressData")
    public void tc09(String country, String fullName, String mobileNum, String zipcode, String addressLine1, String addressLine2, String landmark, String city, String state,String addressType ) throws InterruptedException {
		amazonLogin();
		objAmazonHeader.moveToUserLabel();
		objUserLinks.gotoUserAccount();
		objUserAccount.clickOnYourAddress();
		objUserAddressPage.addNewAddress();
		objAddressForm.addCountry(country);
		objAddressForm.addFullName(fullName);
		objAddressForm.addMobileNumber(mobileNum);
		objAddressForm.addZipcode(zipcode);
		objAddressForm.addAddressLine1(addressLine1);
		objAddressForm.addAddressLine2(addressLine2);
		objAddressForm.addLandmark(landmark);
		objAddressForm.addCity(city);
		objAddressForm.addState(state);
		objAddressForm.addAddressType(addressType);
		objAddressForm.clickonAddAddressBtn();
		waitUtility.waitForanElementVisible(driver, objAddressForm.saveConfirmBtn());
		boolean actualsaved = objAddressForm.isAddressSaved();
		Assert.assertEquals(actualsaved, true);
		System.out.println("AMZN_TC09 : PASSED");
		
	}
    //verify the user can edit the address from the addressbook
    @Test (dataProvider =  "getEditAddressData")
    public void tc10(String country, String fullName, String mobileNum, String zipcode, String addressLine1, String addressLine2, String landmark, String city, String state,String addressType) throws InterruptedException {
    	amazonLogin();
    	objAmazonHeader.moveToUserLabel();
		objUserLinks.gotoUserAccount();
		objUserAccount.clickOnYourAddress();
		objUserAddressPage.clickEditAddress();
		objAddressForm.addCountry(country);
		objAddressForm.addFullName(fullName);
		objAddressForm.addMobileNumber(mobileNum);
		objAddressForm.addZipcode(zipcode);
		objAddressForm.addAddressLine1(addressLine1);
		objAddressForm.addAddressLine2(addressLine2);
		objAddressForm.addLandmark(landmark);
		objAddressForm.addCity(city);
		objAddressForm.addState(state);
		objAddressForm.addAddressType(addressType);
		objAddressForm.clickonAddAddressBtn();
		waitUtility.waitForanElementVisible(driver, objAddressForm.saveConfirmBtn());
		boolean actualsaved = objAddressForm.isAddressSaved();
		Assert.assertEquals(actualsaved, true);
		System.out.println("AMZN_TC10 : PASSED");
		
		
	}
    //verify that the user can delete/ remove an address from the address book
    @Test
    public void tc11() throws InterruptedException {
    	amazonLogin();
    	objAmazonHeader.moveToUserLabel();
		objUserLinks.gotoUserAccount();
		objUserAccount.clickOnYourAddress();
		objUserAddressPage.clickRemoveAddress();
		
		objUserAddressPage.confirmDeleteBtn();
	}
    
    //Verify that the user can  update the product quantity in the cart
    @Test
    public void tc12() throws InterruptedException {
    	addToCartAnItem();
    	objAmazonHeader.goToCart();
    	objAmazonCartPage.clickQuantity();
    	objAmazonCartPage.selectQuantity("2");
    	String actualVal = objAmazonCartPage.readQuantity();
    	String expctdVal = "2";
    	Assert.assertEquals(actualVal, expctdVal);
        System.out.println("AMZN_TC12 : PASSED");     	
	} 
     
	//Verify that the user can delete the product from the cart
    @Test
    public void tc13() throws InterruptedException {
    	addToCartAnItem();
    	addToCartAnItem();
    	
    
        List<WebElement> deleteBtnList = 	objAmazonCartPage.cartItemDeleteButton();
        if(deleteBtnList.size() > 0) {
        	Iterator<WebElement> btn = deleteBtnList.iterator();
        	WebElement selectedProduct = btn.next();
        	objAmazonCartPage.clickonDelete(selectedProduct); 
        	String actualVal = objAmazonCartPage.readQuantity();
        	System.out.println("Actual Cart value : "+ actualVal);
        	Assert.assertEquals(actualVal, "");
        	System.out.println("AMZN_TC13 : PASSED");
        }
        
    }
    //Verify that the user can  place order and check out from the cart 
    @Test
    public void tc14() throws InterruptedException {
    	amazonLogin();
    	addToCartAnItem();
    	objAmazonCartPage.clickonCheckoutBtn();
	}
    
    //Verify that the user can change  the language of their preference 
   @Test
    public void tc15() {
	  objAmazonHeader.moveToLanguageButton();
	  WebElement selected =  objLanguage.selectedRadioBtn();
	  String selectedLanguage = selected.getAttribute("value");
	  System.out.println("Selected language : "+ selectedLanguage );
	  String lang = prop.getProperty("toLanguage");
	  System.out.println("Language to  be selcted :"+ lang);
      objLanguage.selectLanguage(lang);  	
      objLanguage.clickonSaveLanguage();
    }
    //verify the user can change and save the language of their preference
   @Test
   public void tc16() {
		  objAmazonHeader.moveToLanguageButton();
		  WebElement selected =  objLanguage.selectedRadioBtn();
		  String selectedLanguage = selected.getAttribute("value");
		  System.out.println("Selected language : "+ selectedLanguage );
		  String lang = prop.getProperty("fromLanguage");
		  System.out.println("Language to  be selcted :"+ lang);
	      objLanguage.selectLanguage(lang);  
	      objLanguage.clickonSaveLanguage();
	      
	    }
   
   //Verify that the user can search among product names, brand name, category, product specifications
   @Test 
   public void tc17() {
	   //brand Name
	   String brand = prop.getProperty("brandName");
		objAmazonHeader.enterTextSearchInputField(brand);
	
	}
   //verify that the user can filter the result based on category
   @Test
   public void  tc18() {
	   String brand = prop.getProperty("brandName");
		objAmazonHeader.enterTextSearchInputField(brand);
		objFilter.clickonCategory();
     }
 //verify that the user can filter the result based on review
  @Test
   public void  tc19() {
	   String brand = prop.getProperty("brandName");
		objAmazonHeader.enterTextSearchInputField(brand);
		objFilter.clickOnReviewFilter();
		boolean  isReviewClear = objFilter.isReviewClearBtn();
		Assert.assertEquals(isReviewClear, true);
		System.out.println("AMZN_TC19 : PASSED");
    }
  
//verify that the user can filter the result based on price filter
  @Test
  public void tc20() {
	  String brand = prop.getProperty("brandName");
		objAmazonHeader.enterTextSearchInputField(brand);
		objFilter.clickonPriceFilter();
		boolean  isAnyPrice = objFilter.ispriceFilterAnyPriceBtn();
		Assert.assertEquals(isAnyPrice, true);
		System.out.println("AMZN_TC20 : PASSED");
}
  
  //verify the user can filter based on price range filter
  @Test
  public void tc21() throws InterruptedException {
	  String brand = prop.getProperty("brandName");
		objAmazonHeader.enterTextSearchInputField(brand);
		objFilter.enterLowPrice();		
		objFilter.enterHighPrice();
		
		boolean  isAnyPrice = objFilter.ispriceFilterAnyPriceBtn();
		Assert.assertEquals(isAnyPrice, true);
		System.out.println("AMZN_TC21 : PASSED");
}
//verify the user can filter based on colour filter
  @Test
  public void tc22() {
	  String brand = prop.getProperty("brandName");
		objAmazonHeader.enterTextSearchInputField(brand);
		objFilter.clickonColourButton();
		boolean  isColorClear = objFilter.isReviewClearBtn();
		Assert.assertEquals(isColorClear, true);
		System.out.println("AMZN_TC22 : PASSED");
}
  
  //verify the user can sort the results from price : high to low
  @Test
  public void tc23() {
	  String brand = prop.getProperty("brandName");
		objAmazonHeader.enterTextSearchInputField(brand);
		String sortOrder = prop.getProperty("sortRangeHightoLow");
		objAmazonProductListingPage.selectSortingFilter(sortOrder);
		
}
  //verify the user can sort the results based on New Arrivals
  @Test
  public void tc24() {
	  String brand = prop.getProperty("brandName");
		objAmazonHeader.enterTextSearchInputField(brand);
		String sortOrder = prop.getProperty("sortNewArrivals");
		objAmazonProductListingPage.selectSortingFilter(sortOrder);
		
}
  
  
  
  @DataProvider
  public Object[][]  getAddressData() {
	  Object[][]  addressData = new Object[1][10];
	  addressData[0][0] = "India";//country
	  addressData[0][1] = "amzon tester";//full name
	  addressData[0][2] = "9887766554"; //mobile num
	  addressData[0][3] = "673029";//pincode
	  addressData[0][4] = "v k memon road";//addressline1
	  addressData[0][5] = "pannyakara";//addresslin2
	  addressData[0][6] = "Govt U P School";//landmark
	  addressData[0][7] = "Calicut";//city
	  addressData[0][8] = "KERALA";//state	  
	  addressData[0][9] = " Home (7 am – 9 pm delivery) ";//address type
	 
			  
	  
	  
	return addressData;
	  
  }
  
  @DataProvider
  public Object[][]  getEditAddressData() {
	  Object[][]  addressData = new Object[1][10];
	  addressData[0][0] = "India";//country
	  addressData[0][1] = "amzon tester";//full name
	  addressData[0][2] = "9811111111"; //mobile num
	  addressData[0][3] = "673029";//pincode
	  addressData[0][4] = "Maitry road";//addressline1
	  addressData[0][5] = "Thiruvannur";//addresslin2
	  addressData[0][6] = "Thiruvannur U P School";//landmark
	  addressData[0][7] = "Calicut";//city
	  addressData[0][8] = "KERALA";//state	  
	  addressData[0][9] = " Home (7 am – 9 pm delivery) ";//address type
	 
			  
	  
	  
	return addressData;
	  
  }
  
  
  
  
    public void amazonLogin() throws InterruptedException
		 {
			
				
			 objAmazonHeader.clickOnHelloSigninButton();
			 String userName = prop.getProperty("userName");
			 String password = prop.getProperty("password");
			 waitUtility.waitForanElementVisible(driver,objAmazonLoginPage.signInEmailInput());
			 objAmazonLoginPage.enterTextSigninEmailInput(userName);
			 
			
			 waitUtility.waitForElementToBeClickable(driver, objAmazonLoginPage.continueButtonElement());
			 pageUtility.clickOnElement(objAmazonLoginPage.continueButtonElement());
			 
			 waitUtility.waitForElementToBeClickable(driver, objAmazonLoginPage.signInPasswordInput());
			 objAmazonLoginPage.enterTextSigninPasswordInput(password);
			
		
			 pageUtility.clickOnElement(objAmazonLoginPage.signInSubmit());		    
			 waitUtility.waitForanElementVisible(driver, objAmazonHeader.helloUserLabel());
				
			 String expectedUserName = "Hello, "+prop.getProperty("user");
			 String actualUserName = objAmazonHeader.helloUserLabel().getText();
			 Assert.assertEquals(actualUserName,expectedUserName);
			 System.out.println(actualUserName + " Logged in successfully");
			
		  	 }
	  
	  public void addToCartAnItem() throws InterruptedException {
		  
	  
		     waitUtility.waitForanElementVisible(driver, objAmazonHeader.searchInputField());     	
	     	
	     	 String searchWord = prop.getProperty("searchWord");
	     	 pageUtility.clearText(objAmazonHeader.searchInputField());
	     	 objAmazonHeader.enterTextSearchInputField(searchWord);
	     	
	     	 pageUtility.EnterKeyPress(driver,objAmazonHeader.searchInputField());
	     	 
	     	 int searchSize = objAmazonProductListingPage.searchResultSize();
	     	
	     	 
	         if(searchSize > 0) {
	        	List<WebElement> products =  objAmazonProductListingPage.searchResultTitles();
	            Iterator<WebElement> prdct =  products.iterator();
	            WebElement product1 = prdct.next();
	            pageUtility.clickOnElement(product1);
	            
	            Set<String> tabs =  driver.getWindowHandles();
	            Iterator<String> it = tabs.iterator();
	            //String parent = it.next();
	            String lastTab = it.next();
	            while(it.hasNext()) {
	            	lastTab = it.next();
	            }
	            driver.switchTo().window(lastTab);
	           
	            waitUtility.waitForElementToBeClickable(driver,objProductDetailPage.addToCartButton());
	          
	            pageUtility.clickOnElement(objProductDetailPage.addToCartButton());
	            //objProductDetailPage.closeModal();
	            //objAmazonHeader.goToCart();;
	            //waitUtility.HardWait();
	            System.out.println("1 Item added to cart");
	            
	            
	         }                
	        }
		/* 
	  public void removeItemfromCart() {
   	   waitUtility.waitForElementToBeClickable(driver, objAmazonHeader.cart());
   	   List<WebElement> cartProducts = objAmazonCartPage.cartProducts();
   	   int cartSize = cartProducts.size();
   	    
   	   for(int i=0;i<=cartSize;i++) {
   		   
   	   }
   	   
   	   
   	   
      }*/
	 
	 
	
}



