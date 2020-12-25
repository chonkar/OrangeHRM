package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class AddUser extends TestBase {
	

	@FindBy (id="systemUser_userType")
	WebElement UserRole;
	
	@FindBy(id="systemUser_employeeName_empName")
	WebElement SystemEmployeeName;
	
	@FindBy(xpath="//div[@class='ac_results']/ul/li[contains(@class,'ac_even ac_over')]")
	WebElement SearchSelect;
	
	@FindBy(id="systemUser_userName")
	WebElement SystemUserName;
	
	@FindBy(id="systemUser_status")
	WebElement SystemUserStatus;
	
	@FindBy(id="systemUser_password")
	WebElement SystemUSerPwd;
	
	@FindBy(id="systemUser_confirmPassword")
	WebElement SystemConfirmPwd;
	
	@FindBy(xpath="//p/input[@class='addbutton']")
	WebElement SaveButton;
	
	public AddUser() {
		PageFactory.initElements(driver,this);
	}
	
	public SystemUserPage AddUser(String URole,String EmpName, String UName,String UStatus, String pwd) throws InterruptedException {
		Select select=new Select(UserRole);
		select.selectByVisibleText(URole);
		
		wait.until(ExpectedConditions.visibilityOf(SystemEmployeeName));
		SystemEmployeeName.sendKeys(EmpName);
		//SystemEmployeeName.sendKeys(Keys.ARROW_DOWN);
		SearchSelect.click();
		
		
		
		SystemUserName.sendKeys(UName);
		
		Select select1=new Select(SystemUserStatus);
		select1.selectByVisibleText(UStatus);
		
		SystemUSerPwd.sendKeys(pwd);
		SystemConfirmPwd.sendKeys(pwd);
		//Thread.sleep(3000);
		
		SaveButton.click();
		
		return new SystemUserPage();
	}
	
//	public void gettext() {
//		String Text=driver.findElement(By.xpath("//*[@id='frmList_ohrmListComponent']/script")).getText();
//		System.out.println(Text);
//	}


}
