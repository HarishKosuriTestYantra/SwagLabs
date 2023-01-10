package com.SwagLabs.testScripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.ProductsPage;

public class ListOfProductsTest extends BaseClass {
	
	@Test(groups = "regression")
	public void displayListOfProducts() throws InterruptedException
	{
		ProductsPage prp = new ProductsPage(driver);
		List<WebElement> elements = prp.getInventoryProducts();
		for(WebElement ele:elements)
		{
			Reporter.log(ele.getText(), true);
		}
	}

}
