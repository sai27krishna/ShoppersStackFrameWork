package com.PomPages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	@FindBy(id = "First Name")
	private WebElement firstNameTF;

	@FindBy(id = "Last Name")
	private WebElement lastNameTF;

	@FindBy(xpath = "//div[@id='Gender']/descendant::label/span[2]")
	private List<WebElement> genderRadioButtons;

	@FindBy(id = "Phone Number")
	private WebElement phoneNumberTF;

	@FindBy(id = "Email Address")
	private WebElement emailAddressTF;

	@FindBy(id = "Password")
	private WebElement passwordTF;

	@FindBy(id = "Confirm Password")
	private WebElement confirmPasswordTF;

	@FindBy(id = "Terms and Conditions")
	private WebElement termsAndConditionsCB;

	@FindBy(xpath = "//button[text()='Register']")
	private WebElement registerButton;

	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createUserAccount(String firstName, String lastName, String expecedGender, String phoneNum,String email, String password) {
		firstNameTF.sendKeys(firstName);
		lastNameTF.sendKeys(lastName);

		for (WebElement element : genderRadioButtons) {
			String gender = element.getText();
			if (gender.equals(expecedGender)) {
				element.click();
				break;
			}
		}

		phoneNumberTF.sendKeys(phoneNum);

		emailAddressTF.sendKeys(email);

		passwordTF.sendKeys(password);

		confirmPasswordTF.sendKeys(password);

		termsAndConditionsCB.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		registerButton.click();
	}

}
