package com.tutorilasninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(xpath = "//div[contains(@class,'form-group')]//input[@id='input-email']")
	private WebElement EmailAddress;

	@FindBy(xpath = "//div[contains(@class,'form-group')]//input[@id='input-password']")
	private WebElement Password;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement LoginButton;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement WarningInformation;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AccountLoginSuccessPage LoginWithCredentials(String email, String password) {
		EmailAddress.sendKeys(email);
		Password.sendKeys(password);
		LoginButton.click();
		return new AccountLoginSuccessPage(driver);
	}

	public String Warning() {
		String Warinfo = WarningInformation.getText();
		return Warinfo;
	}

}
