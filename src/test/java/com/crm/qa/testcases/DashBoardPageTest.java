package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SystemUserPage;
import com.crm.qa.pages.dashBoard;

public class DashBoardPageTest extends TestBase {
	
	LoginPage loginpage;
	dashBoard dashBoard1;
	SystemUserPage systemuser;
	
	public DashBoardPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage=new LoginPage();
		systemuser=new SystemUserPage();
		dashBoard1= loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyDashBoardTitlePage() {
		String Title=dashBoard1.titleOfDashBoardPage();
		Assert.assertEquals(Title, "OrangeHRM", "DashBoard Title not match");
		dashBoard1.logout();
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(dashBoard1.verifyUsername());
		dashBoard1.logout();
	}
	
	@Test(priority=3)
	public void clickAdminModuleLinkTest() {
		systemuser=dashBoard1.clickAdminModuleLink();
		
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
