package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.basepage.TestBase;
import com.mystore.dataprovider.DataProviders;
import com.mystore.utility.Log;
import com.mystorepageobjects.AddressPage;
import com.mystorepageobjects.HomePage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;

public class LoginPageTest extends TestBase{

	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	AddressPage addresspage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		launchApp(browser);
		indexpage= new IndexPage();
		loginpage= new LoginPage();
		homepage= new HomePage();
		addresspage= new AddressPage();
	}
	
	/*@Test(groups="Smoke")
	public void loginTest() {
	loginpage=indexpage.clickOnSignInBtn();
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	String actualURL=	homepage.getCurrURL();
	String expectedURL= "http://automationpractice.com/index.php?controller=my-account";
	Assert.assertEquals(actualURL, expectedURL);
	System.out.println(actualURL);	}*/
	
	
	
	@Test(dataProvider= "credentials", dataProviderClass= DataProviders.class, groups={"Smoke", "Sanity"})
	
	public void loginTest(String uname, String pswd) throws InterruptedException {
		//added String up is for data provider
		Log.startTestCase("loginTest");
		indexpage.clickOnSignInBtn();
		Log.info("user is going to click on signIn");
		//homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//changed below line to take data from excell
		homepage=loginpage.login(uname,pswd);
		Thread.sleep(3000);
		String actualURL=	homepage.getCurrURL();
		String expectedURL= "http://automationpractice.com/index.php?controller=my-account";
		Log.info("verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is sucess");
		Log.endTestCase("loginTest");
System.out.println(actualURL);	}
	
	//@Test public void authentication() {
		
	//}
	
	
	@AfterMethod(groups= {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}
	
}
