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
import com.training.pom.HomeUNI;
import com.training.pom.LoginUNI;
import com.training.pom.UserRegisterUNI;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditInfoUNI005 {

	private WebDriver driver;
	private String baseUrl;
	private LoginUNI loginpg;
	private HomeUNI homepg;
	private UserRegisterUNI rgstrpg;
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
		rgstrpg=new UserRegisterUNI(driver);
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
		homepg.clickUserIcon();
		homepg.clickLogin();
		loginpg.sendUserName("test.accnt@gmail.com");
		loginpg.sendPassword("Morning@123");
		loginpg.clickLoginBtn(); 
		screenShot.captureScreenShot("MyAccountpage");
		//driver.findElement(By.linkText("View your order history"));
		Thread.sleep(2000);
		driver.findElement(By.linkText("Edit Account")).click();
		screenShot.captureScreenShot("AccountInfopageBeforeEdit");
		rgstrpg.sendUserFN("Ushasree");
		rgstrpg.sendUserLN("P");
		rgstrpg.sendUserEmail("ushasree@gmail.com");
		rgstrpg.telePhone("987654321");
		screenShot.captureScreenShot("AccountInfopageAfterEdit");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String msg= driver.findElement(By.className("alert-success")).getText();
		Assert.assertEquals(msg,"Success: Your account has been successfully updated.");
		screenShot.captureScreenShot("PD updated succesfully");
        System.out.println("Your account has been successfully updated.");
	}
}
