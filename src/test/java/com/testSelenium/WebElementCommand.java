package com.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementCommand {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
				
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/text-box");
				
        WebElement  email, currentAddress;
				
		email = driver.findElement(By.id("userEmail"));
		
		email.sendKeys("fayzasalhif@gmail.com");
		
        // Type(*_*)
		String attType = email.getAttribute("type");
		
		System.out.println("Type email is : " + attType + ";");
		
        // Placeholder(*_*)		
		String attPlaceholder = email.getAttribute("placeholder");
		
		System.out.println("Placeholder email is : " + attPlaceholder + ";");
		
		currentAddress = driver.findElement(By.id("currentAddress"));
		
		currentAddress.sendKeys("Thala-Gasserine");
		
		// Get size textarea Current Address
		
		Dimension size =  currentAddress.getSize();
		
		System.out.println("height : " + size.height + ";\n" +"Width : " +size.width  + ";");
		
		// Get Location textarea Current Address
		
		Point point = currentAddress.getLocation();
		
		System.out.println("La coordonnées x : " + point.x + ";\n" +"La coordonnées Y : " + point.y + ";");

	}

}
