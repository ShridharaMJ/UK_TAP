package com.test.shridhara.WebAutomation;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.test.shridhara.WebAutomation.browser.BrowseFactory;
import com.test.shridhara.pom.AccountInfoPage;
import com.test.shridhara.pom.Homepage;
import com.test.shridhara.pom.SignInPage;

public class Scenario2Test extends BrowseFactory {

	@Test
	public void updatePersonalInfo() {

		Homepage homepage = new Homepage(driver);
		homepage.navigateToHomePage();

		SignInPage SignInPage = homepage.clickSignIn();
		SignInPage.enterUserName("testuser1@mail.com");
		SignInPage.enterPassword("123456");
		SignInPage.clickSignIn();

		AccountInfoPage accountInfoPage = homepage.clickOnUserinfo();
		
		accountInfoPage.clickMyPersonalInfo();

		// Hard coding password, since we are not taking from excel or property file
		String updatedlasname = RandomStringUtils.randomAlphabetic(1, 4);
		Reporter.log("Updated name "+updatedlasname);
		accountInfoPage.updated(updatedlasname, "123456");

		String usernameactual = homepage.getUserName();
		Reporter.log("Actaul Username "+usernameactual);
		Assert.assertTrue(usernameactual.endsWith(updatedlasname));
		Reporter.log("...........Successfully verified Personal info changes...........");
	}

}
