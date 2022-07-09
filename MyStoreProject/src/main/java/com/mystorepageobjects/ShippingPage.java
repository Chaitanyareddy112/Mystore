package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.basepage.TestBase;

public class ShippingPage extends TestBase {

		@FindBy (id="cgv")
		WebElement terms;
		
		@FindBy (xpath="//*[@id=\"form\"]/p/button/span")
		WebElement proceedToCheckout;


		public ShippingPage() {
			PageFactory.initElements(driver, this);
		}

		public PaymentPage clickOnProceedToCheckOut() {
			terms.click();
		proceedToCheckout.click();
		return new PaymentPage();
		}

		

























}
