package com.simplilearn.webapptest.amazon;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonNavigationTest {
	
	String siteUrl = "https://www.amazon.in/";
	String driverpath = "driver/windows/chromedriver.exe";
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	@Test
	public void amazonNavTest01() {
		WebElement nav = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)"));
		nav.click();
		
		String expected = "Amazon.in - Today's Deals";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	public void amazonNavTest02() {
		WebElement nav2 = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]"));
		nav2.click();
		
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	
	

}
