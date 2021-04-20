package com.test.shridhara.WebAutomation;

import org.testng.annotations.Test;
import com.test.shridhara.WebAutomation.browser.BrowseFactory;
import com.test.shridhara.pom.AccountInfoPage;
import com.test.shridhara.pom.CataloguePage;
import com.test.shridhara.pom.CheckoutPage;
import com.test.shridhara.pom.ConfirmationPage;
import com.test.shridhara.pom.Homepage;
import com.test.shridhara.pom.SignInPage;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Scenario1Test extends BrowseFactory {

	@Test
	public void verifyOrder() {

		// Goto home page

		Homepage homepage = new Homepage(driver);
		homepage.navigateToHomePage();

		//Goto catalogue page and select Tshirts then proceed, Hard coded menu T-shirt

		CataloguePage cataloguePage = homepage.clickOnTshirtl();
		ConfirmationPage confirmationPage = cataloguePage.clickOnCatalogueItem(1);
		confirmationPage.addToCartItem();

		CheckoutPage checkoutPage = confirmationPage.clickProceedToCheck();		
		checkoutPage.clickProceedToCheck();

		//After checkout in checkout page, sigin to application
		
		SignInPage SignInPage = new SignInPage(driver);
		SignInPage.enterUserName("testuser1@mail.com");
		SignInPage.enterPassword("123456");
		SignInPage.clickSignIn();
		
		//Proceed in Address and shipping page, then select payment method and click confirm order 

		checkoutPage.clickProceedToCheck();
		checkoutPage.selectTermsAndCondition();
		checkoutPage.clickProceedInShiipingTab();
		checkoutPage.selectPaymentCheck();
		checkoutPage.confirmMyOrder();

		//Store order number displayed after confirming order 
		
		String orderid = checkoutPage.getOrderId();
		String[] splitedstr = orderid.split("-");
		String[] splitedstrwithspace = splitedstr[4].trim().split(" ");
		String orderIdExpected = splitedstrwithspace[splitedstrwithspace.length - 1].replace(".", "");
		Reporter.log("Order id is "+orderIdExpected, true);
		
		
		
		//go to order history
		
	AccountInfoPage accountInfoPage=homepage.clickOnUserinfo();
	accountInfoPage.clickOnOrderHistory();
	List<String> ordersinhistorypage=accountInfoPage.getOrderIds();
	Reporter.log("Orders found in histiry page "+ordersinhistorypage,true);
	
	//Verifying order number is displaying or not.
	Assert.assertTrue(ordersinhistorypage.contains(orderIdExpected));
	Reporter.log("............Successfully verifed order.................");
	
	}

}
