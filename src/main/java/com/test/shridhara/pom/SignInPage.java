package com.test.shridhara.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.shridhara.baselibrary.BasePage;

/**
 * @author shridhara.jayaram
 *
 */
public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	By email_x = By.xpath("//input[@id='email']");
	By password_x = By.xpath("//*[@id='passwd']");
	By signin_x = By.xpath("//*[@id='SubmitLogin']");
	By homepagelogo_x = By.xpath("//div[@id='header_log']");
	
	
	public void enterUserName(String name) {
		type(email_x, name);
	}

	public void enterPassword(String name) {
		type(password_x, name);
	}

	public void clickSignIn() {
		find(signin_x).click();		
	}
	public void clickOnLogo() {
		find(homepagelogo_x).click();
	
}
}