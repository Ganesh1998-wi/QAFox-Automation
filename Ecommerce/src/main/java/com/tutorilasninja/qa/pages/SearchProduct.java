package com.tutorilasninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {
	WebDriver driver;

	@FindBy(xpath = "//div[contains(@class,'caption')]/h4/a[text()='HP LP3065']")
	private WebElement ValidProduct;

	@FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	private WebElement InvalidProduct;

	public SearchProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String GotTheValidProduct() {
		String validlaptop = ValidProduct.getText();
		return validlaptop;
	}

	public String GotTheInvalidProduct() {
		String InvalidSearch = InvalidProduct.getText();
		return InvalidSearch;
	}
}
