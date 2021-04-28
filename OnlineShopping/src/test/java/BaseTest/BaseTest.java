package BaseTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	// open browser

	public static WebDriver driver;

	public static Properties prop;

	public static  String projectPath ;
	
	public static WebDriverWait wait ;

	// open browser method

	public static void  openBrowser() throws Exception {

		try {
			
			projectPath = System.getProperty("user.dir");   // return project folder path

			String driverpath = projectPath + "\\drivers\\chromedriver.exe";   // return driver folder path 

			System.setProperty("webdriver.chrome.driver", driverpath );

			driver = new ChromeDriver();

			// open browser 

			prop = new Properties();

			prop.load(new FileInputStream("src/main/java/config/config.properties"));

			String URL = prop.getProperty("url");

			driver.get(URL);

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			driver.manage().window().maximize();

			System.out.println("Browser opened....!");

		}catch (Exception ex){
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
			ex.printStackTrace(); 
			driver.quit();
		}
	}


}
