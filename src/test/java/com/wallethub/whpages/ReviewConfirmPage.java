package com.wallethub.whpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewConfirmPage {
	
	private WebDriver driver;
	private WebElement element;
	
	public ReviewConfirmPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement reviewConfirmMsg()
	{
		element = driver.findElement(By.xpath("//main//div[@class = 'rvc-header']/h4"));
		return element;
	}
	
	public WebElement ContinueBtn()
	{
		element = driver.findElement(By.xpath("//div[@class = 'btn rvc-continue-btn']"));
		return element;
	}

}
