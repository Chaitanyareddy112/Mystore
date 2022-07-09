package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.basepage.TestBase;
import com.mystorepageobjects.AddToCartPage;
import com.mystorepageobjects.HomePage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;
import com.mystorepageobjects.OrderPage;
import com.mystorepageobjects.SearchResultPage;

public class OrderPageTest extends TestBase {
	LoginPage loginpage;
	IndexPage indexpage;
	HomePage homepage;
	AddToCartPage addtocartpage;
	SearchResultPage searchresultpage;
	OrderPage orderpage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		launchApp(browser);//was changed for parameters 5:10:29
		loginpage= new LoginPage();
		indexpage= new IndexPage();
		searchresultpage= new SearchResultPage();
		homepage= new HomePage();
		addtocartpage= new AddToCartPage();
		orderpage= new OrderPage();
	}
		@Test(groups= "Regression")
		public void OrderPage() throws InterruptedException {
			loginpage=	indexpage.clickOnSignInBtn();
			homepage=	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
				searchresultpage=indexpage.searchProduct("t-shirt");
				addtocartpage=searchresultpage.clickOnProduct();
				addtocartpage.enterQuantity("2");
				Thread.sleep(5000);
				//addtocartpage.selectSize("M");
				addtocartpage.clickOnAddToCart();
				Thread.sleep(5000);
				boolean result =addtocartpage.validateAddtoCart();
				Thread.sleep(1000);
				Assert.assertTrue(result);
				addtocartpage.text();
				orderpage=addtocartpage.clickOnCheckOut();
				double unitPrice1=orderpage.getUnitPrice();
				Double totalprice=orderpage.getTotalPrice();
				Thread.sleep(10000);

				Double totalexpectedprice=(unitPrice1)+2;
				System.out.println(unitPrice1);
				System.out.println(totalprice);
				System.out.println(totalexpectedprice);

				Assert.assertEquals(totalprice, totalexpectedprice);
			
			}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
		public void tearDown() {
			driver.quit();
		}
	
	
	
	
	}
