package com.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/alerts");
		
		new WebDriverWait(driver, 10)
		.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertButton")))
	    .click();
		
		Thread.sleep(3000);
		
		// Get Alert Text
		
		String alertText = driver.switchTo().alert().getText();
		
		String messageAtendu = "You clicked a button";
		
	    Assert.assertEquals(alertText, messageAtendu);
		
		System.out.println("Okay (*_*)");
		
		// Accept Alert
		
		driver.switchTo().alert().accept();
		
		driver.quit();
	}

}
