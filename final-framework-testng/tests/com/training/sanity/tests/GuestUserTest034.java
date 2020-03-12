package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.GstUsrChkOutUNIPOM;
import com.training.pom.HomeUNI;
import com.training.pom.LoginUNI;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class GuestUserTest034 {

	private WebDriver driver;
	private String baseUrl;
	private GstUsrChkOutUNIPOM gstusr;
	//private LoginUNI loginpg;
	//private HomeUNI homepg;
	private static Properties properties;
	private ScreenShot screenShot;
	private WebDriverWait wait;

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
		
		gstusr=new GstUsrChkOutUNIPOM(driver);
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
		driver.findElement(By.xpath("//img[@title='REGULAR T-SHIRTS (Rust)']")).click();
		gstusr.slctSize("963");
		Thread.sleep(2000);
		gstusr.Add2Cart();
		screenShot.captureScreenShot("GuestPrdctAdded2Cart");
		gstusr.yourCart();
		Thread.sleep(2000);
		gstusr.viewCart();
		//gstusr.cartChkOut();
		gstusr.viewNdChkOut();
		gstusr.guestChkout();
	//	driver.findElement(By.xpath("//input[@value='guest']")).click();
		screenShot.captureScreenShot("Guest Chkout");
		driver.findElement(By.id("button-account")).click();
		gstusr.personalDetails("usha","sree","usha@gmail.com","999888998","54631","ecty1","bng","99","1489");
		driver.findElement(By.xpath("//input[@checked='checked']")).isSelected();
		System.out.println("Checkbox is selected");
		screenShot.captureScreenShot("gstusrDetails");
		driver.findElement(By.id("button-guest")).click();
		driver.findElement(By.name("comment")).sendKeys("awaiting for product to be shipped");
		driver.findElement(By.id("button-shipping-method")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.id("button-payment-method")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("button-confirm")).click();
		screenShot.captureScreenShot("OrderConfirmation");
		System.out.println("Guestuser order placed successfully");
			}
}
