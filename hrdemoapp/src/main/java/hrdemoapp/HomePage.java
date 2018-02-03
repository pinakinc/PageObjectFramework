package hrdemoapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass{

	@FindBy(how=How.XPATH,using="//*[@id='menu_admin_viewAdminModule']")
	private static WebElement mnuAdmin;
	@FindBy(how=How.XPATH,using="//*[@id='menu_admin_UserManagement']")
	private static WebElement mnuUserManagement;
	@FindBy(how=How.XPATH,using="//*[@id='menu_admin_viewSystemUsers']")
	private static WebElement mnuUsers;

	@FindBy(how=How.XPATH,using="//*[@id='welcome']")
	private static WebElement txtWelcome;

	public HomePage() {
		System.out.println("In HomePage constructor");
		PageFactory.initElements(driver, this);		
	}
	
	public String getWelcomeText(){
		return txtWelcome.getText();
	}
	
	public void clickAdminLink(){
		clickLink(mnuAdmin);
	}
	public void clickUserManagementLink(){
		clickLink(mnuUserManagement);
	}
	public Users clickUsersLink(){
		clickLink(mnuUsers);
		return new Users();
	}

}
