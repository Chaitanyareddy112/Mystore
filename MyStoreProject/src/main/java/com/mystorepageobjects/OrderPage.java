package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.basepage.TestBase;

public class OrderPage extends TestBase {

	@FindBy (xpath="//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy (id="total_price")
	WebElement totalPrice;
	
	@FindBy (xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOutBtn;
	
	
	
	
	
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		String unitPrice1= unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-z0-9]","");
		double finalUnitPrice= Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1= unitPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-z0-9]","");
		double finalTotalPrice= Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	// need to compare these two prices
	
	public LoginPage clickOnCheckOut() {
		proceedToCheckOutBtn.click();
		return new LoginPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
