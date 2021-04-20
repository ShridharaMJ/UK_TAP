package com.test.shridhara.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.test.shridhara.baselibrary.BasePage;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	By procced_to_chekout_x = By.xpath("//span[text()='Proceed to checkout']");
	By proceed_in_shippingTav_x=By.xpath("//button//span[contains(text(),'Proceed to checkout')]");
	By select_terms_x =By.xpath("//span[not(@class)]/input[@id='cgv']");
	By payment_methoid_x = By.xpath("//a[@class='cheque']");
	By confirm_order_x=By.xpath("//button[@type='submit']/span[text()='I confirm my order']");
	By homepagelogo_x = By.xpath("//div[@id='header_log']");
	By ShippingTab_x=By.xpath("//h1[@class='page-heading' and text()='Shipping']");
	By getorderid_x=By.xpath("//div[@class='box order-confirmation']");

	public void clickProceedToCheck() {

		find(procced_to_chekout_x).click();
	}

	
	public void clickProceedInShiipingTab() {

		find(proceed_in_shippingTav_x).click();
	}

	
	public void selectTermsAndCondition() {
		waitForElementVisibility(ShippingTab_x);
		Reporter.log("Successfully displayed Shipping tab",true);
		((JavascriptExecutor)driver).executeScript("document.getElementById('cgv').click();");
	}

	public void selectPaymentCheck() {
		find(payment_methoid_x).click();

	}

	public void confirmMyOrder() {
		find(confirm_order_x).click();;
	}
	
	public void clickOnLogo() {
		find(homepagelogo_x).click();
	}
	
	public String getOrderId() {
		return find(getorderid_x).getText();
	}
	
}
