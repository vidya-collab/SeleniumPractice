package hooks;

import java.io.ByteArrayInputStream;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utils.ConfigReader;
import utils.DriverManager;
import utils.LoggerLoad;

public class Hooks {
	private static WebDriver driver;
	private static DriverManager driverfactory;
	ConfigReader configFileReader = new ConfigReader();
	
	@Before
	public void before() throws Throwable {
		
		String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");	
		if (browser==null) {
			LoggerLoad.info("Testing on chrome");
			System.out.println(" about to open browser" + "chrome");
			driverfactory = new DriverManager();
			driver = driverfactory.initializeDrivers("chrome");
			driver.get(ConfigReader.getApplicationUrl());
			LoggerLoad.info("Initializing driver for : "+ "chrome");
		}
		else {
			driverfactory = new DriverManager();
			driver = driverfactory.initializeDrivers(browser);
			driver.get(ConfigReader.getApplicationUrl());
			LoggerLoad.info("Initializing driver for : "+ browser);
		}
	
	}
	

	@AfterStep
	public void afterstep(Scenario scenario) {
		if (scenario.isFailed()) {
			LoggerLoad.error("Steps Failed , Taking Screenshot");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My screenshot");
			Allure.addAttachment("Myscreenshot",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		
		}
	}
	


	@After
	public static void after() throws Throwable {
		LoggerLoad.info("Closing Driver");
		driverfactory.quitDriver();
	

}
}
