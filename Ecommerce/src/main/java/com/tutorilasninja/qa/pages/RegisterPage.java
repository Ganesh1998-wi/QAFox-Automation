package com.tutorilasninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(@class,'col-sm-10')]/input[@name='firstname']")
	private WebElement FirstName;
	
	@FindBy(xpath = "//div[contains(@class,'col-sm-10')]/input[@name='lastname']")
	private WebElement LastName;
	
	@FindBy(xpath = "//div[contains(@class,'col-sm-10')]/input[@name='email']")
	private WebElement Email;
	
	@FindBy(xpath = "//div[contains(@class,'col-sm-10')]/input[@name='telephone']")
	private WebElement Telephone;
	
	@FindBy(xpath = "//div[contains(@class,'col-sm-10')]/input[@name='password']")
	private WebElement Password;
	
	@FindBy(xpath = "//div[contains(@class,'col-sm-10')]/input[@name='confirm']")
	private WebElement ConfirmPassword;
	
	@FindBy(xpath = "//div[contains(@class,'col-sm-10')]/label/input[@value=1]")
	private WebElement NewsLetter;
	

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
