package com.ind.qa.stepDefinitions;

import java.io.IOException;

import com.ind.qa.pages.HomePage;
import com.ind.qa.pages.LoginPage;
import com.ind.qa.pages.ProfilePage;
import com.ind.qa.testbase.TestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Delete_Upload_Res_Ind_SD extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;

	public Delete_Upload_Res_Ind_SD() throws IOException {
		super();
	}

	@Given("^JobSeeker opens Browser and navigates to Application$")
	public void jobseeker_opens_Browser_and_navigates_to_Application() throws InterruptedException, IOException {
		loginPage = Initialization(prop.getProperty("browser"), prop.getProperty("url"));
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " : Successfully");
	}

	@When("^JobSeeker is on LoginPage$")
	public void jobseeker_is_on_LoginPage() {
		String signInPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(prop.getProperty("url"), signInPageUrl);
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " : Successfully");
	}

	@And("^JobSeeker enters username and password and clicks on login$")
	public void jobseeker_enters_username_and_password_and_clicks_on_login() throws InterruptedException, IOException {
		homePage = loginPage.Login(prop.getProperty("email"), prop.getProperty("password"));
		String homeTitle = driver.getTitle();
		Assert.assertEquals(prop.getProperty("hometitle"), homeTitle);
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " : Successfully");
	}

	@Then("^JobSeeker is on FindJobs page$")
	public void JobSeeker_is_on_FindJobs_page() {
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " : Successfully");
	}

	@Given("^JobSeeker click on Account Menu and clicks on Profile$")
	public void jobseeker_click_on_Account_Menu_and_clicks_on_Profile() throws InterruptedException, IOException {
		profilePage = homePage.navigatetoDesiredPage_FromAccountMenu(prop.getProperty("firstReqLink"));
	}

	@When("^JobSeeker navigates to Ind_Resume page$")
	public void jobseeker_navigates_to_Ind_Resume_page() {
		String currentTitle = driver.getTitle();
		if (prop.getProperty("firstReqTitle").equals(currentTitle)) {
			System.out.println(new Object() {
			}.getClass().getEnclosingMethod().getName() + " : Successfully");
		}
	}

	@Then("^JobSeeker validates and decides to upload the resume or not$")
	public void jobseeker_validates_and_decides_to_upload_the_resume_or_not() throws InterruptedException, IOException {
		boolean validation = profilePage.resume_validateUpdate();
		if (validation == false) {
			System.out.println(new Object() {
			}.getClass().getEnclosingMethod().getName() + " : upload not required as upload already done for the day");
		} else {
			System.out.println(new Object() {
			}.getClass().getEnclosingMethod().getName() + " : Uploaded now for the current day");
		}
	}

	@Given("^JobSeeker will navigate to FindJobs page$")
	public void jobseeker_will_navigate_to_FindJobs_page() throws InterruptedException {
		homePage.navigate_to_FindJobs();
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " : Successfully");
	}

	@Then("^JobSeeker Logsout and closes the browser$")
	public void jobseeker_Logsout_and_closes_the_browser() throws InterruptedException {
		homePage.signOut();
		tearDown();
	}
}
