package com.testSelenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotCapture {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/browser-windows");
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("pathScreenshot/ScreenshotCapture/screenshot.png");
		
		FileUtils.copyFile(srcFile, destFile);
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
