package com.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericLibraries.WebDriverUtility;

public class HomePage {

	@FindBy(xpath = "//button [@aria-label='Account settings']")
	private WebElement profileButton;

	@FindBy(xpath = "//li[.='My Profile']")
	private WebElement myProfile;
	
	@FindBy(xpath = "//li[.='Logout']")
	private WebElement logout;
	
	@FindBy(xpath = "//a[text()='Electronic']")
	private WebElement electronicTab;
	
	@FindBy(xpath = "//a[text()='Headphones']")
	private WebElement headPhoesLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickProfileButton() {
		profileButton.click();
	}

	public void selectMyProfile() {
		myProfile.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	public void mouseHoverToElectronic(WebDriverUtility web) {
		web.mouseHover(electronicTab);
	}
	
	public void clickHeadPhonesLink() {
		headPhoesLink.click();
	}

}
