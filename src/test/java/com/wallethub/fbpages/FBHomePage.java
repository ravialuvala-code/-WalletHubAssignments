package com.wallethub.fbpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FBHomePage {

	private WebDriver driver;
	private WebElement element;
		
	public FBHomePage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public WebElement postStatusMsgAlert()
	{
		element = driver.findElement(By.xpath("//textarea[contains(@title,'Write something here')]"));
		
		return element;
	}
	
	
	public WebElement postStatusMsg()
	{
		element = driver.findElement(By.xpath("//h2[contains(text(),'Create Post')]//..//..//..//div[@role='presentation']//div[contains(text(),'on your mind')]"));
		
		return element;
		
	}
	
	
	public WebElement postStatusBtn()
	{
		element = driver.findElement(By.xpath("//button/span[contains(text(),'Post')]"));
		
		return element;
		
		
	}
	
	
}
