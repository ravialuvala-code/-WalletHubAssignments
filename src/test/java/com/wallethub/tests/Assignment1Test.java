package com.wallethub.tests;

import org.testng.annotations.Test;

import com.wallethub.common.Common;
import com.wallethub.fbpages.FBHomePage;
import com.wallethub.fbpages.FBLoginPage;
import com.wallethub.testdata.Assignment1TD;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Assignment1Test extends BaseTests {

	FBLoginPage loginPage = new FBLoginPage(driver);
	FBHomePage homePage = new FBHomePage(driver);

	@BeforeClass
	public void OpenBrowser() {
		
		driver.get(Assignment1TD.baseUrl);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterClass
	public void closeBrowser() {
		driver.close();

	}

	@Test
	public void postMessageInFacebookTest() throws Exception {
		loginPage.userMailText().sendKeys(Assignment1TD.loginMail);
		loginPage.passWordText().sendKeys(Assignment1TD.passWord);
		loginPage.loginBtn().click();
		Common.sleep(5);
		homePage.postStatusMsgAlert().click();
		homePage.postStatusMsgAlert().sendKeys(Assignment1TD.postMsg);
		Common.sleep(5);
		homePage.postStatusBtn().click();
		Common.sleep(5);
		Assert.assertTrue(driver.getPageSource().contains(Assignment1TD.postMsg));

	}

}
