package com.test.shridhara.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.test.shridhara.baselibrary.BasePage;

public class Homepage extends BasePage {

	private String home_page_url = "http://automationpractice.com/index.php";

	// By objects

	By tshirtsobject_x = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");
	By signin_x = By.xpath("//div[@class='header_user_info']/a[@class='login']");
	By account_x = By.xpath("//div[@class='header_user_info']/a[@class='account']");
	By homepagelogo_x = By.xpath("//div[@id='header_log']");
	By userid_x = By.xpath("//a[@class='account']/span");

	public Homepage(WebDriver driver) {
		super(driver);
	}

	public void navigateToHomePage() {
		Reporter.log("Opening URL " + home_page_url);
		openURL(home_page_url);
	}

	public CataloguePage clickOnTshirtl() {
		Reporter.log("Clicking on T-shirt link", true);
		find(tshirtsobject_x).click();
		return new CataloguePage(driver);
	}

	public SignInPage clickSignIn() {
		find(signin_x).click();
		return new SignInPage(driver);
	}

	public void clickOnLogo() {
		find(homepagelogo_x).click();
	}

	public AccountInfoPage clickOnUserinfo() {
		find(account_x).click();
		return new AccountInfoPage(driver);
	}

	public String getUserName() {

		return find(userid_x).getText();
	}
}
