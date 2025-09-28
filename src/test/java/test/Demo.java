package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.HomePage;

public class Demo extends Base {
	public WebDriver driver;
	HomePage homepage;
	String deliveryLocation = "Hyderabad";
	String searchInput = "roses";
	String sortByValue = "Low to High";
	String deliveryCity = "Shimogha";
	int itemNum = 2;
	String occation = "Congratulations";
	String pageTitle = "FlowerAura #1 Florist for Flower Delivery, Cakes & Gifts in India";

	@BeforeMethod
	public void setUp() {
		driver = launchBrowser();
	}

	@Test
	public void TC_001_VerifyThePageTitle() {
		Assert.assertEquals(driver.getTitle(), pageTitle, "Page Title is not matched");
	}

	@Test
	public void TC_002_VerifyDeliveryLocationUpdate() {
		homepage = new HomePage(driver);
		homepage.clickOnCitySelectionPopUp();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement enterLocationField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".selectCityPincode")));
		enterLocationField.sendKeys(deliveryLocation);
		homepage.clickOnCityOption();
		Assert.assertEquals(homepage.getDeliveryLocation(), deliveryLocation,
				"Delivery location not updated as expected");

	}

	@Test
	public void TC_003_E2EScenario() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.clickOnCitySelectionPopUp();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement enterLocationField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".selectCityPincode")));
		enterLocationField.sendKeys(deliveryLocation);
		homepage.clickOnCityOption();
		Thread.sleep(2000);
		WebElement searchContainer = wait.until(ExpectedConditions
				.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='search-container']//div"))));
		searchContainer.click();
		homepage.enterInputInSerachField(searchInput);
		Thread.sleep(2000);
		homepage.clickOnSearchIcon();
		Thread.sleep(2000);
		homepage.selectSortByOption(sortByValue);
		//Thread.sleep(2000);
		homepage.clickItem(itemNum);
		homepage.clickOnBuyNowOption();
		homepage.clickOnContinueOption();
		homepage.clickOnCheckoutOption();
		homepage.clickOnCloseIcon();
		homepage.clickOnMoreOptionsIcon();
		homepage.clickOnContactUsOption();
		System.out.println("Contact Details:: " + homepage.getContactdetils());
		homepage.clickOnMoreOptionsIcon();
		homepage.clickOnGiftFinder();
		homepage.enterCityName(deliveryCity);
		homepage.clickOnTodayOption();
		homepage.clickOnOccashionListOption();
		homepage.selectOccationType(occation);
		homepage.clickOnSubmitButton();

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null)
			quitBrowser(driver);
	}

}
