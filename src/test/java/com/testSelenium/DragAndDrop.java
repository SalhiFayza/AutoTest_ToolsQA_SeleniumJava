package com.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://demoqa.com/droppable/");
		
		WebElement to,from;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		to = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));
        
		from = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
		
		Actions action = new Actions(driver);
		
		// Drag and Drop
		
		action.dragAndDrop(from, to).perform();
		
		String messageObtenu = to.getText();
		
		Assert.assertEquals(messageObtenu, "Dropped!");
		
		System.out.println("Passed (-_-)");
		
		Thread.sleep(3000);
		
	    driver.quit();
		
		
		
		
		
		
		
		
	}

}
