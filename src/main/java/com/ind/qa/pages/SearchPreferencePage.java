package com.ind.qa.pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ind.qa.testbase.TestBase;
import com.ind.qa.util.Ind_Utilities;

public class SearchPreferencePage extends TestBase {

	@FindBy(xpath = "//select[@name='hl'] ")
	private WebElement select_Lang_DD;

	@FindBy(css = ".icl-Button.icl-Button--primary.icl-Button--md")
	private WebElement accept_Selection;

	public SearchPreferencePage() throws IOException {
		super();
		PageFactory.initElements(driver, SearchPreferencePage.this);
	}

	public void select_Globalization_Lang_Samps(String lang) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0]. scrollIntoView(true);", select_Lang_DD);
		Select select = new Select(select_Lang_DD);
		select.selectByValue(lang);
		Ind_Utilities.sync(3000);
		accept_Selection.click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		Ind_Utilities.sync(5000);
	}
}
