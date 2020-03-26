package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminDshbrdPOMUNI;
import com.training.pom.AdminLoginPOMUNI;
import com.training.pom.HomeUNI;
import com.training.pom.LoginPOM;
import com.training.pom.LoginUNI;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminAddCtgryDBTests066 {
	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
//	private HomeUNI homepg;
//	private LoginUNI loginpg;
	private AdminLoginPOMUNI adlogpg;
	private AdminDshbrdPOMUNI admdshbrd;
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
		//loginPOM = new LoginPOM(driver);
	//	loginpg = new LoginUNI(driver);
		//homepg=new HomeUNI(driver);
		adlogpg=new AdminLoginPOMUNI(driver);
		admdshbrd=new AdminDshbrdPOMUNI(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	
	@Test
	public void addCtgryTest() throws InterruptedException{
		adlogpg.sendUserName("admin");
		adlogpg.sendPassword("admin@123");
		adlogpg.clickLoginBtn();
		admdshbrd.catalog();
		admdshbrd.categories();
		admdshbrd.addNewCtgry();
		admdshbrd.ctgryName("Sports");
		Thread.sleep(2000);
		admdshbrd.ctgryDscrptn("SportsShoes");
		admdshbrd.metaTag("Shoes");
		admdshbrd.ctgryMetaTagDscrptn("SportsShoes");
		screenShot.captureScreenShot("ctgryDtls");
		admdshbrd.save();
		screenShot.captureScreenShot("CtgrysMdfctnSuccess");
		try {
			MariaDBTest.getcategory();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
