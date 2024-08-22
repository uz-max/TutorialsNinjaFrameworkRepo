package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameFieldElement;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameFieldElement;
	
	@FindBy(id = "input-email")
	private WebElement emailAddressFieldElement;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneFieldElement;

	@FindBy(id = "input-password")
	private WebElement passwordFieldElement;
	
	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmFieldElement;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyFieldElement;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButtonElement;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOpElement;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarningElement;
	
	@FindBy(xpath = "//div[@class='text-danger']")
	private WebElement privacyPolicyWarningElement;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String firstName) {
		
		firstNameFieldElement.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		
		lastNameFieldElement.sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		
		emailAddressFieldElement.sendKeys(email);
	}
	
	public void enterTelephone(String telephoneText) {
		
		telephoneFieldElement.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		
		passwordFieldElement.sendKeys(passwordText);
	}
	
	public void enterconfirmPassword(String passwordText) {
		
		passwordConfirmFieldElement.sendKeys(passwordText);
	}
	
	public void selectPrivacyPolicy() {
		
		privacyPolicyFieldElement.click();
	}
	
	public void clickOnContinueButton() {
		
		continueButtonElement.click();
	}
	
	public void selectNewsletterOption() {
		
		yesNewsLetterOpElement.click();
	}
	
	public String retrieveDuplicateEmailWarning() {
		
		 String duplicateEmailWarningText = duplicateEmailWarningElement.getText();
		 return duplicateEmailWarningText;
	}
	
	public String retrievePrivacyPolicyWarning() {
		
		String privacyPolicyWarningText = privacyPolicyWarningElement.getText();
		return privacyPolicyWarningText;
	}

}
