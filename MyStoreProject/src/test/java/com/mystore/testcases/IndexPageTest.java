package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.basepage.TestBase;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;

public class IndexPageTest extends TestBase {
	
	IndexPage indexpage;
	LoginPage loginpage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		launchApp(browser);
		indexpage= new IndexPage();
		loginpage= new LoginPage();
	}
	@Test(groups="Smoke")
	public void verifyLogo() {
		boolean flag= indexpage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(groups="Smoke")
	public void verifyTitle() {
		String title= indexpage.getMyStoreTitle();
		Assert.assertEquals(title, "My Store");
	}
	@Test
	public void signIn() {
		loginpage=indexpage.clickOnSignInBtn();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
