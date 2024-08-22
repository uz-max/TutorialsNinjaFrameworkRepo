package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tuturialsninja.qa.utils.Utilities;

public class Login extends Base {
	
	//Global driver declaration
	WebDriver driver;
		
		@BeforeMethod
		public void Setup() {
			
		//Directly using load file becoz Base is already parent of Login class	
		loadPropertiesFile();	
		driver = InitialiseBrowserAndOpenApplication(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		
	}
	
	//It will at end of every method
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

	@DataProvider(name = "loginCredentials")
	public Object[][] getData() {
	    return new Object[][] {
	        {"amotooricap9@gmail.com", "12345"},
	        
	    };
	}
	
	
	@Test(priority = 1, dataProvider = "loginCredentials")
	public void verifyLoginWithValidCredentials(String email, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
	
		//Assertions
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourInformationOption(),"Edit your credentials");
		
	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress("amotooricap9"+Utilities.generateTimeStamp()+"@gmail.com");
		loginPage.enterPassword("567456");
		loginPage.clickOnLoginButton();
		
		
		//Assertions
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessageString = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessageString), "Expected warning message is not Displayed");
		
	}
		
	
	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress("amotooricap9@gmail.com");
		loginPage.enterPassword("8787");
		loginPage.clickOnLoginButton();
		
		//Assertions
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessageString = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessageString), "Expected warning message is not Displayed");
		
	}
	
	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress("amotooricap9@gmail.com");
		loginPage.enterPassword("8999");
		loginPage.clickOnLoginButton();
		
		
		//Assertions
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessageString = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessageString), "Expected warning message is not Displayed");
		

	}
	
	@Test(priority = 5)
	public void verifyLoginWithBlankCredentials() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnLoginButton();
		
		
		//Assertions
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessageString = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessageString), "Expected warning message is not Displayed");
		

	}
	
	
}
	
		
	

