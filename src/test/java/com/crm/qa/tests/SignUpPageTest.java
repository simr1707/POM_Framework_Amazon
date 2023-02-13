package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.util.TestUtil;

public class SignUpPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	SignUpPage signupPage;
	String sheetName = "SignupData";
	TestUtil testUtil;

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.debug("*********************Starting signuppage testcases**********************");
		initialization();
		homePage = new HomePage();
		signupPage = homePage.clickOnSignUpLink();
	}

	@DataProvider
	public Object[][] getAmazonTestData() {
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1)
	public void validateSignupPageTitle() {
		log.info("*********************Starting First Signup Test**********************");
		String actTitle = signupPage.getSignUpPageTitle();
		Assert.assertEquals(actTitle, "Amazon Registration");
	}

	@Test(priority = 2, dataProvider = "getAmazonTestData")
	public void validateCreateSignUpData(String name, String moboremail, String pw, String pwagain) {
		log.info("*********************Starting Second Signup Test**********************");
		System.out.println("Yourname" + name + " " + moboremail + " " + pw + " " + pwagain);
		signupPage.fillSignUpForm(name, moboremail, pw, pwagain);
	}

	@AfterMethod
	public void tearDown() {
		log.debug("*********************Ending signuppage testcases**********************");
		driver.quit();
	}
}
