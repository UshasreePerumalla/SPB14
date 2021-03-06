package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

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

public class AdminAddPrdctNSrchViewTests065 {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOMUNI admlog;
	private AdminDshbrdPOMUNI dshbrd;
	//private GstUsrChkOutUNIPOM gstusr;
	//private LoginUNI loginpg;
	//private HomeUNI homepg;
	private static Properties properties;
	private ScreenShot screenShot;
	private Object object;

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
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/
	@Test
	public void validLoginTest() throws InterruptedException {
		admlog.sendUserName("admin");
		admlog.sendPassword("admin@123");
		admlog.clickLoginBtn();
		dshbrd.catalog();
		Thread.sleep(2000);
		dshbrd.Products();
	//	screenShot.captureScreenShot("Product list");
		dshbrd.addNewPrd();
		dshbrd.prdName("Blazer Boys(3-4)");
		dshbrd.metaTag("Blazer for Boys");
	//	screenShot.captureScreenShot("Add Productpage");
		dshbrd.dataTab();
		dshbrd.enterModel("BLG-1111");
		dshbrd.enterPrice("2000");
		dshbrd.enterQnty("300");
	//	screenShot.captureScreenShot("Datatab");
		dshbrd.linksTab();
		dshbrd.slctCategory("369");
	//	screenShot.captureScreenShot("Linkstab");
		dshbrd.discountTab();
		dshbrd.rwrdPointsTab("50");
	//	screenShot.captureScreenShot("RewardpointsTab");
		dshbrd.save();
		String msg=driver.findElement(By.className("alert-success")).getText();
		System.out.println(msg);
		Assert.assertTrue(msg.contains("Success: You have modified products!"));
		screenShot.captureScreenShot("AddPrdctSuccess");
		String parentHandle = driver.getWindowHandle(); 
		System.out.println(parentHandle);
		driver.findElement(By.className("fa-home")).click();
		driver.findElement(By.linkText("Uniform Store")).click();
		Set<String> winids= driver.getWindowHandles();
		System.out.println(winids);
			for(String usrwinid:winids) {
					driver.switchTo().window(usrwinid);
					System.out.println(driver.getTitle());
					System.out.println(driver.getCurrentUrl());
					if(driver.getTitle().equals("Uniform Store"))
					{
					//	driver.manage().deleteAllCookies();
						break;
						//System.out.println("userpage is launched");
						//driver.findElement(By.linkText("REGULAR T-SHIRTS (YELLOW)")).isDisplayed();
						//screenShot.captureScreenShot("PrdAddedIsDsplyd");
					}
					System.out.println("userpage is launched");
					driver.findElement(By.linkText("REGULAR T-SHIRTS (YELLOW)")).isDisplayed();
					screenShot.captureScreenShot("PrdAddedIsDsplyd");
		}
		
		//driver.findElement(By.className("fa-sign-out")).click();
	/*	admlog.sendUserName("admin");
		admlog.sendPassword("admin@123");
		admlog.clickLoginBtn();
		dshbrd.catalog();
		Thread.sleep(2000);
		dshbrd.Products();
		driver.findElement(By.id("input-name")).sendKeys("Blazer Boys(8-9)");
		driver.findElement(By.className("fa-search")).click();
		screenShot.captureScreenShot("AddedPrdctIsDsplyd");*/
		
					}
}
