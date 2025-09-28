package test;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

public class Demo {
	public static void main(String[] args) throws InterruptedException {
			String deliveryLocation = "Hyderabad";
			String url = "https://www.floweraura.com/";
			String searchInput = "roses";
			String sortByOpton = "Low to High"; 
			String deliveryCity = "Shimogha";
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.id("user-selected-city-input")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement enterLocationField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".selectCityPincode")));
		enterLocationField.sendKeys(deliveryLocation);
		WebElement cityOption = driver
				.findElement(By.xpath("(//input[@class='selectCityPincode']//following::span)[1]"));
		cityOption.click();
		Thread.sleep(2000);
		WebElement searchContainer = wait.until(ExpectedConditions
				.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='search-container']//div"))));
		searchContainer.click();
		driver.findElement(By.id("search_block")).sendKeys(searchInput);
		Thread.sleep(200);
		driver.findElement(By.id("edit_submit")).click();
		Thread.sleep(2000);
		WebElement sortByDropdownElement = driver.findElement(By.id("st-sort-web"));
		Select sortByDropdown = new Select(sortByDropdownElement);
		Thread.sleep(200);
		sortByDropdown.selectByContainsVisibleText(sortByOpton);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='st-col-md-4'])[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("BUY NOW")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Continue']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='totalCheckout']//span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='closeUserLoginModal']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='bgSpriteMenu']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Contact Us']")).click();
		Thread.sleep(1000);
		String contactDetails = driver.findElement(By.xpath("//div[@class='callUs']//span")).getText();
		System.out.println("Contact Details:: "+contactDetails);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='bgSpriteMenu']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Gift Finder']")).click();
		Thread.sleep(1000);
		WebElement cityNameField = driver.findElement(By.id("typeCityName"));
		cityNameField.clear();
		cityNameField.sendKeys(deliveryCity);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Today']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("occashionList")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Congratulations']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='ggSubmitBtn']//button")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
