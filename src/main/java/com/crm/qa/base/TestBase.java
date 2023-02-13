package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String filePath = System.getProperty("user.dir");
	public static String browserName;
	public static EventFiringWebDriver e_Driver;
	public static WebEventListener eventListener;
	public Logger log = Logger.getLogger(TestBase.class);

	public TestBase() {

		try {
			FileInputStream input = new FileInputStream(
					filePath + "/src/main/java/com/crm/qa/config/config.properties");
			prop = new Properties();
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("internet explorer")) {
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("browser not found.");
		}

		e_Driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_Driver.register(eventListener);
		driver = e_Driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		log.info("**********************Entering url****************");

	}
}
