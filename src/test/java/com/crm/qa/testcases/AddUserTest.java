package com.crm.qa.testcases;



import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddUser;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SystemUserPage;
import com.crm.qa.pages.dashBoard;
import com.crm.qa.util.TestUtil;

public class AddUserTest extends TestBase{
	
	LoginPage loginpage;
	dashBoard dashBoard1;
	SystemUserPage systemuser;
	AddUser adduser;
	String sheetName ="AddUser";
	
	public AddUserTest() {
		super();
				
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		ExplicitWait();
		loginpage=new LoginPage();
		dashBoard1= new dashBoard();
		systemuser= new SystemUserPage();
		adduser= new AddUser();
		dashBoard1=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		systemuser=dashBoard1.clickAdminModuleLink();
		adduser=systemuser.clickAddButton();
		
	}
	
	@DataProvider
	public Object[][] getHRMTestData() throws InvalidFormatException {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider="getHRMTestData")
	public void AddUser(String UserRole,String Employee, String UserName,String Status, String Password) throws InterruptedException {
		systemuser= adduser.AddUser(UserRole,Employee,UserName,Status,Password); 
					//adduser.gettext();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}


