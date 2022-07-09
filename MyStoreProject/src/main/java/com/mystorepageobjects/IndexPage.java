package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.basepage.TestBase;

public class IndexPage extends TestBase {

	@FindBy (linkText="Sign in")
	WebElement signInBtn;
	
	//@FindBy ()
	
	@FindBy (xpath="//img[@class='logo img-responsive']")
	WebElement pageLogo;
	
	@FindBy (xpath="//input[@class='search_query form-control ac_input']")
	WebElement searchBox;
	
	@FindBy (name="submit_search")
	WebElement searchBtn;
	
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	public LoginPage clickOnSignInBtn() {
	signInBtn.click();
	return new LoginPage();}
	
		//Action.click(driver, signInBtn);
		//can use like this also
	
	public boolean validateLogo() {
		return pageLogo.isDisplayed();
		//or
		//return Action.isDisplayed(driver, pageLogo);
	}
	public String getMyStoreTitle() {
	String title=	driver.getTitle();
	return title;
	}
public SearchResultPage searchProduct (String productName) {
	searchBox.click();
	searchBox.sendKeys(productName);
	searchBtn.click();
	return new SearchResultPage();
	
}
	
	
	
	
	
	
	
	

}
 