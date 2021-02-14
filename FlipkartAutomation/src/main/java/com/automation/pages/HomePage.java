package com.automation.pages;



import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import com.atuomation.util.TestBaseManager;

import junit.framework.Assert;



public class HomePage extends TestBaseManager{
		
	//Page Factory - OR:
	@FindBy(xpath="//input[@name='q']")
	private WebElement sSearchBox;
	
	@FindBy(xpath="//button")
	private WebElement sSearchbutton;
	
	
	@FindBy(xpath="//span[starts-with(text(), 'Showing') and  contains(text(),'results for')]")
	private WebElement sSearchResultHeader;
	
	//@FindBy(xpath="//div[@class = '_2pi5LC col-12-12']//child::div[@class = 'col col-7-12']/div[1]")
	@FindBy(xpath="//div[@class='col col-7-12']/div[1]")
	private List<WebElement> sSearchedItem;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	private List<WebElement> sAddToCart;
	
	
	@FindBy(xpath="//button[text()='GO TO CART']")
	private List<WebElement> sGotoCart;
	

	@FindBy(xpath="//button[text()='BUY NOW']")
	private WebElement sBuyNow;
	
	
	@FindBy(xpath="//button/span[text()='Place Order']")
	private WebElement sViewCartXPath;
	
	
	
	@FindBy(xpath="	//button/span[text() = 'Place Order']")
	private WebElement sPlaceOrderButton;
	


	
	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	
	
	// Business Function 
	public void serachProduct(String productName) 
	{	
		try {
	
			sSearchBox.sendKeys(productName);
			sSearchbutton.click();
			 
			wait.until(ExpectedConditions.visibilityOf(sSearchResultHeader));
						
			Assert.assertTrue(sSearchResultHeader.isDisplayed());
			Reporter.log("Search Result displayed correctly");
			} 

		catch (Exception e) {
				// TBD: Auto-generated catch block.
			e.printStackTrace();
			Reporter.log("Search Result Not displayed correctly");
			}
	}
	
	
	public void getRelevantItemFromList(String itemColor, String itemRAM) {
		
		try {
			Iterator<WebElement> items = sSearchedItem.iterator() ;
	
			while (items.hasNext()) {
				WebElement item = items.next();
			    System.out.println(item.getText());
			    Thread.sleep(2000);
			    highLightObject(item);
			    
			    
	 		    if ((item.getText().contains(itemColor)) && (item.getText().contains(itemRAM))) {
	 		    	item.click();	
	 		    	break;
				}	
				
		   }
		}
		catch (Exception e) {
			// TBD: Auto-generated catch block.
		e.printStackTrace();
		Reporter.log("Function : getRelevantItemFromList. Not able to select required item ");
		}
		
	}
	
	
	public void addTOCartANDPalceOrder() {
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		
		//sViewCartXPath
		wait.until(ExpectedConditions.elementToBeClickable(sBuyNow));
		
		sBuyNow.click();
	
		wait.until(ExpectedConditions.titleContains("Secure Payment"));
		Reporter.log("item Added to card successfully");
	
	}
	
	public void placeOrder() {
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
	
		//sPlaceOrderButton.click();
		wait.until(ExpectedConditions.titleContains("Secure Payment"));
		Reporter.log("Function : placeOrder. Payment page displayed");
	
	}


}
