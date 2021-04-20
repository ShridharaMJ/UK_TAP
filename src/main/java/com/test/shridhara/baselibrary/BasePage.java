package com.test.shridhara.baselibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

/**
 * @author shridhara.jayaram
 *Base page to provide flexibility for all page, All POM should extend this page.
 */
/**
 * @author shridhara.jayaram
 *
 */
public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void openURL(String url) {
		driver.get(url);
	}

	public WebElement find(By locator) {
		Reporter.log("Finding element with locator" + locator, true);
		waitForElementVisibility(locator);
		return driver.findElement(locator);
	}

	
	public List<WebElement> findEles(By locator) {
		Reporter.log("Finding element with locator" + locator, true);
		waitForElementVisibility(locator);
		return driver.findElements(locator);
	}
	
	
	public void type(By locator, String value) {
		Reporter.log("Entering value" + value, true);
		find(locator).sendKeys(value);
	}

	/**
	 * @param locator Hard coding wait here duw time crunch
	 */
	public void waitForElementVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

}
