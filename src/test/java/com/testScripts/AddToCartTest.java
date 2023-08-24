package com.testScripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;

public class AddToCartTest extends BaseClass {
	
	@Test
	public void addToCartTest() throws InterruptedException {
	Map<String, String> map = excel.getData("Sheet1", "Add to cart");
	welcome.clickloginButton();
	login.loginToApp(map.get("Email"), map.get("Password"));
	Thread.sleep(2000);
	home.clickHeadPhonesLink();
	headPhone.clickAddToCart();
	Thread.sleep(3000);
	Assert.assertEquals(headPhone.getAddToCartText(), "ADDED");
	String itemName = headPhone.getItemName();
	headPhone.clickOnCartIcon();
	Assert.assertTrue(cart.getCartItem().equalsIgnoreCase(itemName));
	}
}
