package hrdemoapp;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Users extends BaseClass {
	@FindBy(how = How.XPATH, using = "//*[@id='searchSystemUser_userName']")
	private static WebElement txtUserNameSearch;
	@FindBy(how = How.XPATH, using = "//*[@name='btnAdd']")
	private static WebElement btnAdd;
	@FindBy(how = How.XPATH, using = "//*[@id='searchSystemUser_userName']")
	private static WebElement txtSearch;
	@FindBy(how = How.XPATH, using = "//*[@id='searchBtn']")
	private static WebElement btnSearch;
	@FindBy(how = How.XPATH, using = "//*[@id='resultTable']/tbody/tr[1]/td[2]/a")
	private static WebElement lnkResults;

	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_userType']")
	private static WebElement drpUserType;
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_employeeName_empName']")
	private static WebElement txtEmpName;
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_userName']")
	private static WebElement txtUserName;
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_status']")
	private static WebElement drpUserStatus;
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_password']")
	private static WebElement txtUserPassword;
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_confirmPassword']")
	private static WebElement txtConfirmUserPassword;
	@FindBy(how = How.XPATH, using = "//*[@name='btnSave']")
	private static WebElement btnSave;
	private String duserNameText;

	public Users() {
		System.out.println("In Users constructor");
		PageFactory.initElements(driver, this);
		logger = Logger.getLogger(Users.class.getName());
	}

	public Boolean userNameDisplayed() {
		logger.info("Returning username displayed information");
		return txtUserNameSearch.isDisplayed();
	}

	public void clickAdd() {
		logger.info("Clicking Add button");
		clickButton(btnAdd);
	}

	public void setTxtSearch(String searchText) {
		logger.info("Entering search text " + searchText);
		enterText(txtSearch, searchText);
	}

	public void selectUserType(String selectText) {
		logger.info("Selecting value: " + selectText);
		selectValue(drpUserType, selectText);
	}

	public void enterEmpName(String empNameText) {
		logger.info("Entering Employee Name");
		enterText(txtEmpName, empNameText);
	}

	public void enterUserName(String userNameText) {
		logger.info("Entering user name");
		enterText(txtUserName, userNameText);
		duserNameText = userNameText;
	}

	public void writeToFile(File file) {
		logger.info("Writing to file");
		Utilities.write(duserNameText, file);
	}

	public void selectUserStatus(String selectText) {
		logger.info("Selecting user status");
		selectValue(drpUserStatus, selectText);
	}

	public void clickSrchBtn() {
		logger.info("Clicking search button");
		clickButton(btnSearch);
	}

	public void enterPassword(String passwordText) {
		logger.info("Entering password text");
		enterText(txtUserPassword, passwordText);
	}

	public void enterConfPassword(String confPasswordText) {
		logger.info("Entering confirm password text");
		enterText(txtConfirmUserPassword, confPasswordText);
	}

	public void clickSave() {
		logger.info("Clicking save button");
		clickButton(btnSave);
	}

	public EditUser clickUserLink() {
		logger.info("Clicking users link");
		clickButton(lnkResults);
		return new EditUser();
	}

}
