package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	// this can also be defined into config.properties file also
	public static long Page_load_TimeOut=50;
	public static long Implicit_wait_TimeOut=50;
	public static String TEST_DATA_PATH="C:\\Users\\P10390838\\OneDrive - Capita\\AutomationCode\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\OrangeHRMSite.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException{
		FileInputStream file=null;
		try {
			file=new FileInputStream(TEST_DATA_PATH);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		}catch(IOException e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	public static void takeScreenShotAtEnfOfTest() throws IOException {
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String CurrentDir=System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(CurrentDir+"/ScreenShots/"+System.currentTimeMillis()+".png"));
	}
}
