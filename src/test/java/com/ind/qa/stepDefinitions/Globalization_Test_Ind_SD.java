package com.ind.qa.stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;

import com.ind.qa.pages.HomePage;
import com.ind.qa.pages.LoginPage;
import com.ind.qa.pages.ProfilePage;
import com.ind.qa.pages.SearchPreferencePage;
import com.ind.qa.testbase.TestBase;
import com.ind.qa.util.Ind_Utilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Globalization_Test_Ind_SD extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	SearchPreferencePage searchPreferencePage;

	Ind_Utilities data = new Ind_Utilities();
	ArrayList<String> reqDataList = data.extractExcelcontentByColumnIndex("Globalization_Testing_ind");
	String browser = reqDataList.get(1).trim();
	String url = reqDataList.get(2).trim();
	String email = reqDataList.get(3).trim();
	String password = reqDataList.get(4).trim();
	String languages = reqDataList.get(5).trim();
	String validation_Text = reqDataList.get(6).trim();

	public Globalization_Test_Ind_SD() throws IOException {
		super();
	}

	@Given("^Script opens browser and navigates to application$")
	public void script_opens_browser_and_navigates_to_application() throws InterruptedException, IOException {
		loginPage = Initialization(browser, url);
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " : Successfully");
	}

	@When("^Script logs into the application$")
	public void script_logs_into_the_application() throws InterruptedException, IOException {
		homePage = loginPage.Login(email, password);
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " : Successfully");
	}

	@Then("^Script clicks on menu and clicks on search preferences and select desired interface language and validtes text in homepage for the selected language$")
	public void script_clicks_on_menu_and_clicks_on_search_preferences_and_select_desired_interface_language_and_validtes_text_in_homepage_for_the_selected_language()
			throws Throwable {
		String[] langs = languages.split(",");
		String[] texts = validation_Text.split(",");
		int i = 0;
		for (String lang : langs) {
			while (i <= texts.length - 1) {
				searchPreferencePage = homePage.navigateto_SearchPreferencesPage();
				searchPreferencePage.select_Globalization_Lang_Samps(lang);
				homePage.validate_Globalization_Lang_Samps(texts[i]);
				i++;
				break;
			}
		}
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " : Successfully");
	}

	@Then("^Script logouts from the application and closes the browser$")
	public void script_logouts_from_the_application_and_closes_the_browser() throws InterruptedException {
		homePage.signOut();
		tearDown();
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " : Successfully");
	}

}
