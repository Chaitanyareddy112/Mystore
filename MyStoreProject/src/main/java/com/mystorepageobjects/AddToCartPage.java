package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.basepage.TestBase;

public class AddToCartPage extends TestBase {

	@FindBy (id="quantity_wanted")
	WebElement quantity;
	
	@FindBy (name="group_1")
	WebElement size;
	
	@FindBy (xpath="//span[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy (xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")//*[@id=\"layer_cart\"]//h2/i
	WebElement addToCartMessage;//*[@id="layer_cart"]/div[1]/div[1]/h2
	//*[@id="layer_cart"]/div[1]/div[1]/h2
	@FindBy (xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")//*[@id="layer_cart"]/div[1]/div[2]/div[4]/a/span
	WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterQuantity(String quantity1) {
		quantity.sendKeys(quantity1);
	}
	
	public void selectSize(String sizee) {
		//size.selectByVisibleText(sizee);
		Action.selectByVisibleText(sizee, size);
		
	}
	public void clickOnAddToCart() {
	addToCartBtn.click();
	}
	
	public boolean validateAddtoCart() {
		return addToCartMessage.isDisplayed();
		
	}
	public void text() {
		String text=addToCartMessage.getText();
		System.out.println(text);
	}
	public OrderPage clickOnCheckOut() {
		proceedToCheckOutBtn.click();
		return new OrderPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
