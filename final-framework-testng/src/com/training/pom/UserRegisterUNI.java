package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class UserRegisterUNI {
	private WebDriver driver; 
	
	public UserRegisterUNI(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstName; 
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement userEmail; 
	
	@FindBy(id="input-telephone")
	private WebElement userPhn; 
	
	@FindBy(id="input-address-1")
	private WebElement userAddr1; 
	
	@FindBy(id="input-city")
	private WebElement city;
	
	@FindBy(id="input-postcode")
	private WebElement pin;
	
	@FindBy(id="input-country")
	private WebElement country;
	
	@FindBy(id="input-zone")
	private WebElement state;
	
	@FindBy(id="input-password")
	private WebElement pwd;
	
	@FindBy(id="input-confirm")
	private WebElement cnfpwd;
	
	@FindBy(name="agree")
	private WebElement chkbx;
	
	@FindBy(className="btn-primary")
	private WebElement cnt_btn;
	
	public void sendUserFN(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
	public void sendUserLN(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	
	
	public void sendUserEmail(String userEmail) {
		this.userEmail.clear();
		this.userEmail.sendKeys(userEmail);
	}
	
	public void telePhone(String phn) {
		this.userPhn.clear(); 
		this.userPhn.sendKeys(phn); 
	}
	public void address(String addr) {
		this.userAddr1.clear(); 
		this.userAddr1.sendKeys(addr); 
	}
	public void city(String cty) {
		this.city.clear(); 
		this.city.sendKeys(cty); 
	}
	public void postCode(String pcd) {
		this.pin.clear(); 
		this.pin.sendKeys(pcd); 
	}
	public void slctCountry(String cntr) {
	Select cnty = new Select(country);
	cnty.selectByValue(cntr);
	}
	public void slctState(String st) {
		Select rgn = new Select(state);
		rgn.selectByValue(st);
	}
	
	public void sendpwd(String pwd) {
		this.pwd.clear(); 
		this.pwd.sendKeys(pwd);
		
	}
	public void sendCnfpwd(String cpwd) {
		this.cnfpwd.clear(); 
		this.cnfpwd.sendKeys(cpwd);
		
	}
	public void chkBox() {
		this.chkbx.click(); 
		
	}
	public void continueBtn() {
		this.cnt_btn.click(); 
	}
	
	
}
