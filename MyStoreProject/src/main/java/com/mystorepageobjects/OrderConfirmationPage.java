package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.basepage.TestBase;

public class OrderConfirmationPage extends TestBase {

@FindBy (xpath="//*[@id='center_column']/div/p/strong")
WebElement confirmationMessage;

//*[@id="center_column"]/div/p/strong


	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}


public String validateConfirmMessage() {
	String confirmmessage= confirmationMessage.getText();
	
return confirmmessage;

}



















}

