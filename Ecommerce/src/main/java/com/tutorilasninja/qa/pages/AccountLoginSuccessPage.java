package com.tutorilasninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLoginSuccessPage {
	WebDriver driver;

	@FindBy(xpath = "//ul[@class='list-unstyled']/li/a[text()='Edit your account information']")
	private WebElement AccountInformation;

	public AccountLoginSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String AccLogin() {
		String successinfo = AccountInformation.getText();
		return successinfo;

	}
}
