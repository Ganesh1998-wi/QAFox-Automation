package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.utils.Utils;
import com.tutorilasninja.qa.pages.HomePage;
import com.tutorilasninja.qa.pages.LoginPage;
import com.tutorilasninja.qa.pages.MyAccountPage;

public class Login extends BaseClass {

	WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;
	MyAccountPage myaccountpage;

	public Login() {
		super();
	}

	@BeforeMethod()
	public void LaunchTheBrowser() {
		driver = LaunchTheDriver("chrome");
		homepage = new HomePage(driver);
		loginpage = homepage.NavigateToLogin();
	}

	@DataProvider(name = "Credentials")
	public Object[][] SupplyDetails() {
		Object[][] data = Utils.ReadDataFromExcel("Login");
		return data;
	}

	@AfterMethod()
	public void CloseTheBrowser() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "Credentials")
	public void LoginWithValidCredentials(String Email, String Password) {
		loginpage.LoginWithCredentials(Email, Password);
		System.out.println(myaccountpage.AccountLoginSuccess());
		// Assert.assertEquals(myaccountpage.AccountLoginSuccess(),testprop.getProperty("sucmsg"));

	}

}
