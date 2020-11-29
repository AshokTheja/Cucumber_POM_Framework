package com.ind.qa.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ind.qa.pages.LoginPage;

public class TestBase {

	protected static Properties prop;
	protected static WebDriver driver;
	protected static WebDriverWait wait;

	public TestBase() throws IOException {
		FileInputStream fis = new FileInputStream("./src/main/java/com/ind/qa/config/config.Properties");
		prop = new Properties();
		prop.load(fis);
	}

	public static LoginPage Initialization(String browser, String url) throws InterruptedException, IOException {

		if ((browser).equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("Disable-popup-blocking");
			options.addArguments("--incognito");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			driver = new ChromeDriver(options);

		} else if ((browser).equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");

			// For getting specific Profile.
			ProfilesIni profiles = new ProfilesIni();
			FirefoxProfile fxProfile = profiles.getProfile("Automation New");

			// Linking profile to options.
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(fxProfile);
			driver = new FirefoxDriver(options);
		}

		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
		driver.get(url);

		return new LoginPage();

	}

	public static void tearDown() {
		driver.quit();
	}
}
