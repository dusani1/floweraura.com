package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	 WebDriver driver;
	
	 public void clickOnElement(WebElement element) {
		 element.click();
	 }
	 
	 public void waitForElementAndClick(WebElement element, int seconds) {
		waitForVisibilityOfElement(element, seconds);
		 element.click();
		 
	 }
	 
	 public void waitForVisibilityOfElement(WebElement element, int seconds) {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 
	 public void scrollToElementAndClick(WebElement element, WebDriver driver) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", element);
		    element.click();
	 }
}
