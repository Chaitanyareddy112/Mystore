package com.mystore.testcases;

import org.testng.Assert;
 import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.basepage.TestBase;
import com.mystorepageobjects.AccountCreationPage;
import com.mystorepageobjects.HomePage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;

public class AccountCreatePageTest extends TestBase {

	LoginPage loginpage;
	IndexPage indexpage;
	AccountCreationPage accountcreationpage;
	
	@Parameters("browser")	
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		launchApp(browser);
		loginpage= new LoginPage();
		indexpage= new IndexPage();
		accountcreationpage= new AccountCreationPage();
	}
	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}
	

	//public boolean validateAccountCreatePage() {
	//return	formTitle.isDisplayed();
	//}
	@Test(groups= "Sanity")
	public void verifyCreateAccountPageTest() throws InterruptedException {
	loginpage=	indexpage.clickOnSignInBtn();
	accountcreationpage=loginpage.createNewAccount("asdf11@gmail.com");
	
	Thread.sleep(10000);
	boolean result=accountcreationpage.validateAccountCreatePage();
	Assert.assertTrue(result);
	if (result==false) {
	System.out.println("Account creation found is" +" "+  result);
	}else { 
		System.out.println("fasle");
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
