package com.ind.qa.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/main/java/com/ind/qa/features/Delete_Upload_Res_Ind.Feature" }, glue = {
		"com/ind/qa/stepDefinitions" }, format = { "pretty", "html:test-output", "json:json_output/cucumber.json",
				"junit:junit_xml/cucumber.xml" }, monochrome = true, dryRun = false)

public class Delete_Upload_Res_Ind_TestRunner {

}
