package hrdemoapp;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass {
	@FindBy(how = How.XPATH, using = "//*[@id='txtUsername']")
	private static WebElement txtUserName;
	@FindBy(how = How.XPATH, using = "//*[@id='txtPassword']")
	private static WebElement txtPassword;
	@FindBy(how = How.XPATH, using = "//*[@id='btnLogin']")
	private static WebElement btnLogin;

	public Login(WebDriver driver) {
		BaseClass.driver = driver;
		PageFactory.initElements(driver, this);
		logger = Logger.getLogger(Login.class.getName());
	}

	public void enterUserName(String userName) {
		logger.info("Entering username");
		enterText(txtUserName, userName);
	}

	public void enterPassword(String password) {
		logger.info("Entering password");
		enterText(txtPassword, password);
	}

	public HomePage clickLogin() {
		logger.info("Clicking Login Button");
		clickButton(btnLogin);
		return new HomePage(driver);
	}

}
