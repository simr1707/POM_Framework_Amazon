package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class SearchPage extends TestBase {

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTextbox;

	@FindBy(xpath = "//select[@id='searchDropdownBox']")
	WebElement searchDropdownBox;

	@FindBy(xpath="//div[@class='sg-col-inner']/div/span[3][contains(text(),'\"Nail polish\"')]")
	WebElement searchedLabel;

	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	public String selectProductDepartment(String selectText) {
		Select s = new Select(searchDropdownBox);
		s.selectByVisibleText(selectText);

		WebElement selectedProductLabel = driver.findElement(By.xpath("//span[contains(text(),'"+selectText+"')]"));
		return selectedProductLabel.getText();
	}
	
	public boolean searchBeautyProduct(String searchproduct) {
		searchTextbox.sendKeys(searchproduct + Keys.ENTER); 
		return searchedLabel.isDisplayed();
	}

}
