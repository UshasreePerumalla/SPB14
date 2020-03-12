package com.training.pom;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class GstUsrChkOutUNIPOM {
	private WebDriver driver;

	private WebDriverWait wait; 

	public GstUsrChkOutUNIPOM(WebDriver driver) {
		wait = new WebDriverWait(driver,60);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-option376")
	private WebElement size;

	@FindBy(id="button-cart")
	private WebElement addcart_btn;

	@FindBy(id ="cart")
	private WebElement cart_icon;

	@FindBy(className="fa-share")
	private WebElement chkout_btn;

	@FindBy(linkText="Checkout")
	private WebElement mainchkout_btn;

	@FindBy(xpath="//strong[contains(text(),'View Cart')]")
	private WebElement viewcart_btn;
	
	@FindBy(xpath = ("//input[@value='guest']"))
	private WebElement gstradio_btn;

	@FindBy(xpath="//input[@id='input-payment-firstname']")
	private WebElement firstName;

	@FindBy(id="input-payment-lastname")
	private WebElement lastName;

	@FindBy(id="input-payment-email")
	private WebElement email;

	@FindBy(id="input-payment-telephone")
	private WebElement tphn;

	@FindBy(id="input-payment-address-1")
	private WebElement addr1;

	@FindBy(id="input-payment-city")
	private WebElement cty;

	@FindBy(id="input-payment-postcode")
	private WebElement pstcd;

	@FindBy(id="input-payment-country")
	private WebElement cntry;

	@FindBy(id="input-payment-zone")
	private WebElement state;

	public void slctSize(String prdsz) {
		System.out.println("Available Sizes(value) are : 20(963),30(968)");
		Scanner sc = new Scanner(System.in);
		prdsz=sc.next();
		Select sz= new Select(size);
		sz.selectByValue(prdsz);
	}

	public void Add2Cart() {
		this.addcart_btn.click(); 

	}
	public void yourCart() {
		
		this.cart_icon.click(); 

	}
	public void viewCart() {
		this.viewcart_btn.click();
	
		//Actions act = new Actions(driver);
		//act.moveToElement(viewcart_btn).click().build().perform();
	//((WebElement) driver).click();
	//	act.click(viewcart_btn).build().perform();
	}
	public void cartChkOut() {
		this.chkout_btn.click(); 

	}
	public void viewNdChkOut() {
		this.mainchkout_btn.click(); 

	}
	public void guestChkout() throws InterruptedException {
	//	wait.until(ExpectedConditions.presenceOfElementLocated(this.gstradio_btn));
		Thread.sleep(2000);
		 this.gstradio_btn.click(); 

	}
/*	@DataProvider
	public Object [][] PD(){
		return new Object[][] {
			{"usha","sree","usha@gmail.com","999888998","54631","ecty1","bng","99","1489"}
				};
			}*/
			
		
//	@Test(dataProvider = "PD")
	public void personalDetails(String fn,String ln,String mlid, String tp ,String pcd , String adr1 ,String ct, String ctr, String st)
	{
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		//this.firstName.click();
		this.firstName.clear();
        this.firstName.sendKeys(fn);
        this.lastName.clear();
        this.lastName.sendKeys(ln);
        this.email.clear();
        this.email.sendKeys(mlid);
        this.tphn.clear();
        this.tphn.sendKeys(tp);
        this.pstcd.clear();
        this.pstcd.sendKeys(pcd);
        this.addr1.clear();
        this.addr1.sendKeys(adr1);
        this.cty.clear();
        this.cty.sendKeys(ct);
        Select cnty = new Select(cntry);
        	cnty.selectByValue(ctr);
        	Select rgn = new Select(state);
        		rgn.selectByValue(st);
        	} 
        
	}



