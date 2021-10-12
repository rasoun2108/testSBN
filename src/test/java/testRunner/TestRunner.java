package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions 
( features="C://Users//nveenrm//eclipse-workspace//testSBNetwork//Features",
   glue = "stepDefinitions",
   monochrome = true,
   plugin= {"pretty","json:target/jsonLogin",
		   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
   
		
		)



public class TestRunner {

}
