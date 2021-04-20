package com.test.shridhara.WebAutomation.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * @author shridhara.jayaram Browser factory to open browser and close for every
 *         test we perform
 */
public class BrowseFactory {

	protected WebDriver driver;

	/**
	 * 
	 */
	@BeforeMethod
	public void SetUp() {

		Reporter.log("Launching chrome browser...", true);
		System.setProperty("webdriver.chrome.driver", "./Webdriver/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown() {
		Reporter.log("Closing chrome browser...", true);
		driver.quit();
	}

}
