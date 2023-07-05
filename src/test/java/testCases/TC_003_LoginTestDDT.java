package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginTestDDT extends BaseClass {
	
    
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void login(String username,String pwd,String exp )
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
		lp.enterEmail(username);
		lp.enterPassword(pwd);
		lp.clickLogin();
		boolean targetpage=lp.isMyAccountPageExists();
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				Assert.assertTrue(true);
				lp.clickLogout();
			}
		
		else
		{
			Assert.assertTrue(false);
		}
		}
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				Assert.assertTrue(false);
			}
		
		else
		{
			Assert.assertTrue(true);
		}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
			
		}
		
		
	}
	
}
