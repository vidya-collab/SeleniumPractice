package testrunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


		@CucumberOptions(

				plugin = {"pretty", "html:target/TestingWebsite.html",
						"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
						"html:target/cucumber-reports/cucumberReport.html",
						"json:target/cucumber-reports/cucumberReport.json",
						//"com.aventstack.chaintest.plugins.ChainTestCucumberListener:"
						 }, //reporting purpose ,chaintset = "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"

				

				monochrome=false, 
				tags ="@FilenotUploadAlert", 
				//features = {"C:\\Users\\Vidya\\eclipse-workspace\\Selenium_Practice\\src\\test\\resources\\features\\Checkbox.feature"}, 
				features = {"src/test/resources/features/"},
				glue= {"stepdefinitions","hooks"})
		

		public class TestRunner extends AbstractTestNGCucumberTests {
			
//			@Override
		    @DataProvider(parallel =false)
		    public Object[][]  scenarios() {
						
				return super.scenarios();
				
		    }
		}


	