package com.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class KeyboardEvents {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
        
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/text-box");
		
		WebElement fullName, email, currentAdress, permanentAdress;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		
		email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
		
		currentAdress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress")));
		
		permanentAdress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress")));
		
		fullName.sendKeys("Salhi Fayza");
		
		email.sendKeys("fayzaf@gmail.com");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView()", permanentAdress);
		
		currentAdress.sendKeys("Thala-Gasserine");
		
		Actions action = new Actions(driver);
		
		action.keyDown(currentAdress,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		js.executeScript("arguments[0].scrollIntoView()", permanentAdress);
		
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(permanentAdress, Keys.CONTROL).perform();
		
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		Assert.assertEquals(currentAdress.getText(), permanentAdress.getText());
				
		System.out.println("Copy/Paste were completed successfully");
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
