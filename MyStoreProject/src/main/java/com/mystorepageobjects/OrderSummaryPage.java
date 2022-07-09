package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.basepage.TestBase;

public class OrderSummaryPage extends TestBase {

		@FindBy (xpath="//*[@id=\"cart_navigation\"]/button/span")
		WebElement confirmMyOrderBtn;
		
	
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage confirmMyOrder() {
		confirmMyOrderBtn.click();
		return new OrderConfirmationPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
