package com.atuomation.testcase;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.atuomation.util.TestBaseManager;
import com.automation.pages.HomePage;


public class HomePageTest extends TestBaseManager {

	HomePage homepage;
	//WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		//TestBaseManager.initialization("Chrome");
		homepage = new HomePage();	
	}
	
	
	
	@Test
	public void perfromSearchItem () {
		
		String varProduct;
		String varProdcolor;
		String varProdMemory;
		
		varProduct  = prop.getProperty("searchProduct");
		varProdcolor = prop.getProperty("prodColor");
		varProdMemory = prop.getProperty("prodMemory");
		
		
		homepage.serachProduct(varProduct);
		homepage.getRelevantItemFromList(varProdcolor,varProdMemory);
		homepage.addTOCartANDPalceOrder();
		//homepage.placeOrder();
		Reporter.log("Test : perfromSearchItem . Execution completed successfully");
	}
	
}
	


