package com.simplilearn.webapptest.facebook;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookHomePageTest {
	
	String url = "https://www.facebook.com";
	String driverpath = "driver/windows/chromedriver.exe";
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		driver.get(url);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	@Test
	public void loginTest() {
		WebElement email = driver.findElement(By.cssSelector("#email"));
		email.sendKeys("abc123@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		pass.sendKeys("abc123");
		WebElement submit = driver.findElement(By.name("login"));
		submit.submit();
		
		// Conditional timeouts
				// WebElement error = driver.findElement(By.cssSelector("#error_box > div.fsl.fwb.fcb"));
				WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div.fsl.fwb.fcb")));
				assertEquals("You can't log in at the moment", error.getText());
				
				// WebElement error2 = driver.findElement(By.cssSelector("#error_box > div:nth-child(2)"));
				WebElement error2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div:nth-child(2)")));
				assertEquals("Invalid username or password", error2.getText());
	}

}
