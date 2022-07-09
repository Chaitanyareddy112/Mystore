package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.basepage.TestBase;

public class PaymentPage extends TestBase {

	@FindBy (xpath="//a[contains(text(),'Pay by bank wire')]")
	WebElement bankWireMethod;
	 
	@FindBy (xpath= "//a[contains(text(),'Pay by check')]")
	WebElement payByCheckMethod;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage clickOnPaymentMethod() {
		bankWireMethod.click();
		return new OrderSummaryPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
