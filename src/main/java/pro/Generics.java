package pro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generics {

	public static WebDriver driverSetUp(Browser driver) throws Exception {
		// get current user directory
		String userPath = System.getProperty("user.dir");
		WebDriver browser;
		System.out.println(userPath);
		switch (driver) {
		case Chrome:
			String driverPath = userPath.concat("\\src\\test\\resources\\chromedriver.exe");
			System.out.println(driverPath);
			System.setProperty("webdriver.chrome.driver", driverPath);
			browser = new ChromeDriver();
			break;
		default:
			throw new Exception("InValid Browser Launch");
		}
		return browser;

	}

	public static void closeBrowser(WebDriver driver) {
		driver.close();
	}

}
