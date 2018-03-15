package hrdemoapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver extends BaseClass {

	private SingletonDriver() {
	}

	public static WebDriver getSigletonInstance() {
		if (null == driver) {
			System.setProperty("webdriver.chrome.driver",
					".//src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
}
