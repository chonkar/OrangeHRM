package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class dashBoard extends TestBase {
	
	@FindBy(xpath="//div[@id='branding']/a[contains(text(),'Welcome')]")
	WebElement UserNameLable;
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement AdminModuleLable;
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement PIMModuleLable;
	
	@FindBy(id="menu_leave_viewLeaveModule")
	WebElement LeaveModuleLable;
	
	@FindBy(xpath="//div[@id='welcome-menu']/ul/li[2]")
	WebElement LogOutButton;
	
	//Initializing the PageObject
	public dashBoard() {
		PageFactory.initElements(driver, this);
	}
	
	//Title of the page
	public String titleOfDashBoardPage() {
		return driver.getTitle();
	}
	
	//click on AdminModuleLine
	public SystemUserPage clickAdminModuleLink() {
		AdminModuleLable.click();
		return new SystemUserPage();
	}
	
	//click on pim Module
	public EmployeeList clickPimModule() {
		PIMModuleLable.click();
		return new EmployeeList();
	}
	
	//click on Leave
	public LeaveListPage clickLeaveModule() {
		LeaveModuleLable.click();
		return new LeaveListPage();
	}
	
	public boolean verifyUsername() {
		return UserNameLable.isDisplayed();
	}
	
	public LoginPage logout() {
		UserNameLable.click();
		LogOutButton.click();
		return new LoginPage();
	}
}
