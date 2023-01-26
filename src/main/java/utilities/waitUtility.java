package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitUtility {
public static final long EXPLICIT_WAIT = 10;
	
	public static void waitForElementToBeClickable(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable((target)));

	}
	public static void waitForElementToBePresent(WebDriver driver, WebElement target,String value) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(target, value));

	}
	
	public static void waitForanElementVisible(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
	
		wait.until(ExpectedConditions.visibilityOf(target));
	}
	public static void waitForAlertPresent(WebDriver driver) {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
	  wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void HardWait() throws InterruptedException {
		Thread.sleep(6000);
	}
}
