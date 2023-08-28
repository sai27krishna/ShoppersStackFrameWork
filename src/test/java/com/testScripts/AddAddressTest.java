package com.testScripts;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;

public class AddAddressTest extends BaseClass{
	
	//second commit
	
	@Test
	public void addAddressTest() throws InterruptedException {
		Map<String, String> map = excel.getData("Sheet1", "Add Address");
		welcome.clickloginButton();
		login.loginToApp(map.get("Email"), map.get("Password"));
		Thread.sleep(2000);
		home.clickProfileButton();
		Thread.sleep(2000);
		home.selectMyProfile();
		Thread.sleep(2000);
		myProfile.clickMyAddress();
		myAddress.clickAddress();
		address.addAddressDetails(webutil, map);
		Thread.sleep(2000);
		Assert.assertEquals(myAddress.getSuccessMessage(), "successfully added");
		Thread.sleep(5000);
	}

}
