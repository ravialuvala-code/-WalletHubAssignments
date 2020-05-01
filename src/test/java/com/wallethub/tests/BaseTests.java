package com.wallethub.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTests {

	public WebDriver driver;
	public String userDirectory = System.getProperty("user.dir");
	
	public BaseTests() {
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver",
				userDirectory+"//driver//chromedriver.exe");
		
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
	}

}
