package com.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/checkbox/");
		
		WebElement checkbox;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]")));
		
		// Check the checkbox if it is not selected
		if (!checkbox.isSelected()) {
			
		checkbox.click();
		
		}
		
	   
		
	}

}
