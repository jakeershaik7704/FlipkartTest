package OnlineShopping;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import POM.flipkartPageElements;

// in this script searching for iPhones having a maximum price of INR 40,000 on Flipkart website.

public class AppleIphone6sSearch {

	@Test
	public static void searchIphone6() throws Exception {

		try {
			
			// open browser
			
			BaseTest.openBrowser();

			// clicking on cancel in Login popup

			if(flipkartPageElements.loginCancel(BaseTest.driver).isDisplayed())
			{
				flipkartPageElements.loginCancel(BaseTest.driver).click();
			}

			String expectedMobile = "APPLE iPhone 6s Plus (Gold, 32 GB)";
			
			flipkartPageElements.searchText(BaseTest.driver).sendKeys(expectedMobile);

			flipkartPageElements.searchButton(BaseTest.driver).click();

			// verifying "Apple iPhone 6s Plus(Gold, 32 GB)" mobile is displayed

			BaseTest.wait = new WebDriverWait(BaseTest.driver, 10);

			WebElement firstMobileResult =flipkartPageElements.firstResult(BaseTest.driver);

			BaseTest.wait.until(ExpectedConditions.visibilityOf(firstMobileResult));

			Thread.sleep(5000);
			
			String actualMobile = firstMobileResult.getText();

			System.out.println(actualMobile);

			Assert.assertEquals(true, actualMobile.equalsIgnoreCase(expectedMobile));

			// verifying mobile price
			
			WebElement firstMobileResultPrice =flipkartPageElements.firstResultPrice(BaseTest.driver);
			
			String mobileResultPrice = firstMobileResultPrice.getText();

			StringBuilder sb = new StringBuilder(mobileResultPrice);
			sb.deleteCharAt(0);
			
			String price = sb.toString();
			
			System.out.println(price);
					
			String str = price.replaceAll("[,]", "");
				
			int actalPrice = Integer.parseInt(str);
		
			System.out.println(actalPrice);

			int expectedPrice =40000;
			
			Assert.assertTrue(actalPrice<=expectedPrice);
			
			BaseTest.driver.quit();

		}catch (Exception ex){
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
			ex.printStackTrace(); 
			BaseTest.driver.quit();
		}
	}
}
