package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.utils.Utils;
import com.tutorilasninja.qa.pages.AccountLoginSuccessPage;
import com.tutorilasninja.qa.pages.AccountSuccessPage;
import com.tutorilasninja.qa.pages.HomePage;
import com.tutorilasninja.qa.pages.LoginPage;

public class Login extends BaseClass {

	WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;
	AccountLoginSuccessPage accountloginsuccesspage;

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
		accountloginsuccesspage = loginpage.LoginWithCredentials(Email, Password);
		Assert.assertEquals(testprop.getProperty("sucmsg"), accountloginsuccesspage.AccLogin());
	}

	@Test(priority = 2)
	public void LoginWithInvalidCredentialsNoofTimes() {
		loginpage.LoginWithCredentials(testprop.getProperty("invalidsecmail"), testprop.getProperty("invalidsecpwd"));
		Assert.assertEquals(testprop.getProperty("Accountlock"), loginpage.Warning());
	}

	@Test(priority = 3)
	public void LoginWithValidMailIDandInvalidPassword() {
		loginpage.LoginWithCredentials(testprop.getProperty("validmail"), testprop.getProperty("invalidsecpwd"));
		Assert.assertEquals(testprop.getProperty("Warninglogin"), loginpage.Warning());
	}

	@Test(priority = 4)
	public void LoginWithInValidMailidandvalidPassword() {
		loginpage.LoginWithCredentials(testprop.getProperty("InvalidMailId"), testprop.getProperty("Validpwd"));
		Assert.assertEquals(testprop.getProperty("Warninglogin"), loginpage.Warning());
	}

	@Test(priority = 5)
	public void LoginWithInvalidCredentials() {
		loginpage.LoginWithCredentials(testprop.getProperty("InvalidMailId"), testprop.getProperty("InvalidPassword"));
		Assert.assertEquals(testprop.getProperty("Warninglogin"), loginpage.Warning());
	}

}
