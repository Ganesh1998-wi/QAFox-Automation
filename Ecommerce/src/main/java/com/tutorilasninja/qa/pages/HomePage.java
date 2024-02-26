package com.tutorilasninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//li[@class='dropdown']/a[@title='My Account']")
	private WebElement MyAccountButton;
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu')]//li/a[text()='Login']")
	private WebElement LoginButton;
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu')]//li/a[text()='Register']")
	private WebElement RegisterButton;
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginPage NavigateToLogin() {
		MyAccountButton.click();
		LoginButton.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage NavigateToRegistration() {
		MyAccountButton.click();
		LoginButton.click();
		return new RegisterPage(driver);

	}
}
