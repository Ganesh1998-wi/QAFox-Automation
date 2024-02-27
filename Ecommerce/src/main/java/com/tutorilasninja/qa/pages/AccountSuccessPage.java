package com.tutorilasninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	WebDriver driver;

	@FindBy(xpath = "//div[@id='content']/p[starts-with(text(),'Congratulations!')]")
	private WebElement AccountSuccess;

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String SuccessInformationPage() {
		String BoomAccountCreated = AccountSuccess.getText();
		return BoomAccountCreated;
	}

}
