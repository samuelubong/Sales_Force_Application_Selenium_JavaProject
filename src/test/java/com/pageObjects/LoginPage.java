package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class LoginPage {

	public WebDriver ldriver;

	// Constructor

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	    //find username field element
		@FindBy(xpath="//input[@id='username']")
		@CacheLookup
		WebElement usernameField;

		//find password field element
		@FindBy(xpath="//input[@id='password']")
		@CacheLookup
		WebElement passwordField;

		//find login to sandbox button element
		@FindBy(xpath="//input[@id='Login']")
		@CacheLookup
		WebElement loginToSandbox;
		
		//find Forget Your Password element
		@FindBy(xpath="//a[@id='forgot_password_link']")
		@CacheLookup
	    WebElement forgetYourPasswordLink;
		
		//find Remember Me element
		@FindBy(xpath="//input[@id='rememberUn']")
		@CacheLookup
	    WebElement rememberMeCheckbox;

	    // find "invalid Credential text"
	    @FindBy(xpath = "//div[@id='error']")
	    @CacheLookup
	    WebElement invalidCredentialsText;

	// ==================Action methods===========================//

	// Send text to the email field
	public void enterUsername(String email) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(usernameField));
		usernameField.sendKeys(email);
	}

	// Send text to password field
	public void enterPassword(String pwd) {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.sendKeys(pwd);
	}

	// Click on Login to Sandbox button
	public void clickLoginToSandboxButton() {
		WebDriverWait wait = new WebDriverWait(ldriver, 25);
		wait.until(ExpectedConditions.visibilityOf(loginToSandbox));
		wait.until(ExpectedConditions.elementToBeClickable(loginToSandbox));
		loginToSandbox.click();
	}

	// display "invalid credentials" message
	public Boolean displayInvalidCredentialsMessage() {
		return invalidCredentialsText.isDisplayed();
	}

	// click on forgot password link
	public void clickOnForgotPasswordLink() {
		forgetYourPasswordLink.click();
	}

	// to display email text box in login page
	public Boolean isEmailTextFieldDisplayed() {
		return usernameField.isDisplayed();
	}

	// to display password text box in login page
	public Boolean isPasswordTextFieldDisplayed() {
		return passwordField.isDisplayed();
	}

	// to display submit button in login page
	public Boolean isLoginButtonDisplayed() {
		return loginToSandbox.isDisplayed();
	}

}

