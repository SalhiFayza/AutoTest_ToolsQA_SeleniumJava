package com.testSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class Table {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("file:///home/salhi/eclipse-workspace/toolsQA_Selenium/tablehtml/table.html");


		//List<WebElement> headings =driver.findElements(By.xpath("//table[@id='table1']/th[1]"));
        
		//List<WebElement> headings =driver.findElements(By.xpath("//table[@id='table1']/tbody"));
		
		//List<WebElement> headings =driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        
		List<WebElement> headings =driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));

	    for(int i=0; i < headings.size(); i++) {
	    	
	    	System.out.println(headings.get(i).getText());
	    }
	    
	    System.out.println("****(-_-)****");
	
	    String giveCover = "2 Image PNG";
	    
	    List<WebElement> cover = driver.findElements(By.xpath("//table[@id='table1']//td[0]"));
	    
	    int col = 0;
	    
	    for(int i = 0 ; i < cover.size() ; i++) {
	    	
	    	if(cover.get(i).getText().equals(giveCover)) {
	    		col = i;
	    	}
	    }
	    
	    String path = "//table[@id='table1']//tr["+(col+2)+"]//td[2]";
	    
	    String msgres = driver.findElement(By.xpath(path)).getText();
	    
	   System.out.println(driver.findElement(By.xpath(path)).getText());
	    
	    Assert.assertEquals(msgres, path);
	    
		System.out.println("Automated test completed." );

	    
	}
	
}
