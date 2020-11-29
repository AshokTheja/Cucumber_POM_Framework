package com.ind.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ind.qa.testbase.TestBase;
import com.ind.qa.util.Ind_Utilities;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//span[text()='Sign in']")
	private WebElement signIn;

	@FindBy(css = "#login-email-input")
	private WebElement username;

	@FindBy(css = "#login-password-input")
	private WebElement password;

	@FindBy(xpath = "//span[@class='icl-Checkbox-controlIndicator icl-Checkbox--sm']")
	private WebElement keepMeSignedIn;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement sing_In;

	// Initializing Super class construcotr and current class elements
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, LoginPage.this);
	}

	// Functions
	public HomePage Login(String userName, String passWord) throws InterruptedException, IOException {
		signIn.click();
		Ind_Utilities.sync(3000);
		wait.until(ExpectedConditions.elementToBeClickable(username)).sendKeys(userName);
		wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(passWord);
		if (!keepMeSignedIn.isSelected())
			keepMeSignedIn.click();
		wait.until(ExpectedConditions.elementToBeClickable(sing_In)).click();
		Ind_Utilities.sync(5000);
		return new HomePage();
	}

}
