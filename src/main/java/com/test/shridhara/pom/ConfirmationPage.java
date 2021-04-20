package com.test.shridhara.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.shridhara.baselibrary.BasePage;

/**
 * @author shridhara.jayaram
 *
 */
public class ConfirmationPage extends BasePage {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}

	By add_to_cart_x = By.xpath("//p[@id='add_to_cart']");
	By procced_to_chekout_x = By.xpath("//a[@title='Proceed to checkout']");
	By verifySummaryPage=By.xpath("//h1[@class='page-heading' and contains(text(),'Shopping-cart summary')]");

	/**
	 * Clicking on AddToCart
	 * 
	 * @author shridhara.jayaram
	 */
	public void addToCartItem() {
		find(add_to_cart_x).click();;

	}

	/**
	 * @author shridhara.jayaram
	 */
	public CheckoutPage clickProceedToCheck() {
		find(procced_to_chekout_x).click();
		waitForElementVisibility(verifySummaryPage);
		return new CheckoutPage(driver);
	}

}
