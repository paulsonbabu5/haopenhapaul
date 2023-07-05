package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
  
	@FindBy(id="input-email")
	WebElement txtEmail;
	@FindBy(id="input-password")
	WebElement txtPwd;
	@FindBy(xpath="//input[@type='submit']")
	WebElement btLogin;
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	@FindBy(linkText="Logout")
	WebElement lnkLogout;
	
	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void enterPassword(String password)
	{
		txtPwd.sendKeys(password);
	}
	public void clickLogin()
	{
		btLogin.click();
	}
	public boolean isMyAccountPageExists()
	{
		try
		{
			return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
}  
