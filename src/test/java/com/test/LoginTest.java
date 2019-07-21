package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");		
		
	}
	
	@Test(priority=1)
	public void FreeCRMTitleTest() {
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Facebook – log in or sign up");
	}

	@Test(priority=2)
	public void FreeCRMLOgoTest() {
		boolean b=driver.findElement(By.xpath("//i[@class='fb_logo img sp_Er_CExuI2JW sx_a62542']")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}