package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class HomePage {
	
	WebDriver driver;
	
	//Objects
	@FindBy(xpath ="//span[text()='My Account']")
	private WebElement myAccountDropMenuElement;
	
	@FindBy(linkText = "Login")
	private WebElement loginOptionElement;
	
	@FindBy(linkText = "Register")
	private WebElement registerOptionElement;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchBoxFiElement;
	
	@FindBy(xpath = "//div[@id='search']/descendant::button")
	private WebElement searchButtonElement;
		
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public void clickOnMyAccount() {
		
		myAccountDropMenuElement.click();
	}
	
	public void selectLoginOption() {
		
		loginOptionElement.click();
	}
	
	public void selectRegisterOption() {
		
		registerOptionElement.click();
	}
	
	public void enterProductDetails(String productText) {
		
		searchBoxFiElement.sendKeys(productText);
	}
	
	public void clickOnSearchButton() {
		
		searchButtonElement.click();
	}

}
