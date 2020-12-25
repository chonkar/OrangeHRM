package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SystemUserPage extends TestBase {
	
	@FindBy(xpath="//a[@class='toggle tiptip']")
	WebElement SystemUserTitle;
	
	@FindBy(id="btnAdd")
	WebElement AddButton;
	
	public SystemUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySystemUserLable() {
		return SystemUserTitle.isDisplayed();
	}
	
	public AddUser clickAddButton() {
		 AddButton.click();
		 return new AddUser();
	}

}
