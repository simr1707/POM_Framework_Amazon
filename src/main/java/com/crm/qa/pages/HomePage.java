package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']/span")
	@CacheLookup
	WebElement hoverSignIn;

	@FindBy(xpath = "//div[@id='nav-xshop-container']//a")
	@CacheLookup //to store webelement in cache memory -->Fast performance
	List<WebElement> list;

//	@FindBy(tagName = "a")
//	List<WebElement> allLinks;

	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement loginUsername;

	@FindBy(linkText = "Best Sellers")
	WebElement linkBestSellers;

	@FindBy(linkText = "Deals Store")
	WebElement linkDealsStore;

	@FindBy(linkText = "New Releases")
	WebElement linkNewReleases;

	@FindBy(linkText = "Home")
	WebElement linkHomeKitchen;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTextbox;
	
	@FindBy(xpath="//a[contains(text(),'Start here.')]")
	WebElement startHereLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		String title = driver.getTitle();
		System.out.println("Title;" + title);
		return title;
	}

	public String getUsername() {
		return loginUsername.getText();
	}

	public int sizeOfMenuItem() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
		System.out.println(list.size());
		return list.size();
	}

//	public String listOfMenuItem() {
//		int i;
//		String oneEle = "";
//
//		for (i = 0; i < list.size(); i++) {
//			if (list.size() <= 11) {
//				System.out.println(list.get(i).getText());
//				oneEle = list.get(i).getText();
//			}
//		}
//		return oneEle;
//	}

//	public int allLinksHomePage() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.EXPLICIT_WAIT));
//		wait.until(ExpectedConditions.visibilityOfAllElements(allLinks));
//		
//		System.out.println("Total links on the Wb Page: " + allLinks.size());
//		return allLinks.size();
//	}

	public BestSellersPage clickOnBestSellersLink() {
		linkBestSellers.click();
		System.out.println("linkBestSellers is clicked");
		return new BestSellersPage();
	}

	public DealsStorePage clickOnDealsStoreLink() {

		linkDealsStore.click();
		System.out.println("linkDealsStore is clicked");
		return new DealsStorePage();
	}

	public NewReleasesPage clickOnNewReleasesLink() {

		linkNewReleases.click();
		System.out.println("linkNewReleases is clicked");
		return new NewReleasesPage();
	}

	public HomeKitchenPage clickOnHomeKitcheneLink() {
		linkHomeKitchen.click();
		System.out.println("linkHomeKitchen is clicked");
		return new HomeKitchenPage();
	}

	public SearchPage clickOnSearchTextBox() {
		searchTextbox.click();
		return new SearchPage();
	}
	
	public SignUpPage clickOnSignUpLink() {
		Actions action = new Actions(driver);
		action.moveToElement(hoverSignIn).build().perform();
		startHereLink.click();
		return new SignUpPage();
	}
}
