package OnlineShopping;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.opencsv.CSVWriter;

import BaseTest.BaseTest;
import POM.flipkartPageElements;

//in this script searching for Apple,  filter with maximum price of INR ₹30000, Storage of the device, and Ratings on Flipkart website.

public class SearchAppleIPhone7WithFilters {

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

			// clicking on Mobiles filter on home page

			flipkartPageElements.mobiles_filter(BaseTest.driver).click();

			// selecting maximum price as 30000

			Select select = new Select(flipkartPageElements.selectMaxPriceOnmObileFilter(BaseTest.driver));

			select.selectByValue("30000");

			Thread.sleep(5000);

			// filtering branch as APPLE

			flipkartPageElements.searchBrand(BaseTest.driver).sendKeys("Apple");

			flipkartPageElements.appleModelCheckBox(BaseTest.driver).click();

			Thread.sleep(5000);

			// filtering ratings as 4 above

			flipkartPageElements.ratings4Above(BaseTest.driver).click();

			Thread.sleep(5000);

			// filtering storage as 32 GB

			flipkartPageElements.internalStorageFilter(BaseTest.driver).click();

			flipkartPageElements.internalStorageFilter_32GB(BaseTest.driver).click();

			Thread.sleep(5000);

			// Retrieved data storing into data file.

			WebElement firstMobileResult =flipkartPageElements.firstResult(BaseTest.driver);
			
			String actualMobile = firstMobileResult.getText();

			System.out.println(actualMobile);
			
			WebElement firstMobileResultPrice =flipkartPageElements.firstResultPrice(BaseTest.driver);
			
			String mobileResultPrice = firstMobileResultPrice.getText();

			System.out.println(mobileResultPrice);

			WebElement firstMobileResultRatings = flipkartPageElements.firstResultRatings(BaseTest.driver);
			
			String[] mobileResultRatings = firstMobileResultRatings.getText().split(" ");

			System.out.println(mobileResultRatings[0]);
			
			String ratings= mobileResultRatings[0].replace(",", "");
			
			System.out.println(ratings);
	
			File file = new File(System.getProperty("user.dir")+"//datafiles//TestData.csv");

			FileWriter outputfile = new FileWriter(file);

			CSVWriter writer = new CSVWriter(outputfile);

			List<String[]> data = new ArrayList<String[]>();
			data.add(new String[] { "Device Details", "Price", "Ratings" });
			
			data.add(new String[] { actualMobile, mobileResultPrice, ratings });
			
			writer.writeAll(data);

			
			writer.close();
			BaseTest.driver.quit();

		}catch (Exception ex){
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
			ex.printStackTrace(); 
			BaseTest.driver.quit();
		}
	}
}
