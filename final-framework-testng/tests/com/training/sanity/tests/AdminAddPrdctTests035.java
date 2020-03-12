package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminDshbrdPOMUNI;
import com.training.pom.AdminLoginPOMUNI;
import com.training.pom.GstUsrChkOutUNIPOM;
import com.training.pom.HomeUNI;
import com.training.pom.LoginUNI;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminAddPrdctTests035 {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOMUNI admlog;
	private AdminDshbrdPOMUNI dshbrd;
	//private GstUsrChkOutUNIPOM gstusr;
	//private LoginUNI loginpg;
	//private HomeUNI homepg;
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
	//	loginpg = new LoginUNI(driver); 
	//  homepg=new HomeUNI(driver);
	//	gstusr=new GstUsrChkOutUNIPOM(driver);
		admlog = new AdminLoginPOMUNI(driver);
		dshbrd = new AdminDshbrdPOMUNI(driver);
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
	public void validLoginTest() throws InterruptedException {
		admlog.sendUserName("admin");
		admlog.sendPassword("admin@123");
		admlog.clickLoginBtn();
		dshbrd.catalog();
		Thread.sleep(2000);
		dshbrd.Products();
		screenShot.captureScreenShot("Product list");
		dshbrd.addNewPrd();
		dshbrd.prdName("Blazer Girls(7-8)");
		dshbrd.metaTag("Blazer fo Girls");
		screenShot.captureScreenShot("Add Productpage");
		dshbrd.dataTab();
		dshbrd.enterModel("BLG-112");
		dshbrd.enterPrice("3000");
		dshbrd.enterQnty("100");
		screenShot.captureScreenShot("Datatab");
		dshbrd.linksTab();
		dshbrd.slctCategory("553");
		screenShot.captureScreenShot("Linkstab");
		dshbrd.discountTab();
		dshbrd.rwrdPointsTab("20");
		screenShot.captureScreenShot("RewardpointsTab");
		dshbrd.save();
		String msg=driver.findElement(By.className("alert-success")).getText();
		System.out.println(msg);
		//Assert.assertEquals(msg, "Success: You have modified products!");
		screenShot.captureScreenShot("prdctMdfcnSuccess");
			}
}
