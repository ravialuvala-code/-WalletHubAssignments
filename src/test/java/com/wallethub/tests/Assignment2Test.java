package com.wallethub.tests;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wallethub.common.Common;
import com.wallethub.testdata.Assignment2TD;
import com.wallethub.whpages.HomePage;
import com.wallethub.whpages.LoginPage;
import com.wallethub.whpages.ProfilePage;
import com.wallethub.whpages.ReviewConfirmPage;
import com.wallethub.whpages.ReviewSubmitPage;

public class Assignment2Test extends BaseTests {

	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	ReviewSubmitPage reviewSubmitPage = new ReviewSubmitPage(driver);
	ReviewConfirmPage reviewConfirmPage = new ReviewConfirmPage(driver);
	ProfilePage profilePage = new ProfilePage(driver);

	@BeforeClass
	public void OpenBrowser() {
		
		driver.get(Assignment2TD.baseUrl);

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	}

	@AfterClass
	public void closeBrowser() {
		driver.close();

	}

	@Test
	public void postReviewInWalletHubTest() {
		homePage.loginLink().click();
		loginPage.userMailText().sendKeys(Assignment2TD.loginMail);
		loginPage.passWordText().sendKeys(Assignment2TD.passWord);
		loginPage.loginBtn().click();
		homePage.reviewsLink().click();
		Actions act = new Actions(driver);
		for (int i = 1; i <= Assignment2TD.starNumber; i++) {
			if (i == Assignment2TD.starNumber) {
				act.moveToElement(homePage.reviewStar(i)).click().build().perform();
			} else {
				act.moveToElement(homePage.reviewStar(i)).build().perform();
			}

		}

		reviewSubmitPage.productDropDown().click();
		reviewSubmitPage.productDropDownValue(Assignment2TD.productValue).click();
		reviewSubmitPage.writeReviewComment().clear();
		reviewSubmitPage.writeReviewComment().sendKeys(Common.randomText(Assignment2TD.reviewMsgLength));
		reviewSubmitPage.submitReview().click();

		if (reviewConfirmPage.reviewConfirmMsg().isDisplayed()) {
			reviewConfirmPage.ContinueBtn().click();
		}
		
		
		driver.navigate().to(Assignment2TD.profile+Assignment2TD.pUserName);
		String actualResult = profilePage.reviewFeed().getText();
		Assert.assertEquals(actualResult, Assignment2TD.exectedResult);

	}

}
