package com.PomPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericLibraries.WebDriverUtility;

public class AddressFormPage {

	@FindBy(id = "Name")
	private WebElement nameTf;

	@FindBy(id = "House/Office Info.")
	private WebElement houseInfoTF;

	@FindBy(id = "Street Info")
	private WebElement streetInfoTF;

	@FindBy(id = "Landmark")
	private WebElement landmarkInfoTF;

	@FindBy(id = "Country")
	private WebElement countryDropdown;

	@FindBy(id = "State")
	private WebElement stateDropDown;

	@FindBy(id = "City")
	private WebElement cityDropDown;

	@FindBy(id = "Pincode")
	private WebElement pincodeTf;

	@FindBy(id = "Phone Number")
	private WebElement phoneNumberTF;

	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddressButton;

	public AddressFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void addAddressDetails(WebDriverUtility web, Map<String, String> details) {

		nameTf.sendKeys(details.get("Name"));
		houseInfoTF.sendKeys(details.get("House/Office Info."));
		streetInfoTF.sendKeys(details.get("Street Info"));
		landmarkInfoTF.sendKeys(details.get("Landmark"));

		web.selectFromDropdown(details.get("Country"), countryDropdown);
		web.selectFromDropdown(details.get("State"), stateDropDown);
		web.selectFromDropdown(details.get("City"), cityDropDown);

		pincodeTf.sendKeys(details.get("Pincode"));
		phoneNumberTF.sendKeys(details.get("Phone Number"));
		addAddressButton.click();
	}
}
