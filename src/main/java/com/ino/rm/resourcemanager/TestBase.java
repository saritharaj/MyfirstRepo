package com.ino.rm.resourcemanager;

//import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	public static WebDriver driver;
	//public static final String companyUrl = "https://innovatu:rm@123@dev-rm.innovaturelabs.com";
	@BeforeSuite
	public  WebDriver OpenBrowser() 
	{

	System.setProperty("webdriver.chrome.driver","D:\\Automation\\resourcemanager\\Driver\\chromedriver.exe");
	
	String url = "https://innovatu:rm@123@dev-rm.innovaturelabs.com";
	driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize(); 
	return driver;

	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void loadcompanyUrl(WebDriver driver) {
		String url = "https://innovatu:rm@123@dev-rm.innovaturelabs.com";
		driver=new ChromeDriver();
		driver.get(url);
		
	}
	public static WebDriver chromeSetup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\resourcemanager\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		// options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		return driver;
	}
}
