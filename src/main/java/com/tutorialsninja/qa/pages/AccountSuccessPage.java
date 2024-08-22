package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement accountSuccessPageHeadingElement;
	
	public AccountSuccessPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String retrieveAccountSuccessMessage() {
		
		String accountSuccessPageHeadingString = accountSuccessPageHeadingElement.getText();
		return accountSuccessPageHeadingString;
	}

}
