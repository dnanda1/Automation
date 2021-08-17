package com.cucumber.pageobjectmodel.stepdefinations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.pageobjectmodel.definitions.HomePage;
import com.cucumber.pageobjectmodel.definitions.Login;
import com.cucumber.pageobjectmodel.definitions.LogoutPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.cucumber.pageobjectmodel.testbase.TestBase;

public class LoginPageDefinitions extends TestBase {

	public LoginPageDefinitions() throws IOException {
		super();

	}

	TestBase testBase;

	Login objLogin;

	HomePage objHomePage;

	LogoutPage logoutpage;

	String URL;
	String browser;
	public static WebDriver driver;

	@Before
	public void setup() throws IOException {

		testBase = new TestBase();
		URL = prop.getProperty("url");
		browser = prop.getProperty("BrowserName");

		driver = Launch(browser);
		driver.get(URL);

	}

	@Given("User is on HRMLogin page")
	public void loginTest() {

		objLogin = new Login(driver);

		String loginPageTitle = objLogin.getLoginTitle();
		Assert.assertTrue(loginPageTitle.contains("LOGIN Panel"));

	}

	@When("User enters username as {string} and password as {string}")
	public void HomeTest(String userName, String passWord) {

		objLogin.login(userName, passWord);

		objHomePage = new HomePage(driver);

	}

	@Then("User should be able to login sucessfully and new page open")
	public void verify() {

		Assert.assertTrue(objHomePage.getHomePageText().contains("Welcome"));
	}

	@Then("User should not be able to login sucessfully and new page should not open")
	public void verifyinvalidcredentials() {

		Assert.assertTrue(objLogin.getinvalidcredentials().contains("Invalid credentials"));

	}

	@Then("User should successfully able to logout")
	public void logout_user() {
		logoutpage = new LogoutPage(driver);

		logoutpage.getwelcomelink();
		logoutpage.getlogoutlink();

	}

	@And("User should be able to redirect to login screen")
	public void VerifyLoginScreenAfterLogout() {

		Assert.assertTrue(logoutpage.getverifyloginpanel().contains("LOGIN Panel"));

	}

	@After
	public void closeBrowsers() {

		driver.close();
		driver.quit();
	}

}