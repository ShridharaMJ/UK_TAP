package com.test.shridhara.pom;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.shridhara.baselibrary.BasePage;

public class AccountInfoPage extends BasePage {

	public AccountInfoPage(WebDriver driver) {
		super(driver);
	}

	By order_history_link=By.xpath("//span[text()='Order history and details']");
	By table_orders_x=By.xpath("//a[@class='color-myaccount']");
	By my_personal_info_x=By.xpath("//span[text()='My personal information']");
	By lastname_x=By.id("lastname");
	By password_x=By.id("old_passwd");
	By SaveChages_x=By.xpath("//button[@name='submitIdentity']");
	
	public void clickOnOrderHistory() {
		find(order_history_link).click();

	}
	
	
	//Extract order id and store ot in list.
	
	public List<String> getOrderIds() {
		List<WebElement> eles=findEles(table_orders_x);
	return eles.stream().map(e->e.getText().trim()).collect(Collectors.toList());

	}
	
	
	public void clickMyPersonalInfo() {
		
		find(my_personal_info_x).click();
	}
	
	
	// hardcoding method,Becaus erunning out of time, in Acuatl POM we have to create methods for each action 
	
	public void updated(String lastname,String password) {
	
		
		
		type(lastname_x, lastname);
		type(password_x,password);
		find(SaveChages_x).click();
				
		
	}
	
}
