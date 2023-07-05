package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void test_account_Registration()
	{   logger.debug("Application Logs");
		logger.info("*****Resistration Test Started*****");
		try
		{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyaccount();
		logger.info("Clicked on My Account link");
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		RegistrationPage rp=new RegistrationPage(driver);
		
		logger.info("User Started Entering Details");
		
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString());
		rp.setEmail(randomString()+"@gmail.com");
		rp.setTelephone(randomNumeric());
		String pwd="hop"+"@"+randomNumeric();
		rp.setPassword(pwd);
		rp.setConfirmPassword(pwd);
		rp.setPrivacyPolicy();
		
		logger.info("User finished Entering details");
		
		rp.clickContinue();
		
		logger.info("Clicked on continue");
		
		String msg=rp.getConfirmationMsg();
		logger.info("Validating Expected Message");
		Assert.assertEquals(msg,"Your Account Has Been Created!");
		}
		catch(Exception e)
		{   logger.error("test failed");
			Assert.fail();
		}
		logger.info("***Finished Registrtion Test********");
	}

}
