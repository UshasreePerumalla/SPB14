package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AdminDshbrdPOMUNI {
	private WebDriver driver; 

	public AdminDshbrdPOMUNI(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "fa-tags")
	private WebElement ctlg; 

	@FindBy(linkText="Products")
	private WebElement products;

	@FindBy(className="fa-plus")
	private WebElement plus_icon; 
	
	@FindBy(id ="input-name1")
     private WebElement prdname;
	@FindBy(id="input-meta-title1")
	private WebElement inptmetatag;

	@FindBy(linkText = "Data")
	private WebElement datatab;


	@FindBy(id = "input-model")
	private WebElement mdl;

	@FindBy(id = "input-price")
	private WebElement prc;

	@FindBy(id = "input-quantity")
	private WebElement qty;

	@FindBy(linkText = "Links")
	private WebElement links;

	@FindBy(id="input-category")
	private WebElement ctgry;
	
	@FindBy(linkText = "Blazers(3-8)")
	private WebElement slctctgry;

	@FindBy(linkText="Discount")
	private WebElement dscnt;

	@FindBy(xpath="//button[@onclick='addDiscount();']")
	private WebElement adddscnt_icon;
	
	

	@FindBy(linkText="Reward Points")
	private WebElement rwrdpnts;


	@FindBy(id="input-points")
	private WebElement points;

	@FindBy(className="fa-save")
	private WebElement save_icon;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Quantity']")
	private WebElement dsqty;
	

	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Price']")
	private WebElement dsprc;
	
	@FindBy(xpath="//td[5]//div[1]//span[1]")
	private WebElement strtdt_icon;

	@FindBy(xpath=("//i[@class='fa fa-calendar'][3]"))
	private WebElement endt_icon;
	
	public void catalog() {
		this.ctlg.click();
	}
	
	public void Products() {
		this.products.click();
	}
	public void addNewPrd() {
		this.plus_icon.click(); 
	}
	public void prdName(String name) {
		this.prdname.clear();
		this.prdname.sendKeys(name);
	}
	
	public void metaTag(String title) {
		this.inptmetatag.clear();
		this.inptmetatag.sendKeys(title);
	}
	public void dataTab() {
		this.datatab.click();
	}
	public void enterModel(String mdl) {
		this.mdl.clear();
		this.mdl.sendKeys(mdl);
	}
	public void enterPrice(String amt) {
		this.prc.clear();
		this.prc.sendKeys(amt);
	}
	public void enterQnty(String qnty) {
		this.qty.clear();
		this.qty.sendKeys(qnty);
	}
	public void linksTab() {
		this.links.click();
	}
	public void slctCategory(String value) {
		this.ctgry.click();
		this.slctctgry.click();
	}
	public void discountTab() {
		this.dscnt.click();
		this.adddscnt_icon.click();
		this.dsqty.clear();
		this.dsqty.sendKeys("5");
		this.dsprc.clear();
		this.dsprc.sendKeys("200");
		this.strtdt_icon.click();
		this.strtdt_icon.click();
		//this.endt_icon.click();
	}
	public void rwrdPointsTab(String pnts) {
		this.rwrdpnts.click();
		this.points.clear();
		this.points.sendKeys(pnts);
	}
	public void save() {
		this.save_icon.click();
	}
}
