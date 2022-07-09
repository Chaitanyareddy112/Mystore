package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.basepage.TestBase;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;
import com.mystorepageobjects.SearchResultPage;

public class SearchResultPageTest extends TestBase {

	IndexPage indexpage;
	LoginPage loginpage;
	SearchResultPage searchresultpage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		launchApp(browser);//was changed for parameters 5:10:29
		indexpage= new IndexPage();
		loginpage= new LoginPage();
		searchresultpage= new SearchResultPage();
	}
	@Test(groups= "Smoke")
	public void productAvailabilityTest() {
	searchresultpage = indexpage.searchProduct("t-shirt");
	boolean result=searchresultpage.isProductAvailable();
		Assert.assertTrue(result); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
