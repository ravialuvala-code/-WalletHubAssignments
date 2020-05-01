package com.wallethub.whpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	private WebElement element;
		
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public WebElement userMailText()
	{
		
		element =driver.findElement(By.name("em"));
		
		return element;
		
	}
	
	public WebElement passWordText()
	{
		
		element =driver.findElement(By.name("pw"));
		
		return element;
		
	}
	
	public WebElement remberMailToggle()
	{
		
		element =driver.findElement(By.xpath("//div[@class = 'full left remember']/label/input[@type = 'checkbox']"));
		
		return element;
		
	}

	
	public WebElement loginBtn()
	{
		element = driver.findElement(By.xpath("//button/span[contains(text(),'Login')]")); 
				
		return element;		
	}
	
	
}
