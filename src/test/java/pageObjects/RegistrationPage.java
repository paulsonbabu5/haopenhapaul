package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	//elements
	@FindBy(id="input-firstname")
	WebElement txtFirstName;
	@FindBy(name = "lastname")
	WebElement txtLasttname;

	@FindBy(name = "email")
	WebElement txtEmail;

	@FindBy(name = "telephone")
	WebElement txtTelephone;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "confirm")
	WebElement txtConfirmPassword;
    
	@FindBy(name="agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//div[@id='content']//h1")
    WebElement msgConfirm;
	
	//Actions
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		 txtLasttname.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	public void setPrivacyPolicy()
	{
		chkdPolicy.click();
	}
	public void clickContinue()
	{
		btnSubmit.click();
	}
	public String getConfirmationMsg()
	{   try
	{
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(100));
		String mg=mywait.until(ExpectedConditions.visibilityOf(msgConfirm)).getText();
		return (mg);
		
	}
	catch(Exception e)
	{
		return (e.getMessage());
	}
		
	}
	
	

}
