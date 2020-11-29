$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/com/ind/qa/features/Ind_Globalization.Feature");
formatter.feature({
  "line": 1,
  "name": "ind App Globalization samps Automation",
  "description": "",
  "id": "ind-app-globalization-samps-automation",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "ind App Globalization samps Automation",
  "description": "",
  "id": "ind-app-globalization-samps-automation;ind-app-globalization-samps-automation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Script opens browser and navigates to application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Script logs into the application",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Script clicks on menu and clicks on search preferences and select desired interface language and validtes text in homepage for the selected language",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Script logouts from the application and closes the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Globalization_Test_Ind_SD.script_opens_browser_and_navigates_to_application()"
});
formatter.result({
  "duration": 12900566700,
  "status": "passed"
});
formatter.match({
  "location": "Globalization_Test_Ind_SD.script_logs_into_the_application()"
});
formatter.result({
  "duration": 8589902800,
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate an element using xpath\u003d//button[text()\u003d\u0027Sign In\u0027]\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027ASHOK\u0027, ip: \u0027192.168.43.70\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002714.0.2\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy19.click(Unknown Source)\r\n\tat com.ind.qa.pages.LoginPage.Login(LoginPage.java:44)\r\n\tat com.ind.qa.stepDefinitions.Globalization_Test_Ind_SD.script_logs_into_the_application(Globalization_Test_Ind_SD.java:46)\r\n\tat ✽.When Script logs into the application(src/main/java/com/ind/qa/features/Ind_Globalization.Feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Globalization_Test_Ind_SD.script_clicks_on_menu_and_clicks_on_search_preferences_and_select_desired_interface_language_and_validtes_text_in_homepage_for_the_selected_language()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Globalization_Test_Ind_SD.script_logouts_from_the_application_and_closes_the_browser()"
});
formatter.result({
  "status": "skipped"
});
});