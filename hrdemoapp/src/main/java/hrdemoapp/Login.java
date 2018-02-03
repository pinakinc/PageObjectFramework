package hrdemoapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass{
	@FindBy(how=How.XPATH,using="//*[@id='txtUsername']")
	private static WebElement txtUserName;
	@FindBy(how=How.XPATH,using="//*[@id='txtPassword']")
	private static WebElement txtPassword;
	@FindBy(how=How.XPATH,using="//*[@id='btnLogin']")
	private static WebElement btnLogin;
	
	public Login(){
		PageFactory.initElements(driver, this);
	}
	public void enterUserName(String userName){
		enterText(txtUserName,userName);
	}
	
	public void enterPassword(String password){
		enterText(txtPassword,password);
	}
	
	public HomePage clickLogin(){
		clickButton(btnLogin);
		return new HomePage();
	}

}
