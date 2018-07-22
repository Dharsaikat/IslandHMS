package com.IslandHMS.qa.util;
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


import com.IslandHMS.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT=500;
	public static long IMPLICIT_WAIT=500;
	public static Workbook book;
	public static Sheet sheet;
	public static String excel_test_data_path= System.getProperty("user.dir") + "/IslandHms/src/main/java/com/IslandHMS/qa/testdata/TESTDATA1.xlsx";
	
	/*  keep your all test data by adding extra sheets,
	  put all your test data in sheet and give that sheet name in calling method
	  Do not create extra excel sheet,try to maintain one excel sheet*/
	
	public static void  failed_Test_ScreenShot_Capture()
	{
		File src_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src_file, new File(System.getProperty("user.dir")+"IslandHms\\test-output\\FailedScreenShots"
					+"failshot_"  + ".jpg"));
		}
		
		catch(IOException io)
		{
			io.printStackTrace();
		}
	}
	
	
	public static Object[][] getTestData(String sheetname) {
		
		 
		FileInputStream file = null;
		try {
			file = new FileInputStream(excel_test_data_path);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k <  sheet.getRow(i).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				 System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	 

}
