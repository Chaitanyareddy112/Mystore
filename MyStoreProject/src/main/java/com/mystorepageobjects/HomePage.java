/**
 * 
 */
package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.basepage.TestBase;

/**
 * @author vcred
 *
 */
public class HomePage extends TestBase {

		@FindBy (xpath="//span[text()='My wishlists']")
		WebElement myWishList;
		
		@FindBy (xpath="//span[text()='Order history and details']")
		WebElement orderHistoryAndDetails;
		
		public HomePage() {
			PageFactory.initElements(driver, this);
		}

		public boolean validateMyWishList() {
		return	myWishList.isDisplayed();
		}
		public boolean validateOrderHistory() {
		return	orderHistoryAndDetails.isDisplayed();
		}

		public String getCurrURL() {
		String homePageUrl=	driver.getCurrentUrl();
		return homePageUrl;
		}



		
































}
