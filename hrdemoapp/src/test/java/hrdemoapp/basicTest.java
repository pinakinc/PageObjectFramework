package hrdemoapp;

import java.io.IOException;

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

	// static File fileName;

	public basicTest() {
		super();
	}

	@BeforeClass
	public static void openBrowser() throws IOException {
		// extentTest = extentReport.startTest("Create Users");

		deleteOutput();

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
	public static void openUsers() throws InterruptedException {

		homePage.clickAdminLink();
		homePage.clickUserManagementLink();
		usersPage = homePage.clickUsersLink();
		txtuserNameexists = usersPage.userNameDisplayed();
		Assert.assertTrue(txtuserNameexists);
		// extentTest.log(LogStatus.PASS, "UserName displayed");
	}

	@Test(dependsOnMethods = "openUsers", dataProvider = "Users", dataProviderClass = UserDataProvider.class)
	public static void addUsers(String userType, String empName,
			String userName, String password, String confPassword)
			throws InterruptedException {
		usersPage.clickAdd();
		usersPage.selectUserType(userType);
		usersPage.enterEmpName(empName);
		usersPage.enterUserName(userName + Utilities.getTimeStamp());
		usersPage.enterPassword(password);
		usersPage.enterConfPassword(confPassword);

		usersPage.clickSave();
		Thread.sleep(3000);
		// wdWait.until(ExpectedConditions.visibilityOf((driver.findElement(By
		// .xpath("//*[contains(text(),'Successfully')]")))));
		// System.out.println("Hurrah");

		usersPage.writeToFile(fileName);
		txtuserNameexists = usersPage.userNameDisplayed();
		Assert.assertTrue(txtuserNameexists);
		// extentTest.log(LogStatus.PASS, "UserName verified");

	}

}
