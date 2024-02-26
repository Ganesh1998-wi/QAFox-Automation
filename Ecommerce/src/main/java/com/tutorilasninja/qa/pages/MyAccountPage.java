package com.tutorilasninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;

	@FindBy(xpath = "//ul[contains(@class,'list-unstyled')]/li/a[text()='Edit your account information']")
	private WebElement AccountInformation;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String AccountLoginSuccess() {
		String successInfo = AccountInformation.getText();
		return successInfo;
	}

}