package com.atuomation.testcase;


import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.atuomation.util.TestBaseManager;
import com.automation.pages.LoginPage;

public class LoginPageTest extends TestBaseManager {
	
	LoginPage loginpage;
	//WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		
		TestBaseManager.initialization(prop.getProperty("Browser"),prop.getProperty("chromeDriverPath"));
		loginpage = new LoginPage();	
	}
	
	
	
	@Test
	public void LoginTOApplication() {
		String varURL;
		String uName;
		String pass;
		
		varURL  = prop.getProperty("BASE_URL");
		uName = prop.getProperty("Username");
		pass = prop.getProperty("Password");
		
		loginpage.launchApplication(varURL);
		//loginpage.enterCredentials("doninchennai@gmail.com","qweasdzxc@12345");
		loginpage.enterCredentials(uName,pass);
		Reporter.log("Test : LoginTOApplication . Execution completed successfully");
	}
	

	

	
}
