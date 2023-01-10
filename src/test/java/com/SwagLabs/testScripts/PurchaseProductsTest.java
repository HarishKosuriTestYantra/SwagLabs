package com.SwagLabs.testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.CartPage;
import objectRepository.CheckOutPage;
import objectRepository.ProductsPage;
import objectRepository.TshirtPage;

public class PurchaseProductsTest extends BaseClass{
	
	@Test(groups = "smoke")
	public void aorderTshirtTest()
	{
		ProductsPage prp = new ProductsPage(driver);
		prp.clickOnTshirtLink();
		TshirtPage tp = new TshirtPage(driver);
		tp.clickOnCart();
		prp.clickOnCartIcon();
		CartPage cp = new CartPage(driver);
		cp.clickOnCheckOutButton();
		CheckOutPage cop = new CheckOutPage(driver);
		cop.userInfo(jUtil.fakeData("firstname"), jUtil.fakeData("lastname"), jUtil.fakeData("pincode"));
		cop.clickOnContinueButton();
		cop.clickOnFinishButton();
		String checkoutMsg = cop.getcheckOutTabText();
		Reporter.log(checkoutMsg, true);
		Assert.assertTrue(checkoutMsg.toLowerCase().contains("complete"));
		cop.clickOnBackToProductsButton();
		
	}

}
