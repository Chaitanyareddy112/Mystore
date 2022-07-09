package com.mystore.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.utility.Extentmanager;


public class TestBase {
	
	//@BeforeSuite(groups= {"Smoke", "Sanity", "Regression"})
	
		
		
	
	public static WebDriver driver;
	public static Properties prop;
	/*Declare ThreadLocal Driver;
	//public static ThreadLocal<RemoteWebDriver> driver= new ThreadLocal<>();
	//public static WebDriver getDriver() {
		//Get Driver from threadLoaclmap
		return driver.get();
	}*/
	@BeforeSuite(groups= {"Smoke", "Sanity", "Regression"})
	public void loadConfig() {
		Extentmanager.setExtent();
		DOMConfigurator.configure("log4j.xml");
	
	//Removed here and kept before suit
		//@BeforeTest(groups= {"Smoke", "Sanity", "Regression"})
		//public void loadConfig() {
			
		
	try {
		prop = new Properties();

		FileInputStream ip= new FileInputStream("C:\\Users\\vcred\\eclipse-workspace\\w3\\MyStoreProject\\Configuration\\Config.properties");
	prop.load(ip);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public static void launchApp(String browserName) {
	WebDriverManager.chromedriver().setup();
	//String browserName=prop.getProperty("browser");
	if (browserName.contains("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//Set Browser to ThreadLocalmap
	//driver.set(new ChromeDriver());
	}
	else if (browserName.contains("Edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	//driver.set(new FirefoxDriver());
	} else if (browserName.contains("IE")) {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	//driver.set(new InternetExplorerDriver());
	}
	//Action.implicitWait(driver, 10);
	//Action.pageLoadTimeOut(driver, 30);
	driver.get(prop.getProperty("url"));
	
	}
	@AfterSuite
	public void aftersuite() {
		Extentmanager.endReport();
		
	}
}
		

