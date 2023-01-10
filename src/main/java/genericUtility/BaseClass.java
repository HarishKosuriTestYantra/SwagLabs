package genericUtility;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;
import objectRepository.ProductsPage;


public class BaseClass {
	
	public JavaUtility jUtil = new JavaUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver;
	
	@BeforeSuite(groups = {"smoke", "regression"})
	public void bsConfig() {
		Reporter.log("--- DataBase connected successfully ---", true);
	}

	@BeforeClass(groups = {"smoke", "regression"})

	public void bcConfig() throws IOException {
		String browser = System.getProperty("browser");
		String url = pUtil.readDataFromPropertyFile("url");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log("Chrome browser launched successfully", true);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log("FireFox browser launched successfully", true);
		} else {
			Reporter.log("Enter valid browser", true);
		}

		wUtil.maximizeScreen(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(url);
	}

	@BeforeMethod(groups = {"smoke", "regression"})
	public void bmConfig() throws EncryptedDocumentException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		String username = pUtil.readDataFromPropertyFile("username");
		String password = pUtil.readDataFromPropertyFile("password");
		lp.login(username, password);
	}

	@AfterMethod(groups = {"smoke", "regression"})
	public void amConfig()  {
		
		ProductsPage prp = new ProductsPage(driver);
		prp.clickOnMenuBar();
		prp.logout();
		
	}

	@AfterClass(groups = {"smoke", "regression"})
	public void acConfig() {
		driver.quit();
	}

	@AfterSuite(groups = {"smoke", "regression"})
	public void asConfig() {
		Reporter.log("--- DataBase disconnected successfully ---", true);
	}
	

}
