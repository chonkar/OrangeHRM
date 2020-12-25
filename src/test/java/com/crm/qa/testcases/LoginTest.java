package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.dashBoard;

public class LoginTest extends TestBase {
	LoginPage loginPage;
	dashBoard dashboardMethod;
	
	public LoginTest() {
	super(); // To call super/parent class constructor by using super keyword
			 // it will not give null pointer exception, as we have called the properties of super/parent class constructor
	}
	
	@BeforeMethod
	public void TestBase() {
		initialization();
		loginPage= new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void HRMLogoTest() {
		boolean Orangelogo=loginPage.validateCRMLogo();
		Assert.assertTrue(true);
	}
	
	@Test(priority=3)
	public void LoginTest() {
		dashboardMethod=loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
