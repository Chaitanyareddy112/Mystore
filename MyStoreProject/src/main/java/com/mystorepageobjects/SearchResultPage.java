package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.basepage.TestBase;

public class SearchResultPage extends TestBase{
	
	@FindBy (xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement productResult;
	
	@FindBy (xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement clickOnImage;
	//*[@id="center_column"]/ul/li/div/div[1]/div/a[1]/img
	//*[@id=\"center_coloumn\"]//img
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() {
		return	productResult.isDisplayed();
		}
	
	public AddToCartPage clickOnProduct() {
	clickOnImage.click();
	return new AddToCartPage();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
