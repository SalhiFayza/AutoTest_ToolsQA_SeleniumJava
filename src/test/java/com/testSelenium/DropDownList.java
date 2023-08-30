package com.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownList {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/ressource/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/select-menu");

		WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));

		Select select = new Select(dropdown);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,400);");

		// select by value "Red"

		select.selectByValue("3");

		Thread.sleep(3000);

		// select by visible text "Red"

		select.selectByVisibleText("Red");

		Thread.sleep(3000);

		// select by index "Red"

		select.selectByIndex(0);

		// Deselect all options

		// select.deselectAll();

		// select many options

		WebElement manySelect;

		manySelect = driver.findElement(By.id("cars"));

		Select carsDropDown = new Select(manySelect);

		if (carsDropDown.isMultiple()) {

			carsDropDown.selectByIndex(3);

			carsDropDown.selectByIndex(1);

			Thread.sleep(3000);

			// Deselect many

			carsDropDown.deselectAll();

		}

	}

}
