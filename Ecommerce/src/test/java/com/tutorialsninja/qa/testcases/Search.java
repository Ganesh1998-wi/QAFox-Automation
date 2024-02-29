package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseClass;
import com.tutorilasninja.qa.pages.HomePage;
import com.tutorilasninja.qa.pages.SearchProduct;

public class Search extends BaseClass {

	WebDriver driver;
	HomePage homepage;
	SearchProduct searchproduct;

	public Search() {
		super();
	}

	@BeforeMethod()
	public void LaunchTheBrowser() {
		driver = LaunchTheDriver("chrome");
		homepage = new HomePage(driver);
	}

	@AfterMethod()
	public void CloseTheBrowser() {
		driver.quit();
	}

	@Test(priority = 1)
	public void SearchWithValidProduct() {
		searchproduct = homepage.ProductSearch(testprop.getProperty("ValidLaptop"));
		Assert.assertEquals(testprop.getProperty("BrandName"), searchproduct.GotTheValidProduct());
	}

	@Test(priority = 2)
	public void SearchWithInValidProduct() {
		searchproduct = homepage.ProductSearch(testprop.getProperty("InvalidBrandName"));
		Assert.assertEquals(testprop.getProperty("InvalidLaptopProduct"), searchproduct.GotTheInvalidProduct());
	}

	@Test(priority = 3)
	public void SearchWithoutIValidProductName() {
		searchproduct = homepage.WithoutProductSearch();
		Assert.assertEquals(testprop.getProperty("InvalidLaptopProduct"), searchproduct.GotTheInvalidProduct());
	}

}
