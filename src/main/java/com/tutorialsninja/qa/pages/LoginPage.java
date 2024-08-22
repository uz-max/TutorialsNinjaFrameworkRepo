package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Text;

public class LoginPage {
	
	WebDriver driver;
	
	//Objects for Login Page
	@FindBy(id = "input-email")
	private WebElement emailAddressField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNotMatchWarning;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public void enterEmailAddress(String emailText) {
		
		emailAddressField.sendKeys(emailText);
	}
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
	}
	public void clickOnLoginButton() {
		
		loginButton.click();
	}
	public String retrieveEmailPasswordNotMatchingWarningMessageText() {
		
		String warningText = emailPasswordNotMatchWarning.getText();
		return warningText;
	}

}
