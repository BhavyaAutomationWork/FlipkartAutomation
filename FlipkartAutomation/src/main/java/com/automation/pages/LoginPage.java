package com.automation.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import com.atuomation.util.TestBaseManager;

import junit.framework.Assert;



public class LoginPage extends TestBaseManager{
		
	//WebDriver driver;

	//Page Factory - OR:
	@FindBy(xpath="//form/Div/input[@type = 'text']")
	private WebElement username;
	
	@FindBy(xpath="//form/Div/input[@type = 'password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']/span[text()='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt='Flipkart' and @title='Flipkart']")
	private WebElement Logo;
	

	@FindBy(xpath="//div[text()='My Account']")
	private WebElement myAccount;
	
	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateLogoImage(){
		return Logo.isDisplayed();
	}
	
	// Business Function 
	
	public void launchApplication(String URL) 
	{	
		try {
			String expectedTitle = "";
			String actualTitle = "";
			driver.get(URL);
			Thread.sleep(1000);
			expectedTitle  = "Online Shopping Site" ;	
			actualTitle = driver.getTitle();
			
			wait.until(ExpectedConditions.titleContains(expectedTitle));
			
			Assert.assertTrue(actualTitle.contains(expectedTitle));
			Reporter.log("Page Load Successfull");
			} 

		catch (InterruptedException e) {
				// TBD: Auto-generated catch block.
			e.printStackTrace();
			Reporter.log("Page Load Not Successfull");
			}
	}


	public void enterCredentials(String UserName, String Password) 
	{	
		try {
			
			String expectedTitle = "";
			String actualTitle = "";
			
			username.sendKeys(UserName);
			password.sendKeys(Password);
			loginBtn.click();
			Thread.sleep(1000);
			
			expectedTitle  = "Online Shopping Site" ;	
			actualTitle = validateLoginPageTitle();
			
			wait.until(ExpectedConditions.titleContains(expectedTitle));
			
			Assert.assertTrue(actualTitle.contains(expectedTitle));
		
			Reporter.log("Login Successfull");
			} 
	
		catch (InterruptedException e) {
				// TBD: Auto-generated catch block.
			e.printStackTrace();
			Reporter.log("Login Not Successfull");
			}
	}
	
	



}
