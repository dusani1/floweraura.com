package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {
	WebDriver driver;
	String browser = "chrome";
	String url = "https://www.floweraura.com/";

	public WebDriver launchBrowser() {
		switch (browser.toLowerCase()) {
		case "chrome":
			// WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications"); // disables notifications
			driver = new ChromeDriver(chromeOptions);
			break;

		case "firefox":
			// WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addPreference("dom.webnotifications.enabled", false); // disables notifications
			driver = new FirefoxDriver(firefoxOptions);
			break;

		case "edge":
			// WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--disable-notifications"); // disables notifications
			driver = new EdgeDriver(edgeOptions);
			break;

		default:
			// fallback to Chrome
			// WebDriverManager.chromedriver().setup();
			ChromeOptions defaultOptions = new ChromeOptions();
			defaultOptions.addArguments("--disable-notifications");
			driver = new ChromeDriver(defaultOptions);
			break;
		}

		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	public void quitBrowser(WebDriver driver) {
		if (driver != null) {
			driver.quit();
		}
	}
}
