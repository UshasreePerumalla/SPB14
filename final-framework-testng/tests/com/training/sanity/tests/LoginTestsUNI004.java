package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomeUNI;
import com.training.pom.LoginUNI;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTestsUNI004 {

	private WebDriver driver;
	private String baseUrl;
	private LoginUNI loginpg;
	private HomeUNI homepg;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginpg = new LoginUNI(driver); 
		homepg=new HomeUNI(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		homepg.clickUserIcon();
		homepg.clickLogin();
		loginpg.sendUserName("test1@gmail.com");
		loginpg.sendPassword("Uniform@123");
		loginpg.clickLoginBtn(); 
		driver.findElement(By.linkText("View your order history")).click();
		screenShot.captureScreenShot("OrderHistory");
		driver.findElement(By.className("fa-eye")).click();
		screenShot.captureScreenShot("OrderDetails");
		driver.findElement(By.className("clearfix")).click();
		System.out.println("Order details displayed");
			}
}
