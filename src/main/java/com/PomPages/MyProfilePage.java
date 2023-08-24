package com.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	
	@FindBy(xpath = "//div[text()='My Addresses']")
	private WebElement myAddressesLink;
	
	public MyProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickMyAddress() {
		myAddressesLink.click();
	}
}
