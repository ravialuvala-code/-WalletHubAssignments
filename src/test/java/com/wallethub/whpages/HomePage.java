package com.wallethub.whpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	
	private WebDriver driver;
	private WebElement element;
		
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	
	public WebElement loginLink()
	{
		
		element =driver.findElement(By.xpath("//span[@class ='brgm-button brgm-signup' and  contains(text(), 'Login')]"));
		
		return element;
		
	}
	
	
	public WebElement loginUser()
	{
		element = driver.findElement(By.xpath("//div[@class ='brgm-button brgm-user brgm-list-box']/span"));
		
		return element;
	}
	
	
	public WebElement reviewsLink()
	{
		element = driver.findElement(By.xpath("//div[@class ='left-content']/a[@ng-reflect-fragment = 'reviews']/span[@class = 'nav-txt']"));
		
		return element;
	}
	
	
	public WebElement reviewStar(int i)
	{
		element = driver.findElement(By.cssSelector("#reviews-section > div.review-stat-box > div.review-action.ng-enter-element > review-star > div > svg:nth-child("+i+")"));
		
		return element;
	}
}
