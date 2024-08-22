package com.tutorialsninja.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tuturialsninja.qa.utils.Utilities;

public class Register extends Base{
	
	//Global driver declaration
	WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		
		loadPropertiesFile();
		driver = InitialiseBrowserAndOpenApplication(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectRegisterOption();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test(priority = 1)
	public void VerifyRegisteringAnAccountWithMandatoryFields() {
		
		//Registering
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName("Test1");
		registerPage.enterLastName("User");
		registerPage.enterEmail("amotooricap9"+Utilities.generateTimeStamp()+"@gmail.com");
		registerPage.enterTelephone("1234567890");
		registerPage.enterPassword("12345");
		registerPage.enterconfirmPassword("12345");
		registerPage.selectPrivacyPolicy();
		registerPage.clickOnContinueButton();
		
		
		//find actual message xpath and compare with expected
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		String actualSuccessMessageString = accountSuccessPage.retrieveAccountSuccessMessage();
		Assert.assertEquals(actualSuccessMessageString,"Your Account Has Been Created!","Account successpage not found");
		
	}
	
	@Test(priority = 2)
	public void VerifyRegisteringAnAccountWithAllFields() {
		
		//Registering
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName("Test1");
		registerPage.enterLastName("User");
		registerPage.enterEmail("amotooricap9"+Utilities.generateTimeStamp()+"@gmail.com");
		registerPage.enterTelephone("1234567890");
		registerPage.enterPassword("12345");
		registerPage.enterconfirmPassword("12345");
		registerPage.selectNewsletterOption();//Including Newsletter option also
		registerPage.selectPrivacyPolicy();
		registerPage.clickOnContinueButton();
				
		//find actual message xpath and compare with expected
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		String actualSuccessMessageString = accountSuccessPage.retrieveAccountSuccessMessage();
		Assert.assertEquals(actualSuccessMessageString,"Your Account Has Been Created!","Account successpage not found");
		
	}
	
	@Test(priority = 3)
	public void VerifyRegisteringAnAccountWithExistingEmail() {
		
		//Registering
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName("Test1");
		registerPage.enterLastName("User");
		registerPage.enterEmail("amotooricap9@gmail.com");
		registerPage.enterTelephone("1234567890");
		registerPage.enterPassword("12345");
		registerPage.enterconfirmPassword("12345");
		
		registerPage.selectPrivacyPolicy();
		registerPage.clickOnContinueButton();
		
		//find actual message xpath and compare with expected
		String actualWarning = registerPage.retrieveDuplicateEmailWarning();
		Assert.assertTrue(actualWarning.contains("Warning: E-Mail Address is already registered!"),"Warning message is not displayed");
		
	}
	
	@Test(priority = 4)
	public void VerifyRegisteringAnAccountWithEmptyMandatoryFields() {
				
		//Registering
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickOnContinueButton();
		
		
		//find actual message xpath and compare with expected
		String actualWarning = registerPage.retrievePrivacyPolicyWarning();
		
		Assert.assertTrue(actualWarning.contains("First Name must be between 1 and 32 characters!"),"Email Warning message is not displayed");

	}
	
}
