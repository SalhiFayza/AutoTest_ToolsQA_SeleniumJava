package com.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://demoqa.com/menu/");
		
		WebElement mousehover;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		// Find the element to hover over with xpath
		
		mousehover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav\"]/li[2]/a")));
		
		Actions action = new Actions(driver);
		
		// Perform mouse hover action
		
		action.moveToElement(mousehover).perform();
		
		Thread.sleep(5000);
		
		driver.quit();
	}
}
