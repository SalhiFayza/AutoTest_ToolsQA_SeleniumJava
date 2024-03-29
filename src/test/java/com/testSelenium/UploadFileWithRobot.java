package com.testSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFileWithRobot {
	private WebDriver driver;
	public WebDriverWait wait;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();	

		// Initialize the WebDriver.
		driver = new ChromeDriver();
	}

	@Test
	public void fileUploadTest() throws AWTException, InterruptedException {
		// Navigate to the webpage where you want to upload the file.
		driver.get("https://blueimp.github.io/jQuery-File-Upload/"); // Replace with your URL.

		// Find the file input element.
		WebElement fileInput = driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button"));
		// Replace with the actual element locator.

		// Click the file input element to open the file dialog.
		fileInput.click();

		// Set the file path to be uploaded.
		StringSelection filePath = new StringSelection("/home/salhi/upload.png"); // Replace with the actual file path.
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
				
        //I added sleep to see the result with my eyes. If you want you can remove below line.
        Thread.sleep(2000);
        
        
		// Create a Robot instance.
		Robot robot = new Robot();

		// Delay to give focus to the file dialog (you may need to adjust this delay).
		robot.delay(1000);

		// Simulate keypresses for Ctrl+V to paste the file path.
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Delay to ensure the file path is entered before pressing Enter.
		robot.delay(1000);

		// Simulate pressing Enter to confirm the file selection.
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		// You can add additional steps here to interact with the webpage after the file
		// upload.
	}

	@After
	public void tearDown() {
		// Close the WebDriver.
		if (driver != null) {
			driver.quit();
		}
	}
}
