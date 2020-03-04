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
import com.training.pom.ChangePwdUNI;
import com.training.pom.HomeUNI;
import com.training.pom.LoginUNI;
import com.training.pom.UserRegisterUNI;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangePwdTests006 {

	private WebDriver driver;
	private String baseUrl;
	private LoginUNI loginpg;
	private HomeUNI homepg;
	private ChangePwdUNI chngpwd;
	//private UserRegisterUNI rgstrpg;
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
		chngpwd=new ChangePwdUNI(driver);
		//rgstrpg=new UserRegisterUNI(driver);
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
		loginpg.sendUserName("ushasree@gmail.com");
		loginpg.sendPassword("Uniform@123");
		loginpg.clickLoginBtn(); 
		//screenShot.captureScreenShot("MyAccountpage");
		//driver.findElement(By.linkText("View your order history"));
		//Thread.sleep(2000);
		driver.findElement(By.linkText("Change your password")).click();
		chngpwd.sendPassword("Uniform@123");
		chngpwd.sendCnfrmPwd("Uniform@123");
		screenShot.captureScreenShot("Change PWD page");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String msg= driver.findElement(By.className("alert-success")).getText();
		System.out.println(msg);
		Assert.assertEquals(msg,"Success: Your password has been successfully updated.");
		screenShot.captureScreenShot("PWD updated succesfully");
        System.out.println("password updated successfully");
	}
}
