package com.test.shridhara.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.shridhara.baselibrary.BasePage;

/**
 * @author shridhara.jayaram
 *
 */
public class CataloguePage extends BasePage {
	private String itemxpath = "(//ul[@class='product_list grid row']//li)[{i}]";
	private String cat_item_price_x = ".//span[@itemprop='price']";
	private String cat_item_description_x = ".//p[@itemprop='description']";

	public CataloguePage(WebDriver driver) {
		super(driver);
	}

	/*
	 * @param index --Item will be selected based on index provided.
	 * 
	 * @return
	 */
	public ConfirmationPage clickOnCatalogueItem(int index) {
		find(By.xpath(itemxpath.replace("{i}", String.valueOf(index)))).click();
		return new ConfirmationPage(driver);
	}

	/**
	 * @param index_of_item
	 * @return String
	 */
	public String selectItemAndStorePrice(int index_of_item) {

		WebElement itemelement = find(By.xpath(itemxpath.replace("{i}", String.valueOf(index_of_item))));
		return itemelement.findElement(By.xpath(cat_item_price_x)).getText();

	}

	/**
	 * @param index_of_item
	 * @return String
	 */
	public String selectItemAndStoreDescription(int index_of_item) {

		WebElement itemelement = find(By.xpath(itemxpath.replace("{i}", String.valueOf(index_of_item))));
		return itemelement.findElement(By.xpath(cat_item_description_x)).getText();

	}

}
