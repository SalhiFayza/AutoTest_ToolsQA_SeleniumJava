package com.testSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButton {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/radio-button/");

		WebElement radioBtn;

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Find a radio button element

		radioBtn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]")));

		// Select the radio button if it is not selected

		if (!radioBtn.isSelected()) {

			radioBtn.click();
		}

		String msgAttendu = "You have selected Yes";

		String msgObtenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p")).getText();

		Assert.assertEquals(msgObtenu, msgAttendu);

		System.out.println("Okay (*_*)");

	}

}
