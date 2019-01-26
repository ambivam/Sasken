package bddhooks;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driverManager.WebDriverManager;
import utilities.Log;
import utilities.SeleniumHelper;


public class hooks {

	@Before
	public void Before(Scenario scenario) {
		String strScenario = scenario.getName();
		SeleniumHelper.setScenario(scenario);
		Log.initializeLog();
		Log.info("**********************************************");
		Log.info(" Started Working on Scenario : "+scenario.getName());
		Log.info("**********************************************");

	}

	@After
	public void After(Scenario scenario) {
		String strScenario = scenario.getName();
		/*RangerSeleniumHelper.setScenario(scenario);
		if (scenario.isFailed()) {
			WebDriverManager webdriver=new WebDriverManager();
			WebDriver driver =webdriver.getDriver();
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); //stick it in the report

		}*/

		/*Log.info("############## Ending Scenario " +strScenario + "##############");*/
		Log.info("**********************************************");
		Log.info(" Completed Working on Scenario : "+scenario.getName());
		Log.info("**********************************************");
		//Reporter.addStepLog("Into Hooks - Closing the driver");		
		WebDriverManager.closeDriver();

	}

}
