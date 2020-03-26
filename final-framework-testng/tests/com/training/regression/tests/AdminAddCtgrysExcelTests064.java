package com.training.regression.tests;

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

public class AdminAddCtgrysExcelTests064 {
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

/*	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) {
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot(userName);

	}*/

	
	@Test(dataProvider = "CtgrysData", dataProviderClass = LoginDataProviders.class)
	public void loginExcelTest(String fieldsName,String ctgryName, String dscrptn,String megaTagTitle,String megaTagDscrptn) throws InterruptedException {
		adlogpg.sendUserName("admin");
		adlogpg.sendPassword("admin@123");
		adlogpg.clickLoginBtn();
		admdshbrd.catalog();
		admdshbrd.categories();
	//	for(int i=0;i<4;i++) {
		admdshbrd.addNewCtgry();
		admdshbrd.ctgryName(ctgryName);
		Thread.sleep(2000);
		admdshbrd.ctgryDscrptn(dscrptn);
		admdshbrd.metaTag(megaTagTitle);
		admdshbrd.ctgryMetaTagDscrptn(megaTagDscrptn);
		screenShot.captureScreenShot(fieldsName);
		//}
		admdshbrd.save();
		screenShot.captureScreenShot("CtgrysMdfctnSuccess");
}
}
