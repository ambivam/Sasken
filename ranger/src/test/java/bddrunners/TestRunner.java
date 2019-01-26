package bddrunners;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
					"src/test/resources/saskenfeatures"
					},
				plugin= {"json:target/cucumber.json","html:target/site/cucumber-pretty"},				
				dryRun= false,
				glue = {"bddhooks","bddsaskenstepdefinitions"},
				tags= {"@SaskenRegression"},
				
				monochrome = true
		)

public class TestRunner {
	
	@AfterClass
	public static void writeExtentReport() {
		
		
	
	}
	


}
