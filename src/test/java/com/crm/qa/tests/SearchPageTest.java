package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SearchPage;

public class SearchPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;

	public SearchPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.debug("*********************Starting homepage testcases**********************");
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchPage = homePage.clickOnSearchTextBox();
	}
	
	@DataProvider
	public Object[][] dataProvider(){
		return new Object[][] {
			new Object[] {"Nail polish"}
		};
	}

	@Test(priority = 1)
	public void selectOneProduct() {
		log.info("*********************Starting First Searchpage Test**********************");
		String displayedProductName = searchPage.selectProductDepartment("Amazon Devices");
		Assert.assertEquals(displayedProductName, "Amazon Devices");
	}
	
	@Test(priority = 2, dataProvider = "dataProvider")
	public void searchBeautyProduct(String s) {
		log.info("*********************Starting Second Searchpage Test**********************");
		//searchPage.searchBeautyProduct(s);
		Assert.assertTrue(searchPage.searchBeautyProduct(s), "SearchedLabel is not matched");
	}

	
	@AfterMethod
	public void tearDown() {
		log.debug("*********************Ending homepage testcases**********************");
		driver.quit();
	}
}
