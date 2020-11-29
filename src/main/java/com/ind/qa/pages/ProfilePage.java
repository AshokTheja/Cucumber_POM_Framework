package com.ind.qa.pages;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ind.qa.testbase.TestBase;
import com.ind.qa.util.Ind_Utilities;

public class ProfilePage extends TestBase {

	@FindBy(xpath = "//span[@class='subTitle-3b0-O uploadTime-Mgg_p spanBlock-1zjHQ fileName-2JvMw spanBlock-1zjHQ']")
	private WebElement resume_Last_Updated_Date;

	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement delete_Resume;

	@FindBy(xpath = "//button[@data-tn-element='removeResumeConfirm']")
	private WebElement delete_Confirm;

	@FindBy(css = ".buttonInner-3CbOF")
	private WebElement upload_Resume;

	public ProfilePage() throws IOException {
		super();
		PageFactory.initElements(driver, ProfilePage.this);
	}

	public boolean resume_validateUpdate() throws InterruptedException, IOException {
		boolean decision;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String current = dtf.format(now);
		Ind_Utilities.sync(3000);
		String datatobeValidated = resume_Last_Updated_Date.getText();
		String[] req = datatobeValidated.split(" ");
		String reqDate = req[1];
		if (current.equals(reqDate)) {
			decision = false;
		} else {
			decision = true;
			delete_Resume.click();
			wait.until(ExpectedConditions.elementToBeClickable(delete_Confirm)).click();
			Ind_Utilities.sync(5000);
			wait.until(ExpectedConditions.elementToBeClickable(upload_Resume)).click();
			Runtime.getRuntime().exec("D:\\D\\Preparation_2.0\\Practice_Help\\AutoIt Exe files\\UploadInD.exe");
			Ind_Utilities.sync(5000);
			wait.until(ExpectedConditions.visibilityOf(resume_Last_Updated_Date));
		}
		return decision;
	}

	

}
