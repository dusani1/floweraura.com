package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.ElementUtils;

public class HomePage extends ElementUtils{
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-selected-city-input")
	WebElement citySelectionPopup;

	@FindBy(xpath = "(//input[@class='selectCityPincode']//following::span)[1]")
	WebElement cityOption;

	@FindBy(id = "search_block")
	WebElement serachTxtField;

	@FindBy(id = "edit_submit")
	WebElement searchIcon;

	@FindBy(id = "st-sort-web")
	WebElement sortByOption;

	@FindBy(xpath = "//div[@class='st-col-md-4']")
	List<WebElement> items;

	@FindBy(partialLinkText = "BUY NOW")
	WebElement buyNowOption;

	@FindBy(xpath = "//*[text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//div[@class='totalCheckout']//span")
	WebElement checkoutButton;

	@FindBy(xpath = "//*[@class='closeUserLoginModal']")
	WebElement closeIcon;

	@FindBy(xpath = "//*[@class='bgSpriteMenu']")
	WebElement moreOptionsIcon;

	@FindBy(xpath = "//*[text()='Contact Us']")
	WebElement contactUsOption;

	@FindBy(xpath = "//div[@class='callUs']//span")
	WebElement callUsDetiails;

	@FindBy(xpath = "//*[text()='Gift Finder']")
	WebElement giftFinderOption;

	@FindBy(id = "typeCityName")
	WebElement cityNameField;

	@FindBy(xpath = "//*[text()='Today']")
	WebElement todayOption;

	@FindBy(id = "occashionList")
	WebElement occashionListOption;

	@FindBy(xpath = "//ul[@class='occassion-list']//li")
	List<WebElement> occashionListOptions;

	@FindBy(xpath = "//*[@class='ggSubmitBtn']//button")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@class='main-input-box']//span")
	WebElement deliveryLocation;

	public void clickOnSubmitButton() {
		waitForElementAndClick(submitButton, 10);

	}

	public String getDeliveryLocation() {
		return deliveryLocation.getText();
	}
	public void clickOnCitySelectionPopUp() {
		waitForElementAndClick(citySelectionPopup, 10);
	}

	public void clickOnCityOption() {
		waitForElementAndClick(cityOption, 10);
	}

	public void enterInputInSerachField(String input) {
		serachTxtField.sendKeys(input);
	}

	public void clickOnSearchIcon() {
		waitForElementAndClick(searchIcon, 10);
	}

	public void selectSortByOption(String value) {
		Select sortByDropdown = new Select(sortByOption);
		sortByDropdown.selectByContainsVisibleText(value);
	}

	public void clickItem(int index) {
		items.get(index - 1).click();
	}

	public void clickOnBuyNowOption() {
		waitForVisibilityOfElement(buyNowOption, 10);
		scrollToElementAndClick(buyNowOption, driver);

	}

	public void clickOnContinueOption() {
		waitForElementAndClick(continueButton, 10);
		
	}

	public void clickOnMoreOptionsIcon() {
		waitForElementAndClick(moreOptionsIcon, 10);
		
	}

	public void clickOnCloseIcon() {
		waitForElementAndClick(closeIcon, 10);
		
	}

	public void clickOnCheckoutOption() {
		waitForElementAndClick(checkoutButton, 10);
	}

	public void clickOnGiftFinder() {
		waitForElementAndClick(giftFinderOption, 10);
		
	}

	public String getContactdetils() {
		return callUsDetiails.getText();
	}

	public void clickOnContactUsOption() {
		waitForElementAndClick(contactUsOption, 10);
	
	}

	public void clickOnOccashionListOption() {
		waitForElementAndClick(occashionListOption, 10);
		
	}

	public void clickOnTodayOption() {
		waitForElementAndClick(todayOption, 10);
		
	}

	public void enterCityName(String cityName) {
		cityNameField.clear();
		cityNameField.sendKeys(cityName);
	}

	public void selectOccationType(String occation) {
		for (WebElement occationtype : occashionListOptions) {
			if (occationtype.getText().equalsIgnoreCase(occation.trim())) {
				occationtype.click();
				break;
			}
		}
	}

}
