package com.testScripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.genericLibraries.BaseClass;


public class RegisterShopperTest extends BaseClass {
	
	@Test
	public void createAccountTest() {
		welcome.clickloginButton();
		login.clickcreateAccountButton();
		
		Map<String, String> map = excel.getData("sheet1", "Shopper Registration");
		int randomNum = jutil.generateRandomNum(100);
		String email = randomNum+map.get("Email Address");
		String pwd = map.get("Password") + randomNum;
		
		signUp.createUserAccount(map.get("First Name"),map.get("Last Name"), map.get("Gender"), map.get("Phone Number"), email, pwd);
		
		welcome.clickloginButton();
		login.loginToApp(map.get("Email Address"),map.get("Password"));
		
		Assert.assertTrue(driver.getTitle().contains("Home"));
	}
	

}
