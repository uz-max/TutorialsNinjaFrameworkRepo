package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;

	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProductElement;
	
	@FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
	private WebElement noProductMessagElement;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayStatusOfHPValidProduct() {
	
		boolean displayStatus = validHPProductElement.isDisplayed();
		return displayStatus;
	}
	
	public String retreiveNoProductMessageText() {
		
		String noProductMessageString = noProductMessagElement.getText();
		return noProductMessageString;
	}
}
