package automationCore;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class baseClass {

	 public  WebDriver driver; 
	   	public Properties prop;
	   	
	     public WebDriver browserInitialization(String browserName) throws IOException {
	    	 prop = new Properties();
	    	 FileInputStream fis = new FileInputStream("F:\\Harita\\Automation\\Amazon_Project\\src\\main\\resources\\testData\\testData.properties");
	    	 prop.load(fis);
	    	 
	if(browserName.equalsIgnoreCase("Chrome")) {
	    		 //ChromeOptions options = new ChromeOptions();
	    		 //options.addArguments("--disable-notifications");
	    		 System.setProperty("webdriver.chrome.driver", "F:\\Harita\\Automation\\Amazon_Project\\src\\main\\resources\\Drivers\\chromedriver.exe");
	    		 
	    		 driver = new ChromeDriver();
	    		
	    	 }else if(browserName.equalsIgnoreCase("Firefox")){
	    		 driver =new FirefoxDriver();
	    		 
	    	 }else if(browserName.equalsIgnoreCase("Edge")) {
	    		  driver = new EdgeDriver();
	    	 }
	    	
	    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	 
	    	 
	    	 return driver;
	     }
	     
	     public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
			TakesScreenshot  ts =  (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destinationFile =  System.getProperty("user.dir")+"\\test-output\\"+testCaseName+"png";
	    	//Files.copy(source, new File(destinationFile));
			com.google.common.io.Files.copy(source, new File(destinationFile));

			
			
			return destinationFile;
	    	 
	     }
	     
	     
	     
}
