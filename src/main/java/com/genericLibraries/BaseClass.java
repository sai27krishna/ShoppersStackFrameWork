package com.genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.PomPages.AddressFormPage;
import com.PomPages.CartPage;
import com.PomPages.HeadPhonesPage;
import com.PomPages.HomePage;
import com.PomPages.MyAddressPage;
import com.PomPages.MyProfilePage;
import com.PomPages.ShopperLoginPage;
import com.PomPages.SignUpPage;
import com.PomPages.WelcomePage;

public class BaseClass {

	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webutil;
	protected WebDriver driver;
	public static WebDriver sdriver;

	protected WelcomePage welcome;
	protected ShopperLoginPage login;
	protected HomePage home;
	protected SignUpPage signUp;
	protected MyProfilePage myProfile;
	protected MyAddressPage myAddress;
	protected HeadPhonesPage headPhone;
	protected CartPage cart;
	protected AddressFormPage address;

	@BeforeClass
	public void classConfiguration() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		webutil = new WebDriverUtility();

		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
	}

	@BeforeMethod
	public void methodCongiguration() {
		driver = webutil.navigateToApp(property.getData("browser"), property.getData("url"),
				Long.parseLong(property.getData("time")));
		sdriver = driver;

		welcome = new WelcomePage(driver);
		login = new ShopperLoginPage(driver);
		home = new HomePage(driver);
		signUp = new SignUpPage(driver);
		myProfile = new MyProfilePage(driver);
		myAddress = new MyAddressPage(driver);
		headPhone = new HeadPhonesPage(driver);
		cart = new CartPage(driver);
		address = new AddressFormPage(driver);
	}

	@AfterMethod
	public void methodTearDown() {
		home.clickProfileButton();
		home.clickLogout();
		excel.closeAllBrowsers();
	}

	@AfterClass
	public void classTearDown() {
		excel.closeExcel();
	}
}
