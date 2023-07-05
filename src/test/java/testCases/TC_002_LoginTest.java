package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
   
	@Test(groups= {"Sanity","Master"})
	public void login()
	{   
		try
		{
		logger.info("**********LoginTest Started***********");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
	    hp.clickLogin();
	    logger.info("Clicked on login");
	    
		LoginPage lp=new LoginPage(driver);
		logger.info("Started entering user details");
		lp.enterEmail(rb.getString("username"));
		lp.enterPassword(rb.getString("password"));
		logger.info("Finished entering user details");
		lp.clickLogin();
		logger.info("User clicked on login");
		
		logger.info("Started Validation");
		Assert.assertEquals(lp.isMyAccountPageExists(), true);
		logger.info("Test Passed");
		}
		catch(Exception e)
		{
			Assert.fail();
			logger.error(e.getMessage());
			logger.info("Test Failed");
		}
		
		
	}
	
}
