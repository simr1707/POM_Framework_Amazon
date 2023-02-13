package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("*********************Starting login testcases**********************");
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		log.debug("*********************Starting First Login Test**********************");
		String loginPageTitle = loginPage.validateLoginPageTitle();
		System.out.println(loginPageTitle);
		log.info("LoginPage title: "+loginPageTitle);
		Assert.assertEquals(loginPageTitle, "Amazon Sign In");
	}

	@Test(priority = 2, dependsOnMethods = "loginPageTitleTest")
	public void loginPageTest() {
		log.info("*********************Starting Second Login Test**********************");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 3, dependsOnMethods = "loginPageTitleTest")
	public void verifyCreateAccountBtnEnabled() {
		log.info("*********************Starting Third Login Test**********************");
		boolean signUpBtn = loginPage.validateSignUpBtn();
		System.out.println(signUpBtn);
		Assert.assertEquals(signUpBtn, true);
	}

	@AfterMethod
	public void tearDown() {
		log.debug("*********************Ending login testcases**********************");
		driver.quit();
	}

}
