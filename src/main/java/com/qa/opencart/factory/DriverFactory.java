package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	
	
	public WebDriver driver;
	public Properties prop;

	/**
	 * This method is used to initialize the webdriver on the basis of given browser
	 * name. This method will take care of local and remote execution
	 * 
	 * @param browserName
	 * @return
	 */
	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser name is : " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("please pass the right browser name : " + browserName);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get(prop.getProperty("url"));

		return driver;

	}

	/**
	 * This method is used to initialize the properties on the basis of given
	 * environment: QA/DEV/Stage/PROD
	 * 
	 * @return this returns prop
	 */
	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}

