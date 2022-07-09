package com.mystorepageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.basepage.TestBase;

public class AccountCreationPage extends TestBase {
	
	@FindBy (xpath= "//h1[text()='Create an account']")
	WebElement formTitle;
	
	@FindBy (id="id_gender1")
	WebElement titleCheckBox ;
	
	@FindBy (id="customer_firstname")
	WebElement firstName ;
	
	@FindBy (id="customer_lastname")
	WebElement lastTime ;
	
	//@FindBy (id="email")
	//WebElement email ;
	
	@FindBy (id="passwd")
	WebElement password ;
	
	@FindBy (id="days")
	WebElement days ;
	
	@FindBy (id="months")
	WebElement  months;
	
	@FindBy (id="years")
	WebElement  years;
	
	@FindBy (name="firstname")
	WebElement firstName1 ;
	
	@FindBy (name="lastname")
	WebElement lastName1 ;
	
	@FindBy (id="company")
	WebElement company ;
	
	@FindBy (name="address1")
	WebElement address ;
	
	@FindBy (id="city")
	WebElement city ;
	
	@FindBy (id="id_state")
	WebElement state ;
	
	@FindBy (id="postcode")
	WebElement postcode ;
	
	@FindBy (name="id_country")
	WebElement country ;
	
	@FindBy (name="phone_mobile")
	WebElement mobile ;
	
	@FindBy (id="alias")
	WebElement futuremail;
	
	@FindBy (xpath="//*[@id=\"submitAccount\"]/span")
	WebElement submitBtn;
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validateAccountCreatePage() {
	return	formTitle.isDisplayed();
	}
	
	public HomePage personalInformation(String fname, String lname,
			String emaill, String pwd,String day, String months, String year, String first, String last,
			String addresss, String cityy,String fmail,
			String pcode, String pnum) {
		titleCheckBox.click();
		firstName.sendKeys(fname);
		lastTime.sendKeys(lname);
	//	email.sendKeys(emaill);
		password.sendKeys(pwd);
		Select select = new Select(driver.findElement(By.id("days")));
		select.selectByIndex(15);
		Select select1 = new Select(driver.findElement(By.id("months")));
		select.selectByVisibleText("January");
		Select select2 = new Select(driver.findElement(By.id("years")));
		select.selectByIndex(2005);
		//days
		//months
		//years
		firstName1.sendKeys(first);
		lastName1.sendKeys(last);
		address.sendKeys(addresss);
		city.sendKeys(cityy);
		Select select3 = new Select(driver.findElement(By.id("id_state")));
		select.selectByVisibleText("Maine");
		//state.sendKeys(null);
		postcode.sendKeys(pcode);
		Select select4 = new Select(driver.findElement(By.id("id_country")));
		select.selectByVisibleText("United States");
		//country.
		mobile.sendKeys(pnum);
		futuremail.sendKeys(fmail);
		submitBtn.click();
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
