package hrdemoapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Users extends BaseClass{
	@FindBy(how=How.XPATH,using="//*[@id='searchSystemUser_userName']")
	private static WebElement txtUserNameSearch;
	@FindBy(how=How.XPATH,using="//*[@name='btnAdd']")
	private static WebElement btnAdd;
	@FindBy(how=How.XPATH,using="//*[@id='systemUser_userType']")
	private static WebElement drpUserType;
	@FindBy(how=How.XPATH,using="//*[@id='systemUser_employeeName_empName']")
	private static WebElement txtEmpName;
	@FindBy(how=How.XPATH,using="//*[@id='systemUser_userName']")
	private static WebElement txtUserName;
	@FindBy(how=How.XPATH,using="//*[@id='systemUser_status']")
	private static WebElement drpUserStatus;
	@FindBy(how=How.XPATH,using="//*[@id='systemUser_password']")
	private static WebElement txtUserPassword;
	@FindBy(how=How.XPATH,using="//*[@id='systemUser_confirmPassword']")
	private static WebElement txtConfirmUserPassword;
	@FindBy(how=How.XPATH,using="//*[@name='btnSave']")
	private static WebElement btnSave;

	
	

	
	public Users() {
		System.out.println("In Users constructor");
		PageFactory.initElements(driver, this);		
	}

	public Boolean userNameDisplayed(){
		return txtUserNameSearch.isDisplayed();
	}
	public void clickAdd(){
		clickButton(btnAdd);
	}
	public void selectUserType(String selectText){
		selectValue(drpUserType,selectText);
	}
	public void enterEmpName(String empNameText){
		enterText(txtEmpName,empNameText);
	}
	public void enterUserName(String userNameText){
		enterText(txtUserName,userNameText);
	}
	public void selectUserStatus(String selectText){
		selectValue(drpUserStatus,selectText);
	}
	public void enterPassword(String passwordText){
		enterText(txtUserPassword,passwordText);
	}
	public void enterConfPassword(String confPasswordText){
		enterText(txtConfirmUserPassword,confPasswordText);
	}
	public void clickSave(){
		clickButton(btnSave);
	}

}
