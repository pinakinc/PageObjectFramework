package hrdemoapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//This the Base class second commited
public class BaseClass {
	static WebDriver driver = null;

	public BaseClass() {
		driver = SingletonDriver.getSigletonInstance();
	}

	public static void initApp() {
		String URL = getProperty("URL");
		navigateToURL(URL);
	}

	public static void navigateToURL(String URL) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to(URL);
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
		elem.sendKeys(text);
	}

	public static void clickButton(WebElement elem) {
		elem.click();
	}

	public static void clickLink(WebElement elem) {
		elem.click();
	}

	public static void selectValue(WebElement elem, String selText) {
		new Select(elem).selectByVisibleText(selText);
	}

}
