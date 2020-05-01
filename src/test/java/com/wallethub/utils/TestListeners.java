package com.wallethub.utils;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.wallethub.common.Common;
import com.wallethub.tests.BaseTests;

public class TestListeners implements ITestListener {

	private static ExtentReports extent = ExtentsManager.createExtentReport();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	/*
	 * =====================================================
	 * Method Name: onTestStart
	 * Description: This method implemented for get the test method name
	 * Created By: Ravi Aluvala
	 * Created Date: 01-May-2020
	 * Update Reason:
	 * Updated By :
	 * Updated Date :
	 * ======================================================
	 */	
	
	public void onTestStart(ITestResult result) {
		System.out.println("==============="+result.getMethod().getMethodName() +"Execution Starting============");
		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + "::::" + result.getMethod().getMethodName());

		extentTest.set(test);

	}
	
	
	/*
	 * =====================================================
	 * Method Name: onTestSuccess
	 * Description: This method implemented to write log in extent report when test method successfully executed
	 * Created By: Ravi Aluvala
	 * Created Date: 01-May-2020
	 * Update Reason:
	 * Updated By :
	 * Updated Date :
	 * ======================================================
	 */	
	

	public void onTestSuccess(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Successfull</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
	}
	
	
	/*
	 * =====================================================
	 * Method Name: onTestFailure
	 * Description: This method implemented to write log in extent report when test method failed along with screenshot
	 * Created By: Ravi Aluvala
	 * Created Date: 01-May-2020
	 * Update Reason:
	 * Updated By :
	 * Updated Date :
	 * ======================================================
	 */	

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());

		extentTest.get()
				.fail("<details><summary>" + "<b><font color =red>Exception occured, Click to see details:</font>"
						+ "</b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");

		WebDriver driver = ((BaseTests) result.getInstance()).driver;

		String path = Common.takeScreenshot(driver, methodName);
		try {
			extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());

		} catch (IOException e) {
			extentTest.get().fail("Test Failed, Cannot attach screenshot");
		}

		String logText = "<b>Test Method " + methodName + " Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);
	}
	
	/*
	 * =====================================================
	 * Method Name: onTestSkipped
	 * Description: This method implemented to write log in extent report when test method skipped
	 * Created By: Ravi Aluvala
	 * Created Date: 01-May-2020
	 * Update Reason:
	 * Updated By :
	 * Updated Date :
	 * ======================================================
	 */	
	

	public void onTestSkipped(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP, m);
	}
	
	/*
	 * =====================================================
	 * Method Name: onFinish
	 * Description: This method implemented to flush the extent report
	 * Created By: Ravi Aluvala
	 * Created Date: 01-May-2020
	 * Update Reason:
	 * Updated By :
	 * Updated Date :
	 * ======================================================
	 */	
	

	public void onFinish(ITestContext context) {

		if (extent != null) {
			extent.flush();
		}

	}

}
