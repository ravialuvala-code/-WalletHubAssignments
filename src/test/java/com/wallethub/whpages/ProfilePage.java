package com.wallethub.whpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

	private WebDriver driver;
	private WebElement element;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement reviewFeed()
	{
		element = driver.findElement(By.xpath("//section[@class = 'pr-ct-box pr-rec']/div/h2[@class ='pr-rec-subtitle']"));
		
		return element;
	}
	
}
