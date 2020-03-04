package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePwdUNI {
private WebDriver driver; 
	
	public ChangePwdUNI(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	 
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement cnfmpwd;
	
	public void sendCnfrmPwd(String cpwd) {
		this.cnfmpwd.clear();
		this.cnfmpwd.sendKeys(cpwd);
	}
	
	public void sendPassword(String pwd) {
		this.password.clear(); 
		this.password.sendKeys(pwd); 
	}
	
	
	
}


