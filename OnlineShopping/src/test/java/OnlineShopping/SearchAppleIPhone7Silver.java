package OnlineShopping;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import POM.flipkartPageElements;

// in this script searching for "Apple iPhone 7 (Silver, 32 GB)" having a maximum price of INR ₹30000, on Flipkart website.
// and verifying device model , storage capacity, and customer ratings are displayed.

public class SearchAppleIPhone7Silver {

	@Test
	public static void searchIphone7Silver() throws Exception {

		try {

			// open browser

			BaseTest.openBrowser();

			// clicking on cancel in Login popup

			if(flipkartPageElements.loginCancel(BaseTest.driver).isDisplayed())
			{
				flipkartPageElements.loginCancel(BaseTest.driver).click();
			}

			String expectedMobile = "Apple iPhone 7 (Silver, 32 GB)";

			flipkartPageElements.searchText(BaseTest.driver).sendKeys(expectedMobile);

			flipkartPageElements.searchButton(BaseTest.driver).click();

			Thread.sleep(5000);
			
			// selecting maximum price as 30000

			Select select = new Select(flipkartPageElements.selectMaxPrice(BaseTest.driver));

			select.selectByValue("30000");

			Thread.sleep(5000);

			// verifying "Apple iPhone 7 (Silver, 32 GB)" mobile is displayed

			BaseTest.wait = new WebDriverWait(BaseTest.driver, 20);

			WebElement firstMobileResult =flipkartPageElements.firstResult(BaseTest.driver);

			BaseTest.wait.until(ExpectedConditions.visibilityOf(firstMobileResult));

			Thread.sleep(5000);

			String actualMobile = firstMobileResult.getText();

			System.out.println(actualMobile);

			Assert.assertEquals(true, actualMobile.equalsIgnoreCase(expectedMobile));

			// verifying device storage

			String actualStorageCapacity = flipkartPageElements.firstResultStorageCapacity(BaseTest.driver).getText();

			System.out.println(actualStorageCapacity);

			String expectedStorageCapacity = "32 GB";

			System.out.println(expectedStorageCapacity);

			System.out.println(actualStorageCapacity.contains(expectedStorageCapacity));
			
			Assert.assertEquals(true, actualStorageCapacity.contains(expectedStorageCapacity));
			
			// verifying customer ratings are displayed.

			Assert.assertEquals(true, flipkartPageElements.firstResultRatings(BaseTest.driver).isDisplayed());

			BaseTest.driver.quit();

		}catch (Exception ex){
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
			ex.printStackTrace(); 
			BaseTest.driver.quit();
		}
	}
}
