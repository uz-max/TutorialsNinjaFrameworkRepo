package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class Search extends Base {
	
	WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		
		loadPropertiesFile();
		driver = InitialiseBrowserAndOpenApplication(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
			
			driver.quit();
			
	}
	
	
	
	@Test(priority = 1)
	public void VerifySearchWithValidProduct() {
		
		HomePage homePage = new HomePage(driver);
		homePage.enterProductDetails("HP");
		homePage.clickOnSearchButton();
		
		//assert
		SearchPage searchPage = new SearchPage(driver);
		
		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(),"Product Not Found");
		
	}
	
	@Test(priority = 2)
	public void VerifySearchWithInvalidProduct() {
			
		HomePage homePage = new HomePage(driver);
		homePage.enterProductDetails("sample");
		homePage.clickOnSearchButton();
			
		//assert
		SearchPage searchPage = new SearchPage(driver);
		String actualSearchMessageString = searchPage.retreiveNoProductMessageText();
		Assert.assertEquals(actualSearchMessageString,"There is no product that matches the search criteria.","Expected Error Message Not Found");
			
	}
	
	@Test(priority = 3)
	public void VerifySearchWithoutAnyProduct() {
			
			HomePage homePage = new HomePage(driver);
			homePage.clickOnSearchButton();
			
			//assert
			SearchPage searchPage = new SearchPage(driver);
			String actualSearchMessageString = searchPage.retreiveNoProductMessageText();
			Assert.assertEquals(actualSearchMessageString,"There is no product that matches the search criteria.","Expected Error Message Not Found");
			
	}

}