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

	@FindBy(xpath = "//input[contains(@type,'checkbox')]")
	private WebElement PrivacyPolicy;

	@FindBy(xpath = "//input[contains(@value,'Continue')]")
	private WebElement Continue;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement ExistingMailWarning;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement PrivacyPolicyMsg;

	@FindBy(xpath = "//div[@class='col-sm-10']//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement FirstNameWar;

	@FindBy(xpath = "//div[@class='col-sm-10']//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement LastNameWar;

	@FindBy(xpath = "//div[@class='col-sm-10']//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement EmailWar;

	@FindBy(xpath = "//div[@class='col-sm-10']//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement PhonenumberWar;

	@FindBy(xpath = "//div[@class='col-sm-10']//div[text()='Password must be between 4 and 20 characters!']")
	private WebElement PasswordWar;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AccountSuccessPage RegisterWithDetails(String firstname, String lastname, String email, String phone,
			String password, String cpassword) {
		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		Email.sendKeys(email);
		Telephone.sendKeys(phone);
		Password.sendKeys(password);
		ConfirmPassword.sendKeys(cpassword);
		NewsLetter.click();
		PrivacyPolicy.click();
		Continue.click();
		return new AccountSuccessPage(driver);
	}

	public String EmailWarning() {
		String EmailWarinfo = ExistingMailWarning.getText();
		return EmailWarinfo;
	}

	public void Errors() {
		NewsLetter.click();
		Continue.click();
	}

	public String FirstNameError() {
		String firsterror = FirstNameWar.getText();
		return firsterror;
	}

	public String LastNameError() {
		String lasterror = LastNameWar.getText();
		return lasterror;

	}

	public String EmailError() {
		String emailerror = EmailWar.getText();
		return emailerror;
	}

	public String PhonenumberError() {
		String Phoneerr = PhonenumberWar.getText();
		return Phoneerr;
	}

	public String PasswordError() {
		String passerror = PasswordWar.getText();
		return passerror;
	}

	public String PrivacyError() {
		String privacyerror = PrivacyPolicyMsg.getText();
		return privacyerror;
	}
}
