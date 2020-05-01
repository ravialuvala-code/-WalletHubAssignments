package com.wallethub.whpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewSubmitPage {
	

	private WebDriver driver;
	private WebElement element;
	
	public ReviewSubmitPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement productDropDown()
	{
		
		element = driver.findElement(By.xpath("//ng-dropdown[@class= 'wrev-drp']//span[@class ='dropdown-placeholder' and contains(text(),'Select...')]"));
		
		return element;
	}

	
	public WebElement productDropDownValue(String value)
	{
		
		element = driver.findElement(By.xpath("//ng-dropdown[@class= 'wrev-drp']//ul//li[@class='dropdown-item' and contains(text(),'"+value+"')]"));
		
		return element;
	}
	
	public WebElement writeReviewComment()
	{
		element= driver.findElement(By.xpath("//div/textarea[@class = 'textarea wrev-user-input validate']"));
		
		return element;
	}
	
	public WebElement submitReview()
	{
		element= driver.findElement(By.xpath("//div[@class = 'sub-nav-ct']/div[contains(text(),'Submit')]"));
		
		return element;
	}
}
