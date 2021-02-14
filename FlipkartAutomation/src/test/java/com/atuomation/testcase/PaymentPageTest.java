package com.atuomation.testcase;


import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.atuomation.util.TestBaseManager;
import com.automation.pages.PaymentPage;


public class PaymentPageTest extends TestBaseManager {

	PaymentPage paymentpage;
	//WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		//TestBaseManager.initialization("Chrome");
		paymentpage = new PaymentPage();	
	}
	
	
	
	@Test
	public void perfromPayment () {
		
		
		String varCardNumber;
		String varMonth;
		String varYear;
		String varCVV;
		
		varCardNumber  = prop.getProperty("cardNumber");
		varMonth = prop.getProperty("cardxpMonth");
		varYear = prop.getProperty("cardExpYear");
		varCVV = prop.getProperty("cardCVV");
		
		//paymentpage.FillPaymentDetails("4242424242424242", "04" , "25" , "123") ;
		paymentpage.FillPaymentDetails(varCardNumber, varMonth , varYear , varCVV) ;
		paymentpage.varifyPaySuccess();
		
		Reporter.log("Test : perfromPayment . Execution completed successfully");
	}
	
}
	


