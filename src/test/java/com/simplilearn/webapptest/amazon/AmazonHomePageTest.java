package com.simplilearn.webapptest.amazon;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonHomePageTest {
	
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
	public void homePageTitleTest() {
		String actual= "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String expected = driver.getTitle();
		assertEquals(actual, expected);
	}
	
	@Test
	public void homePageurlTest() {
		assertEquals(siteUrl, driver.getCurrentUrl());
	}
	
	@Test
	public void amazonSearchProductTest1() {
		WebElement product = driver.findElement(By.id("twotabsearchtextbox"));
		product.sendKeys("Apple Iphone 12");
		product.submit();
		
		String expected = "Amazon.in : Apple Iphone 12";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	public void amazonSearchProductTest2() {
		WebElement product2 = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		product2.sendKeys("Apple Macbook Pro");
		product2.submit();
		
		String expected = "Amazon.in : Apple Macbook Pro";
		String actual = driver.getTitle();
		assertEquals(actual, expected);
	}
}
