package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.HomeUNI;
import com.training.pom.LoginPOM;
import com.training.pom.UserRegisterUNI;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegstTestsUNI {

	private WebDriver driver;
	private String baseUrl;
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
		homepg = new HomeUNI(driver); 
		rgstrpg=new UserRegisterUNI(driver);
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
	public void validRegisterTest() {
		homepg.clickUserIcon();
		homepg.clickRegister();
		rgstrpg.sendUserFN("test");
		rgstrpg.sendUserLN("accnt");
		rgstrpg.sendUserEmail("test.accnt@gmail.com");
		rgstrpg.address("ecity");
		rgstrpg.city("bng");
		rgstrpg.postCode("523000");
		rgstrpg.slctCountry("99");
		rgstrpg.slctState("1489");
		rgstrpg.telePhone("987654320");
		rgstrpg.sendpwd("Morning@123");
		rgstrpg.sendCnfpwd("Morning@123");
		rgstrpg.chkBox();
		rgstrpg.continueBtn();
		screenShot.captureScreenShot("Rgstrtnpg");
		System.out.println("Registration Successfull");
	}
}
