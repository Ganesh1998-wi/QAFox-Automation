package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.utils.Utils;
import com.tutorilasninja.qa.pages.AccountSuccessPage;
import com.tutorilasninja.qa.pages.HomePage;
import com.tutorilasninja.qa.pages.RegisterPage;

public class Register extends BaseClass {

	WebDriver driver;
	HomePage homepage;
	RegisterPage registerpage;
	AccountSuccessPage accountsuccesspage;

	public Register() {
		super();
	}

	@BeforeMethod()
	public void LaunchTheBrowser() {
		driver = LaunchTheDriver("chrome");
		homepage = new HomePage(driver);
		registerpage = homepage.NavigateToRegistration();
	}

	@AfterMethod()
	public void CloseTheBrowser() {
		driver.quit();
	}

	@Test(priority = 1)
	public void RegisterWithNewUser() {
		accountsuccesspage = registerpage.RegisterWithDetails(testprop.getProperty("firstname"),
				testprop.getProperty("lastname"), Utils.DateToAppend(), testprop.getProperty("phoneno"),
				testprop.getProperty("password"), testprop.getProperty("confirmpwd"));
		Assert.assertEquals(testprop.getProperty("AccountCreated"), accountsuccesspage.SuccessInformationPage());
	}

	@Test(priority = 2)
	public void RegisterWithExistingEmail() {
		registerpage.RegisterWithDetails(testprop.getProperty("firstname"), testprop.getProperty("lastname"),
				testprop.getProperty("validmail"), testprop.getProperty("phoneno"), testprop.getProperty("password"),
				testprop.getProperty("confirmpwd"));
		Assert.assertEquals(testprop.getProperty("ExistingMail"), registerpage.EmailWarning());
	}

	@Test(priority = 3)
	public void RegistrationWithWarnings() {
		registerpage.Errors();
		Assert.assertEquals(testprop.getProperty("FirstnameWarning"), registerpage.FirstNameError());
		Assert.assertEquals(testprop.getProperty("LastnameWarning"), registerpage.LastNameError());
		Assert.assertEquals(testprop.getProperty("EmailWarning"), registerpage.EmailError());
		Assert.assertEquals(testprop.getProperty("PhoneWarning"), registerpage.PhonenumberError());
		Assert.assertEquals(testprop.getProperty("PasswordWarning"), registerpage.PasswordError());
		Assert.assertEquals(testprop.getProperty("PrivacyWarning"), registerpage.PrivacyError());

	}
}
