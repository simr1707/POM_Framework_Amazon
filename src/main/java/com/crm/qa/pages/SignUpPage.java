package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	
	@FindBy(id="ap_customer_name")
	WebElement fullName;
	
	@FindBy(id="ap_email")
	WebElement mobileOrEmail;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="ap_password_check")
	WebElement passwordAgain;
	
	@FindBy(id="continue")
	WebElement btnContinue;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public String getSignUpPageTitle() {
		return driver.getTitle();
	}
	
	public void fillSignUpForm(String fullname, String moboremail, String pass, String passagain) {
		
		fullName.sendKeys(fullname);
		mobileOrEmail.sendKeys(moboremail);
		password.sendKeys(pass);
		passwordAgain.sendKeys(passagain);
		btnContinue.click();
	}
}
