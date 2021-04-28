package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class flipkartPageElements {

	public static WebElement loginCancel(WebDriver driver)
	{
		WebElement loginCancel = driver.findElement(By.xpath("//*[(text() = '✕' or . = '✕')]"));

		return loginCancel;
	}

	public static WebElement mobiles_filter(WebDriver driver)
	{
		WebElement mobiles_filter = driver.findElement(By.xpath("//*[(text() = 'Mobiles' or . = 'Mobiles')]"));

		return mobiles_filter;
	}
	
	public static WebElement searchText(WebDriver driver)
	{
		WebElement searchText = driver.findElement(By.xpath("//input[@name='q']"));

		return searchText;
	}

	public static WebElement searchButton(WebDriver driver)
	{
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button"));

		return searchButton;
	}

	public static WebElement firstResult(WebDriver driver)
	{
		WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]"));

		return firstResult;
	}

	public static WebElement firstResultPrice(WebDriver driver)
	{
		WebElement firstResultPrice = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[2]/div[1]/div/div[1]"));

		return firstResultPrice;
	}

	public static WebElement firstResultRatings(WebDriver driver)
	{
		WebElement firstResultRatings = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[2]/span[2]/span/span[1]"));

		return firstResultRatings;
	}

	public static WebElement firstResultStorageCapacity(WebDriver driver)
	{
		WebElement firstResultStorageCapacity = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[3]/ul/li[1]"));

		return firstResultStorageCapacity;
	}

	public static WebElement selectMaxPrice(WebDriver driver)
	{															 
		WebElement selectMaxPrice = driver.findElement(By.xpath("//div[@id='container']/div/div[3]/div/div/div/div/div/section[2]/div[4]/div[3]/select"));

		return selectMaxPrice;
	}
	
	public static WebElement selectMaxPriceOnmObileFilter(WebDriver driver)
	{															 
		WebElement selectMaxPriceOnmObileFilter = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div/section[2]/div[4]/div[3]/select"));

		return selectMaxPriceOnmObileFilter;
	}

	public static WebElement searchBrand(WebDriver driver)
	{
		WebElement searchBrand = driver.findElement(By.xpath("//*[@type = 'text' and @placeholder = 'Search Brand']"));

		return searchBrand;
	}

	public static WebElement appleModelCheckBox(WebDriver driver)
	{
		WebElement AppleModelCheckBox = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[5]/div[2]/div[1]/div[2]/div/label/div[2]"));

		return AppleModelCheckBox;
	}

	public static WebElement ratings4Above(WebDriver driver)
	{
		WebElement ratings4Above = driver.findElement(By.xpath("//*[(text() = '4★ & above' or . = '4★ & above')]"));

		return ratings4Above;
	}

	public static WebElement internalStorageFilter(WebDriver driver)
	{
		WebElement internalStorageFilter = driver.findElement(By.xpath("//*[(text() = 'Internal Storage' or . = 'Internal Storage')]"));

		return internalStorageFilter;
	}

	public static WebElement internalStorageFilter_32GB(WebDriver driver)
	{
		WebElement internalStorageFilter_16GB = driver.findElement(By.xpath("//*[(text() = '32 - 63.9 GB' or . = '32 - 63.9 GB')]"));

		return internalStorageFilter_16GB;
	}

}
