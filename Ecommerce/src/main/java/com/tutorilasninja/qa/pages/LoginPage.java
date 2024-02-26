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

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
