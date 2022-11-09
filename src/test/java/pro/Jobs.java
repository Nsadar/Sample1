package pro;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Jobs extends Generics {
	// Search for a job
	WebDriver driver;

	@Test
	public void jobSearch_Valid_Criteria() throws Exception {
		Boolean found = false;
		driver = Generics.driverSetUp(Browser.Chrome);
		driver.get("https://akamaicareers.inflightcloud.com/");
		driver.manage().window().maximize();

		// entering search conditions
		WebElement careerSearch = driver
				.findElement(By.xpath("//input[@placeholder='Search by category, keyword, or location']"));
		careerSearch.sendKeys("Senior Software Development Engineer in Test");
		careerSearch.sendKeys(Keys.ENTER);

		WebElement filterCountry = driver.findElement(By.xpath("//input[@id='location']"));
		filterCountry.sendKeys("Poland");
		Thread.sleep(3000);
		filterCountry.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		List<WebElement> searchList = driver.findElements(By.xpath("//div[@class='row no-gutters']"));
		Thread.sleep(3000);
		System.out.println("Length: " + searchList.size());
		if (searchList.size() > 0) {
			found = true;
			System.out.println("Records Found");
		}

		// validation logic to find records returns data assertTrue(found);

		Generics.closeBrowser(driver);
	}

	@Test
	public void jobSearch_InValid_Criteria() throws Exception {

		String expectedResult = "We found 0 jobs based on your search criteria";
		driver = Generics.driverSetUp(Browser.Chrome);
		driver.get("https://akamaicareers.inflightcloud.com/");
		driver.manage().window().maximize();

		// entering invalid search conditions
		WebElement careerSearch = driver
				.findElement(By.xpath("//input[@placeholder='Search by category, keyword, or location']"));
		careerSearch.sendKeys("XXX");

		WebElement filterCountry = driver.findElement(By.xpath("//button[@title='Search']"));
		filterCountry.click();
		WebElement element = driver
				.findElement(By.xpath("//span[contains(text(),'We found 0 jobs based on your search criteria')]"));
		String actualResult = element.getText();
		System.out.println("Text Reterived: " + actualResult);

		// Perform validations
		Assert.assertEquals(expectedResult, actualResult);
		// close browser
		Generics.closeBrowser(driver);
	}

}
