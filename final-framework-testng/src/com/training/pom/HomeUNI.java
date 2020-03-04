package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomeUNI {
	private WebDriver driver; 
	
	public HomeUNI(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="fa-user")
	private WebElement user_icon; 
	
	@FindBy(linkText="Register")
	private WebElement Register; 
	
	public void clickUserIcon() {
		this.user_icon.click(); 
		
	}
	public void clickRegister() {
		this.Register.click(); 
		
	}
}
