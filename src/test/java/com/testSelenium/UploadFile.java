package com.testSelenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadFile {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/upload/");
		
		WebElement uploadFile = driver.findElement(By.id("uploadfile_0"));
		
		uploadFile.sendKeys("your path file");
        	
	    WebElement checkbox;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terms")));
		
		if (!checkbox.isSelected()) {
			
		checkbox.click();
		
		}
		
		driver.findElement(By.id("submitbutton")).click();
	
		WebElement messageElement = driver.findElement(By.id("res"));

		String innerHtml1 = messageElement.getAttribute("innerHTML");

		String extractedMessage = innerHtml1.replaceAll("<.*?>", "").trim();

		String expectedMessage = "1 file has been successfully uploaded.";

		Assert.assertEquals(expectedMessage, extractedMessage);
		
		System.out.println(extractedMessage);

		System.out.println("Automated test completed." );
        
       // Thread.sleep(5000);
        
       //driver.quit();
		
	}


}
