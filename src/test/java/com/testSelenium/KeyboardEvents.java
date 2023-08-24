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

public class KeyboardEvents {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
        
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/text-box");
		
		WebElement fullName, email, currentAddress, permanentAddress;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		
		email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
		
		currentAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress")));
		
		permanentAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress")));
		
		fullName.sendKeys("Salhi Fayza");
		
		email.sendKeys("fayzaf@gmail.com");
		
		// Create instance of JavaScript executor
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// now execute query which actually will scroll until that element is not appeared on page.
		// Scroll vertically to an element (*_*).
		
		js.executeScript("arguments[0].scrollIntoView()", permanentAddress);
		
		currentAddress.sendKeys("Thala-Gasserine");
		
		Actions action = new Actions(driver);
		
		//Type special characters with keyboard actions
		
		action.keyDown(currentAddress,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		js.executeScript("arguments[0].scrollIntoView()", permanentAddress);
		
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(permanentAddress, Keys.CONTROL).perform();
		
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
