package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory or Object Repository
	@FindBy(id="txtUsername")
	WebElement userName;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement submitButton;
	
	@FindBy(id="forgotPasswordLink")
	WebElement forgetPasswordLink;
	
	@FindBy(xpath="//div[@id='divLogo']/img")
	WebElement OorangeHRMLogo;
	
	public LoginPage() {
		
		//How to initialize pageFactory: PageFactory.initElements(driver,this)
		//this: means current class elements
		
		PageFactory.initElements(driver, this);	
	
	}
	
	public String validateLoginPageTitle() {
		// This method should return title
		 return driver.getTitle();
			}

	public boolean validateCRMLogo() {
		return OorangeHRMLogo.isDisplayed();
	}
	
	public dashBoard Login(String UN, String Pwd) {
		userName.sendKeys(UN);
		password.sendKeys(Pwd);
		submitButton.click();
		return new dashBoard();
		
	}
	
		
	}
