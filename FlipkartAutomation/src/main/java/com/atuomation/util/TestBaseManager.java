package com.atuomation.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import junit.framework.Assert;


public class TestBaseManager {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	
	public TestBaseManager()
	{
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/automation"
						+ "/config/config.properties");
				prop.load(ip);
				} 
			catch (FileNotFoundException e) {
				e.printStackTrace();} 
			catch (IOException e) {
				e.printStackTrace();}
	}
	

	public static void initialization(String driverName, String varDriverPath) 
	{

		try 
		{	
			if (driverName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",varDriverPath );
				 driver = new ChromeDriver();
			}else if (driverName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", varDriverPath);
				 driver = new FirefoxDriver();
			} else {
				Assert.assertTrue("No Browser Found", false);
			}
			
			wait = new WebDriverWait(driver, 15);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			Reporter.log("Function : initialization.  Test Base initialization success");
			//driver.get(BASE_URL);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			Reporter.log("Function : initialization. Error in Test Base initialization");	
		}
	
		
	}
	
	public static void highLightObject(WebElement element) throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", element);
	
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

		Thread.sleep(500);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}


}
