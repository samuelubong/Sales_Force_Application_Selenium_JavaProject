package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	static ReadConfig  readconfig = new ReadConfig(); // Creating object
	// Integrating data from ReadConfig
	public static String baseURL=readconfig.getApplicationURL(); 
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword(); 
	public  String browser=readconfig.getbrowser();
	public static ChromeOptions handlingSSL = new ChromeOptions();
	public static EdgeOptions handlingSSL1 = new EdgeOptions();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass()
	public  void setup()
	{	
		if(browser.equalsIgnoreCase("chrome")) {
			 //Create instance of ChromeOptions Class
			//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			//handlingSSL.setAcceptInsecureCerts(true);
			//Creating instance of Chrome driver by passing reference of ChromeOptions object
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			//WebDriverManager.chromedriver().browserVersion("111.0.5563").setup();
			driver = new ChromeDriver();}
		
		else if(browser.equalsIgnoreCase("edge")) {
			 //Create instance of MSEdgeOptions Class
			
			//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			//Creating instance of Edge driver by passing reference of EdgeOptions object
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver(handlingSSL);}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			 //Create instance of FirefoxOptions Class
			//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			//Creating instance of Firefox driver by passing reference of FirefoxOptions object
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver(handlingSSL);}
		
		// Initialization // Logger initiated within the setup method
		logger=Logger.getLogger("SFA_MVP");// Project Name 
		PropertyConfigurator.configure("log4j.properties"); // Added Logger
		logger.setLevel(Level.DEBUG); // to get the debug log
		logger.debug("Debug logging has started ");
		
		driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@AfterClass()
	public void tearDown()
	{
		driver.quit();
	}

	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public static String randomestring() 
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5); // generate random char string with the specified values passed 
		return (generatedString1);										 
	}

	public static String randomeNum() 
	{
		String generatedString2 = RandomStringUtils.randomNumeric(4);// generate random digits with the specified values passed
		return (generatedString2);
	}
	
}