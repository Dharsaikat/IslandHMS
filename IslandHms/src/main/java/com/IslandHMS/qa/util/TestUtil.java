package com.IslandHMS.qa.util;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.IslandHMS.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT=500;
	public static long IMPLICIT_WAIT=500;
	
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
	
	 

}
