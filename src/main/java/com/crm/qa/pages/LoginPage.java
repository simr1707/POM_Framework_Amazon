package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - Object Repository

	@FindBy(xpath = "//a[@id='nav-link-accountList']/span")
	WebElement hoverSignIn;

	@FindBy(xpath = "//a[@class='nav-action-button']/span")
	WebElement loginIcon;

	@FindBy(id = "continue")
	WebElement continueBtn;

	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement signinBtn;

	@FindBy(id = "createAccountSubmit")
	WebElement signUpBtn;

	// Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);

		Actions action = new Actions(driver);
		action.moveToElement(hoverSignIn).build().perform();
		loginIcon.click();
	}

	// Actions:
	public String validateLoginPageTitle() {

		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		continueBtn.click();
		password.sendKeys(pwd);
		signinBtn.click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.EXPLICIT_WAIT));
//		wait.until(ExpectedConditions.elementToBeClickable(signinBtn)).click();

		return new HomePage();
	}

	public boolean validateSignUpBtn() {
		return signUpBtn.isEnabled();
	}
}
