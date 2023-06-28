package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"json:target/reports/cucumberReport.json", "html:target/reports/cucumberReport.html"}, 
		features = "C:/Users/leiss/Documents/Temp/08-Qzando-test/seleniumTest/src/test/resources/features",
		// tags = {"~@ignore"},
		glue = { "steps" })

@CucumberContextConfiguration
public class RunCucumberTest {

	public static WebDriver driver;

	@BeforeClass
	public static void start() {
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void stop() {
		driver.quit();
	}
}
