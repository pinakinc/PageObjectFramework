package hrdemoapp;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class basicTest extends BaseClass {
	static int i=0;
	static Login login = new Login();
	static HomePage homePage = null;
	static Users usersPage = null;
	static Boolean txtuserNameexists = false;
	public basicTest(){
		super();
	}

	@BeforeClass
	public static void openBrowser(){
		initApp();
	}
	
	@Test
	public static void loginToApplication(){
		String homepageText = null;
		login.enterUserName(getProperty("USERNAME"));
		login.enterPassword(getProperty("PASSWORD"));
		homePage = login.clickLogin();
		homepageText = homePage.getWelcomeText();
		Assert.assertEquals(homepageText,getProperty("WELCOMEMSG"),getProperty("ERRORMSG"));
	
	}
	
	@Test(dependsOnMethods="loginToApplication")
	public static void openUsers(){
		
		homePage.clickAdminLink();
		homePage.clickUserManagementLink();
		usersPage = homePage.clickUsersLink();
		txtuserNameexists = usersPage.userNameDisplayed();
		Assert.assertTrue(txtuserNameexists);
		
	}
	
	@Test(dependsOnMethods="openUsers",dataProvider="Users",dataProviderClass=UserDataProvider.class)
	public static void addUsers(String userType,String empName,String userName,String password,String confPassword){
		usersPage.clickAdd();
		usersPage.selectUserType(userType);
		usersPage.enterEmpName(empName);
		usersPage.enterUserName(userName+Utilities.getTimeStamp());
		usersPage.enterPassword(password);
		usersPage.enterConfPassword(confPassword);
		usersPage.clickSave();
		txtuserNameexists = usersPage.userNameDisplayed();
		Assert.assertTrue(txtuserNameexists);
		
		
	}
	
	

}
