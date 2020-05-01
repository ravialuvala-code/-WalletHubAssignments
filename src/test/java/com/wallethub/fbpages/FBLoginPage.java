package com.wallethub.fbpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FBLoginPage {

	private WebDriver driver;
	private WebElement element;
		
	public FBLoginPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public WebElement userMailText()
	{
		
		element =driver.findElement(By.name("email"));
		
		return element;
		
	}
	
	public WebElement passWordText()
	{
		
		element =driver.findElement(By.name("pass"));
		
		return element;
		
	}
	
	
	public WebElement loginBtn()
	{
		element = driver.findElement(By.name("login")); 
				
		return element;		
	}
	
}
