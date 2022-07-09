package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.basepage.TestBase;
import com.mystorepageobjects.HomePage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	IndexPage indexpage;
	HomePage homepage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		launchApp(browser);
		loginpage= new LoginPage();
		indexpage= new IndexPage();
		homepage= new HomePage();
	}
	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}
	@Test(groups = "Smoke")
	public void wishListTest() {
		loginpage=indexpage.clickOnSignInBtn();
	homepage=	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean valid=homepage.validateMyWishList();
		Assert.assertTrue(valid);
		System.out.println(valid);
	}
	
	@Test(groups="Smoke")
	public void orderDetails() throws Throwable{
		loginpage=indexpage.clickOnSignInBtn();
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
	Thread.sleep(3000);
	boolean validorder=	homepage.validateOrderHistory();
	Assert.assertTrue(validorder);
	assertEquals(validorder, validorder);
	//System.out.println(Assert);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
