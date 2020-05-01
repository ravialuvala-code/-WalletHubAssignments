package com.wallethub.common;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Common {

	/*
	 * =====================================================
	 * Method Name: takeScreenshot
	 * Description: This method is used to take screenshot in screenshots directory
	 * Created By: Ravi Aluvala
	 * Created Date: 01-May-2020
	 * Update Reason:
	 * Updated By :
	 * Updated Date :
	 * ======================================================
	 */	
	
	public static String takeScreenshot(WebDriver driver, String methodName) {
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenshots/";
		new File(directory).mkdir();
		String path = directory + fileName;

		try {
			File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File(path));
			System.out.println("================================");
			System.out.println("Screenshot stored at: " + path);
			System.out.println("================================");

		} catch (Exception e) {
			e.printStackTrace();

		}

		return path;
	}

	
	/*
	 * =====================================================
	 * Method Name: getScreenshotName
	 * Description: This method is used to get the dynamic screenshot name with test method and date stamp
	 * Created By: Ravi Aluvala
	 * Created Date: 01-May-2020
	 * Update Reason:
	 * Updated By :
	 * Updated Date :
	 * ======================================================
	 */	
	
	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}
	

	/*
	 * =====================================================
	 * Method Name: randomText
	 * Description: This method is used to generate random text
	 * Created By: Ravi Aluvala
	 * Created Date: 01-May-2020
	 * Update Reason:
	 * Updated By :
	 * Updated Date :
	 * ======================================================
	 */	
	
	public static String randomText(int length) {

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {

			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
	
	
	/*
	 * =====================================================
	 * Method Name: randomText
	 * Description: This method is used to generate random text
	 * Created By: Ravi Aluvala
	 * Created Date: 01-May-2020
	 * Update Reason:
	 * Updated By :
	 * Updated Date :
	 * ======================================================
	 */	
	
	public static void sleep(int i) throws Exception
	{
		Thread.sleep(1000*i);
	}
	

}
