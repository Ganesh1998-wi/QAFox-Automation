package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utils;

public class BaseClass {
	WebDriver driver;
	Properties prop;
	Properties testprop;

	public BaseClass() {
		prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\properties\\config.properties");
		try {
			FileInputStream propinputfile = new FileInputStream(propfile);
			prop.load(propinputfile);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		testprop = new Properties();
		File proptestfile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		try {
			FileInputStream propinputtestfile = new FileInputStream(proptestfile);
			testprop.load(propinputtestfile);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public WebDriver LaunchTheDriver(String BrowserName) {
		if (BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("D:\\Automation\\chrome-win64\\chrome-win64\\chrome.exe");
			driver = new ChromeDriver(options);
		} else if (BrowserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGELOAD_TIME_OUT));
		return driver;

	}

}
