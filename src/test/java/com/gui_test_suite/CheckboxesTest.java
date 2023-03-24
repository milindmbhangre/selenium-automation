package com.gui_test_suite;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxesTest {
	
	WebDriver driver;
	String url = "https://www.seleniumeasy.com/test/basic-checkbox-demo.html";
	
	@BeforeClass
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void testCheckboxesReverseOrder() throws InterruptedException{
		driver.get(url);
		System.out.println("Application launched");
		List<WebElement> checkboxes = driver.findElements(By.cssSelector(".checkbox .cb1-element"));
		System.out.println("Locator searched");
		System.out.println(checkboxes.size());
		ListIterator<WebElement> iterator = checkboxes.listIterator(checkboxes.size());
		
		while(iterator.hasPrevious()) {
			Thread.sleep(2000);
			iterator.previous().click();
		}
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}

}
