package hrdemoapp;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class basicTest extends BaseClass {
	static int i = 0;
	static Login login = new Login(driver);
	static HomePage homePage = null;
	static Users usersPage = null;
	static Boolean txtuserNameexists = false;
	static File fileName;

	public basicTest() {
		super();
	}

	@BeforeClass
	public static void openBrowser() {
		// extentTest = extentReport.startTest("Create Users");

		fileName = new File("C:\\Users\\Bhagyashree\\Desktop\\users.txt");

		initApp();
	}

	@AfterClass
	public static void closeBrowser() {
		// extentReport.endTest(extentTest);
		driver.quit();
		driver = null;
		// HomePage.clickLogout();
	}

	@Test
	public static void loginToApplication() {
		String homepageText = null;
		login.enterUserName(getProperty("USERNAME"));
		login.enterPassword(getProperty("PASSWORD"));
		homePage = login.clickLogin();
		homepageText = homePage.getWelcomeText();
		// System.out.println(homepageText);
		System.out.println(getProperty("WELCOMEMSG"));
		Assert.assertEquals(homepageText, getProperty("WELCOMEMSG"),
				getProperty("ERRORMSG"));
		// extentTest.log(LogStatus.PASS, "Welcome message verified");
	}

	@Test(dependsOnMethods = "loginToApplication")
	public static void openUsers() {

		homePage.clickAdminLink();
		homePage.clickUserManagementLink();
		usersPage = homePage.clickUsersLink();
		txtuserNameexists = usersPage.userNameDisplayed();
		Assert.assertTrue(txtuserNameexists);
		// extentTest.log(LogStatus.PASS, "UserName displayed");
	}

	@Test(dependsOnMethods = "openUsers", dataProvider = "Users", dataProviderClass = UserDataProvider.class)
	public static void addUsers(String userType, String empName,
			String userName, String password, String confPassword) {
		usersPage.clickAdd();
		usersPage.selectUserType(userType);
		usersPage.enterEmpName(empName);
		usersPage.enterUserName(userName + Utilities.getTimeStamp());
		usersPage.enterPassword(password);
		usersPage.enterConfPassword(confPassword);
		usersPage.clickSave();
		usersPage.writeToFile(fileName);
		txtuserNameexists = usersPage.userNameDisplayed();
		Assert.assertTrue(txtuserNameexists);
		// extentTest.log(LogStatus.PASS, "UserName verified");

	}

}
