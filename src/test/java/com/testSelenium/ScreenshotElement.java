package com.testSelenium;

import org.openqa.selenium.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotElement {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// navigate to url
		driver.get("https://demoqa.com/");

		// Locate the element on the web page
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a"));

		// Get screenshot of the visible part of the web page
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Convert the screenshot into BufferedImage
		BufferedImage fullScreen = ImageIO.read(screenshot);

		// Find location of the webelement logo on the page
		Point point = logo.getLocation();

		// Find width and height of the located element logo
		int width = logo.getSize().getWidth();
		
		int height = logo.getSize().getHeight();

		// cropping the full image to get only the logo screenshot
		BufferedImage logoImage = fullScreen.getSubimage(point.getX(), point.getY(), width, height);
		
		ImageIO.write(logoImage, "png", screenshot);

		// Save cropped Image at destination location physically.
		FileUtils.copyFile(screenshot, new File("pathScreenshot/ScreenshotElement/elementScreenshot.PNG"));

		Thread.sleep(5000);
		
		//driver.quit();
	}

}
