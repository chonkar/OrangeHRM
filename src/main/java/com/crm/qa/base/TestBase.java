/* TestBase Class */

package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListner;
	
	public TestBase() {
		
		prop= new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\P10390838\\OneDrive - Capita\\AutomationCode\\FreeCRMTest\\src\\main\\java\\com\\crm"
					+ "\\qa\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		
		
	}
	
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\P10390838\\OneDrive - Capita\\SeleniumTutorails\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\P10390838\\OneDrive - Capita\\SeleniumTutorails\\geckodriver.exe");
		}
		e_driver= new EventFiringWebDriver(driver);
		eventListner=new WebEventListener();
		e_driver.register(eventListner);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait_TimeOut,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	public static void ExplicitWait() {
		wait=new WebDriverWait(driver,30);
		
	}

}
