package hrdemoapp;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
	// private WebDriver driver;
	@FindBy(how = How.XPATH, using = "//*[@id='menu_admin_viewAdminModule']")
	private static WebElement mnuAdmin;
	@FindBy(how = How.XPATH, using = "//*[@id='menu_admin_UserManagement']")
	private static WebElement mnuUserManagement;
	@FindBy(how = How.XPATH, using = "//*[@id='menu_admin_viewSystemUsers']")
	private static WebElement mnuUsers;
	@FindBy(how = How.XPATH, using = "//*[@id='welcome']")
	private static WebElement lnkWelcome;
	@FindBy(how = How.XPATH, using = "//*[text()='Logout']")
	private static WebElement lnkLogout;

	@FindBy(how = How.XPATH, using = "//*[@id='welcome']")
	private static WebElement txtWelcome;

	public HomePage(WebDriver driver) {
		System.out.println("In HomePage constructor");
		BaseClass.driver = driver;
		PageFactory.initElements(driver, this);
		logger = Logger.getLogger(HomePage.class.getName());
		System.out.println("After InitElement HomePage");
	}

	public String getWelcomeText() {
		// System.out.println("getting welcome text");
		logger.info("Getting welcome text");
		return txtWelcome.getText();

	}

	public void clickAdminLink() throws InterruptedException {
		// System.out.println("Clicking Admin link");
		logger.info("Clicking Admin link");
		clickLink(mnuAdmin);
	}

	public void clickUserManagementLink() throws InterruptedException {
		logger.info("Clicking User Management link");
		clickLink(mnuUserManagement);
	}

	public Users clickUsersLink() throws InterruptedException {
		logger.info("Clicking Users link");
		clickLink(mnuUsers);
		return new Users();
	}

	public static void clickLogout() throws InterruptedException {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		clickLink(lnkWelcome);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickLink(lnkLogout);
	}

}
