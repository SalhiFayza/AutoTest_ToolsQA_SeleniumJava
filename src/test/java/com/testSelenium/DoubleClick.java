package com.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		
      WebDriverManager.chromedriver().setup();;
      
      WebDriver driver = new ChromeDriver();
      
      driver.manage().window().maximize();
      
      driver.get("http://demoqa.com/buttons");
      
      WebElement doubleClickBtn;
      
      WebDriverWait wait = new WebDriverWait(driver, 10);
      
      doubleClickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickBtn")));
      
      Actions action = new Actions(driver);
      
      // Double Click Button
      
      action.doubleClick(doubleClickBtn).perform();
      
      String messageAtendu = "You have done a double click";
      
      String messageObtenu = driver.findElement(By.id("doubleClickMessage")).getText();
      
      Assert.assertEquals(messageObtenu, messageAtendu);
      
      System.out.println("Le message obtenu est égal au message attendu.");
      
      Thread.sleep(5000);
      
      driver.quit();
      
      
      
      
	}

}
