package hrdemoapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//This the Base class second commited
public class BaseClass {
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	// public ITestResult iTestResult;
	static WebDriver driver = null;
	public static Logger logger = null;
	protected static WebDriverWait wdWait = null;
	protected static File fileName = new File("src/main/resources/users.txt");

	// {
	// extentReport = new ExtentReports(
	// "C:\\Users\\Bhagyashree\\Desktop\\extentreport.html");
	// }
	@BeforeTest
	public static void loadLog4J() {
		String log4Jpath = System.getProperty("user.dir") + "/log4j.properties";
		PropertyConfigurator.configure(log4Jpath);
	}

	public BaseClass() {
		// driver = SingletonDriver.getSigletonInstance();
	}

	public static void deleteOutput() throws IOException {
		if (fileName.exists()) {
			fileName.delete();
		}
		fileName.createNewFile();
	}

	public static void populateDriver() {

		driver = SingletonDriver.getSigletonInstance();
		wdWait = new WebDriverWait(driver, 60);
	}

	public static void initApp() {
		populateDriver();
		String URL = getProperty("URL");
		navigateToURL(URL);
	}

	public static Login navigateToURL(String URL) {
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to(URL);

		return new Login(driver);
	}

	static File file = new File(
			".//src/main/resources/config/config.properties");

	public static String getProperty(String propKey) {
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(propKey);
	}

	public static void enterText(WebElement elem, String text) {
		wdWait.until(ExpectedConditions.visibilityOf(elem));
		elem.sendKeys(text);
	}

	public static void clickButton(WebElement elem) {
		wdWait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();
	}

	public static void clickLink(WebElement elem) throws InterruptedException {
		wdWait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();

	}

	public static void selectValue(WebElement elem, String selText) {
		wdWait.until(ExpectedConditions.visibilityOf(elem));
		new Select(elem).selectByVisibleText(selText);
	}

	// @AfterSuite
	// public static void cleanUp() {
	// extentReport.flush();
	// extentReport.close();
	// }

}
