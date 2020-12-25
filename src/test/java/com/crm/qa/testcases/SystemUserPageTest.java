package com.crm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddUser;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SystemUserPage;
import com.crm.qa.pages.dashBoard;

	public class SystemUserPageTest extends TestBase {
	LoginPage loginpage;
	dashBoard dashBoard1;
	SystemUserPage systemuser;
	AddUser adduser;
	
	public SystemUserPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage= new LoginPage();
		dashBoard1=new dashBoard();
		systemuser=new SystemUserPage();
		adduser=new AddUser();
		dashBoard1= loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		systemuser=dashBoard1.clickAdminModuleLink();
	}
	
	@Test(priority=1)
	public void verifySystemUserLableTest() {
		Assert.assertTrue(systemuser.verifySystemUserLable());
	}
	
	@Test(priority=2)
	public void clickAddButtonTest() {
		adduser=systemuser.clickAddButton();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
	

}
