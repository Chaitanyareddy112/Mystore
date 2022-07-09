package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.basepage.TestBase;

public class AddressPage extends TestBase{

	@FindBy (xpath="//*[@id=\"center_column\"]/form/p/button/span")
	WebElement proceedToCheckOut;
	
	
	
	
	
	
	
	
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ShippingPage clickOnCheckOut() {
		proceedToCheckOut.click();
		return new ShippingPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
