package com.cucumber.pageobjectmodel.runner;

import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
 
@CucumberOptions(
		features = {"src/test/resources/features/HRMLoginPage.feature" },
		glue = "com.cucumber.pageobjectmodel",
		plugin = { "html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml" },
		
		monochrome = true
		)





public class CucumberRunnerTest {
	
	
	
	
 
}