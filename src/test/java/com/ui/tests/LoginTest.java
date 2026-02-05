package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest extends TestBase{
	Logger logger = LoggerUtility.getLogger(this.getClass());
	@BeforeMethod(description = "Load the HomePage of the website")
	public void setup() {
		logger.info("Load the HomePage of the website");
		homePage = new HomePage(CHROME,true);
	}
//	@Test(description = "Verify with the valid user is able to login into the application", groups = {"e2e" , "sanity"}, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider" )
//	public void loginTest(User user){
//		
//		assertEquals(homePage.goToLoginPage().userLogin(user.getEmailAddress(), user.getPassword()).getUserName(), "Harry potter");
//	}
	@Test(description = "Verify with the valid user is able to login into the application", groups = {"e2e" , "sanity"}, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider" )
	public void loginTestCSV(User user){
		
		assertEquals(homePage.goToLoginPage().userLogin(user.getEmailAddress(), user.getPassword()).getUserName(), "Harry potter");
	}
	
//	@Test(description = "Verify with the valid user is able to login into the application", groups = {"e2e" , "sanity"}, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider" )
//	public void loginTestExcel(User user){
//		assertEquals(homePage.goToLoginPage().userLogin(user.getEmailAddress(), user.getPassword()).getUserName(), "Harry potter");
//	}
//	
//	
//	@Test(description = "Verify with the valid user is able to login into the application", 
//			groups = {"e2e" , "sanity"}, 
//			dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, 
//			dataProvider = "LoginTestExcelDataProvider", 
//			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginTestRetry(User user){
//		assertEquals(homePage.goToLoginPage().userLogin(user.getEmailAddress(), user.getPassword()).getUserName(), "Harry pott");
//	}
	
}
