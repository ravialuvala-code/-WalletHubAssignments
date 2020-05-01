package com.wallethub.utils;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentsManager {

	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;

	/*
	 * =====================================================
	 * Method Name: createExtentReport
	 * Description: This method is used to create extent report with configurations in reports directory
	 * Created By: Ravi Aluvala
	 * Created Date: 01-May-2020
	 * Update Reason:
	 * Updated By :
	 * Updated Date :
	 * ======================================================
	 */	
	public static ExtentReports createExtentReport() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdir();
		String path = directory + fileName;

		htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("WalletHub GUI Automation Reports");
		htmlReporter.config().setReportName("WalletHub GUI Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "WalletHub.com");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Name", "Ravi Aluvala");
		extent.attachReporter(htmlReporter);

		return extent;
	}
	
	/*
	 * =====================================================
	 * Method Name: getReportName
	 * Description: This method is used to get the dynamic report name with date stamp
	 * Created By: Ravi Aluvala
	 * Created Date: 01-May-2020
	 * Update Reason:
	 * Updated By :
	 * Updated Date :
	 * ======================================================
	 */

	public static String getReportName() {
		Date d = new Date();
		String fileName = "WalletHubAssignmentReport" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		return fileName;
	}

}
