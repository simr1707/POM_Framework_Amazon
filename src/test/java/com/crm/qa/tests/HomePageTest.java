package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BestSellersPage;
import com.crm.qa.pages.DealsStorePage;
import com.crm.qa.pages.HomeKitchenPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewReleasesPage;
import com.crm.qa.pages.SearchPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	BestSellersPage bestSellersPage;
	DealsStorePage dealsStorePage;
	NewReleasesPage newReleasesPage;
	HomeKitchenPage homeKitchenPage;
	TestUtil testUtil;
	SearchPage searchPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.debug("*********************Starting homepage testcases**********************");
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

//		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void varifyHomePageTitle() {
		log.info("*********************Starting First Homepage Test**********************");
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
	}

	@Test(priority = 2)
	public void verifySignedInUsername() {
		log.info("*********************Starting second Homepage Test**********************");
		String signedInUser = homePage.getUsername();
		Assert.assertEquals(signedInUser, "Hello, Ami");
	}

	@Test(priority = 3, dependsOnMethods = "verifySignedInUsername")
	public void varifySizeOfMenuItem() {
		log.info("*********************Starting third Homepage Test**********************");
		int menuItemSize = homePage.sizeOfMenuItem();

		Assert.assertEquals(menuItemSize, 31);
	}

//	@Test(priority = 3)
//	public void varifyListOfMenuItem() {
//		
//		String[] expecList = {"Best Sellers","Deals Store","New Releases","Customer Service","Prime","Gift Ideas","Electronics","Home","Books","Coupons","Kindle Books","Sell"};
//		String expecString = "";
//		int i;
//			
//		String actString = homePage.listOfMenuItem();
//			
//		for(i=0; i<expecList.length; i++) {
//			System.out.println(expecList[i]);
//			expecString = expecList[i];
//			Assert.assertEquals(actString, expecString);
//		}
//	}

//	@Test(priority = 3)
//	public void verifyAllLinksOfHomePage() {
//		int actSize = homePage.allLinksHomePage();
//		
//		Assert.assertEquals(actSize, 368);
//	}

	@Test(priority = 4, dependsOnMethods = "verifySignedInUsername")
	public void verifyLinkOfBestSellersPage() {
		log.info("*********************Starting Fourth Homepage Test**********************");
		bestSellersPage = homePage.clickOnBestSellersLink();
	}

//	@Test(priority = 4, dependsOnMethods = "verifySignedInUsername")
//	public void verifyLinkOfDealsStorePage() {
//		dealsStorePage = homePage.clickOnDealsStoreLink();
//	}

	@Test(priority = 5, dependsOnMethods = "verifySignedInUsername")
	public void verifyLinkOfNewReleasesPage() {
		log.info("*********************Starting Fifth Homepage Test**********************");
		newReleasesPage = homePage.clickOnNewReleasesLink();
	}

	@Test(priority = 6, dependsOnMethods = "verifySignedInUsername")
	public void verifyLinkOfHomeKitchenPage() {
		log.info("*********************Starting Sixth Homepage Test**********************");
		homeKitchenPage = homePage.clickOnHomeKitcheneLink();
	}

	@Test(priority = 7, dependsOnMethods = "verifySignedInUsername")
	public void verifyLinkOfSearchPage() {
		log.info("*********************Starting Seventh Homepage Test**********************");
		searchPage = homePage.clickOnSearchTextBox();
	}

	@AfterMethod
	public void tearDown() {
		log.debug("*********************Ending login testcases**********************");
		driver.quit();
	}
}
