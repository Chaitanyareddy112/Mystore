package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.basepage.TestBase;
import com.mystorepageobjects.AddToCartPage;
import com.mystorepageobjects.AddressPage;
import com.mystorepageobjects.HomePage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;
import com.mystorepageobjects.OrderConfirmationPage;
import com.mystorepageobjects.OrderPage;
import com.mystorepageobjects.OrderSummaryPage;
import com.mystorepageobjects.PaymentPage;
import com.mystorepageobjects.SearchResultPage;

public class EndToEndTest extends TestBase {
	
	LoginPage loginpage;
	IndexPage indexpage;
	HomePage homepage;
	AddToCartPage addtocartpage;
	SearchResultPage searchresultpage;
	OrderPage orderpage;
	OrderSummaryPage 		ordersummarypage;
	AddressPage addresspage;
	com.mystorepageobjects.ShippingPage shippingpage;
	     PaymentPage paymentpage;
	     OrderConfirmationPage orderconfirmationpage;
	
	     @Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		launchApp(browser);
		loginpage= new LoginPage();
		indexpage= new IndexPage();
		searchresultpage= new SearchResultPage();
		homepage= new HomePage();
		addtocartpage= new AddToCartPage();
		orderpage= new OrderPage();
		ordersummarypage=new OrderSummaryPage();
		addresspage=new AddressPage();
		shippingpage= new com.mystorepageobjects.ShippingPage();
		paymentpage =new PaymentPage();
		ordersummarypage= new OrderSummaryPage();
		orderconfirmationpage= new OrderConfirmationPage();
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
				loginpage=orderpage.clickOnCheckOut();
				//addresspage=loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
				shippingpage=addresspage.clickOnCheckOut();
					//ShippingPage.checkTheTerms();
				paymentpage=shippingpage.clickOnProceedToCheckOut();
				ordersummarypage=paymentpage.clickOnPaymentMethod();
				orderconfirmationpage=ordersummarypage.confirmMyOrder();
					String actualmessage=orderconfirmationpage.validateConfirmMessage();
					//System.out.println(actualmessage);
					String Expectedmessage= "Your order on My Store is complete.";
					Assert.assertEquals(actualmessage, Expectedmessage);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

	
	
	
}
