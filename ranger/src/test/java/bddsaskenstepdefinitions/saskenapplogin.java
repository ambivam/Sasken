package bddsaskenstepdefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataproviders.ConfigFileReader;
import driverManager.WebDriverManager;
import pagesFactory.AppPageFactory;
import saskenpages.SaskenLoginPage;
import saskenpages.SaskenPortalLandingPage;

public class saskenapplogin {
	
	WebDriver driver;
	
	SaskenLoginPage loginpage;
	
	SaskenPortalLandingPage saskenLandingPage;
	
	AppPageFactory pagefactory;
	
	WebDriverManager webDriverManager;
	
	//****************************************
	
	@Given("^User launches the Application$")
	public void user_launches_the_Application() throws Throwable {
		driver=WebDriverManager.getDriver();
		driver.get(ConfigFileReader.getConfigFileReader().getSaskenApplicationUrl());
	}

	@Given("^Logins into the Application by providing credentials$")
	public void logins_into_the_Application_by_providing_credentials() throws Throwable {
		pagefactory = new AppPageFactory(driver);
		loginpage = pagefactory.getSaskenLoginPage();
		loginpage.enterUserName(ConfigFileReader.getConfigFileReader().getUserName());
		loginpage.enterPassword(ConfigFileReader.getConfigFileReader().getPassword());
		loginpage.clickOnLoginButton();
	}

	@Then("^Sasken Home page is displayed and \"([^\"]*)\" should be validated$")
	public void sasken_Home_page_is_displayed_and_should_be_validated(String elementTextTobeValidated) throws Throwable {
	    	
		saskenLandingPage = pagefactory.getSaskenPortalLandingPage();
		saskenLandingPage.validate(elementTextTobeValidated);
	    
	}

}
