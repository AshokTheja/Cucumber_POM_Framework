package com.ind.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ind.qa.testbase.TestBase;
import com.ind.qa.util.Ind_Utilities;

public class HomePage extends TestBase {

	@FindBy(css = ".gnav-MenuToggle-label.gnav-NavIcon")
	private WebElement account_Menu;

	@FindBy(xpath = "//a[@data-gnav-element-name='SearchPreferences']")
	private WebElement search_Prefereces;

	@FindBy(xpath = "//span[@alt='Indeed logo']")
	private WebElement ind_Home;

	@FindBy(css = ".gnav-AccountMenu-signOut")
	private WebElement signout_Btn;

	@FindBy(xpath = "//a[@class='gnav-PageLink is-highlighted with-border']//span[@class='gnav-PageLink-text']")
	private WebElement head_Txt;

	@FindBy(xpath = "//button[@class='icl-Button icl-Button--primary icl-Button--md icl-WhatWhere-button']")
	private WebElement search_Txt;

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, HomePage.this);
	}

	public ProfilePage navigatetoDesiredPage_FromAccountMenu(String required_Link)
			throws InterruptedException, IOException {

		Ind_Utilities.sync(3000);
		wait.until(ExpectedConditions.elementToBeClickable(account_Menu)).click();
		Ind_Utilities.sync(3000);
		List<WebElement> links = driver.findElements(By.xpath("//a[@class='gnav-AccountMenuLinks-link']//div"));
		for (WebElement required : links) {
			if (required.getText().equals(required_Link)) {
				required.click();
				break;
			}
		}

		return new ProfilePage();
	}

	public void navigate_to_FindJobs() throws InterruptedException {
		Ind_Utilities.sync(3000);
		ind_Home.click();
		Ind_Utilities.sync(3000);
	}

	public void signOut() throws InterruptedException {
		Ind_Utilities.sync(3000);
		wait.until(ExpectedConditions.elementToBeClickable(account_Menu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(signout_Btn)).click();
		Ind_Utilities.sync(3000);
	}

	public SearchPreferencePage navigateto_SearchPreferencesPage() throws InterruptedException, IOException {
		Ind_Utilities.sync(3000);
		wait.until(ExpectedConditions.elementToBeClickable(account_Menu)).click();
		Ind_Utilities.sync(3000);
		wait.until(ExpectedConditions.elementToBeClickable(search_Prefereces)).click();
		Ind_Utilities.sync(3000);

		return new SearchPreferencePage();
	}

	public void validate_Globalization_Lang_Samps(String text) throws InterruptedException {

		String head = head_Txt.getText();
		String search = search_Txt.getText();
		if (head.equals(text) && search.equals(text)) {
			System.out.println(text + ": Validation success");
		}
	}
}
