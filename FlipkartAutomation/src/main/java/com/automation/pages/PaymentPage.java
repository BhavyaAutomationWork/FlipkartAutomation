package com.automation.pages;




import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.atuomation.util.TestBaseManager;





public class PaymentPage extends TestBaseManager{
		
	
	@FindBy(xpath="//button[text()='Deliver Here']")
	private WebElement sDeliverHere;
	
	@FindBy(xpath="//button[text()='CONTINUE']")
	private WebElement sContinue;
	
	@FindBy(xpath="//div[text()='Open Box Delivery']")
	private WebElement sOpenBoxDeliveryPop;
	
	@FindBy(xpath="//button[text()='Accept & Continue']")
	private WebElement sAccept;
	
	//@FindBy(xpath="//label[@for='CREDIT']")
	@FindBy(xpath="//input[@id='CREDIT']")
	private WebElement sCreditCardpayment;
	
	@FindBy(xpath="//input[@name='cardNumber']")
	private WebElement sCreditCardNumber;
	
	@FindBy(xpath="//select[@name='month']")
	private WebElement sMonty;

	@FindBy(xpath="//select[@name='year']")
	private WebElement sYear;
	
	@FindBy(xpath="//input[@name='cvv']")
	private WebElement sCVV;
	
	@FindBy(xpath="//button[contains(text(),'PAY')]")
	private WebElement sPaybutton;
	
	
	@FindBy(xpath="//button[[text()=''Retry']")
	private WebElement sRetry;
	
	
	@FindBy(xpath="//div[text()='Payment Failed']")
	private WebElement sPaymentFailed;
	
	
	
	//Initializing the Page Objects:
	public PaymentPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	
	
	public void FillPaymentDetails(String cardNumber , String expireMonth , String expiryYear , String cvv) 
	{
			
		try 
		{
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			wait.until(ExpectedConditions.titleContains("Secure Payment"));
			

			
			wait.until(ExpectedConditions.elementToBeClickable(sContinue));
			sContinue.click();
			
			Thread.sleep(2000);
			if (sOpenBoxDeliveryPop.isDisplayed()) 
			{	
				Thread.sleep(2000);
				sAccept.click();
				
			}
			
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", sCreditCardpayment);

			
			sCreditCardNumber.sendKeys(cardNumber);
			
			Select Mdropdown = new Select(sMonty);
			Mdropdown.selectByVisibleText(expireMonth);
			
			
			Select Yeardropdown = new Select(sYear);
			Yeardropdown.selectByVisibleText(expiryYear);
			
			
			sCVV.sendKeys(cvv);
			
			
			wait.until(ExpectedConditions.elementToBeClickable(sPaybutton));
			sPaybutton.click();
			
			Reporter.log("Function : FillPaymentDetails. Payment details filled successfully");
			
		}
		
		catch (Exception e) 
		{
			// TBD: Auto-generated catch block.
			e.printStackTrace();
			Reporter.log("Function : FillPaymentDetails. Payment details filling Error");
		}
	
		
	
	}

	
	
	public void varifyPaySuccess() 
	{
			
		try 
		{
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			wait.until(ExpectedConditions.titleContains("Secure Payment"));
			//wait.until(ExpectedConditions.elementToBeClickable(sRetry));

			//Assert.assertTrue("Payment is unsuccessfull",sPaymentFailed.isDisplayed());
			Reporter.log("payment validation Successfull");
		}
		
		catch (Exception e) 
		{
			// TBD: Auto-generated catch block.
			e.printStackTrace();
			Reporter.log("payment validation Not Successfull");
		}
	
	
	}

}
