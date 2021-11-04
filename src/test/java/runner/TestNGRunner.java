package runner;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import com.report.CucumberExtentOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/testFeatures", glue = { "stepDefinition" }, tags = {
		"@SmokeTest" }, monochrome = true, plugin = {
				"com.report.CucumberExtent:target/cucumber-extent-reports/report.html" })

public class TestNGRunner extends AbstractTestNGCucumberTests {

	@BeforeClass
	public void beforeMethod() {
		CucumberExtentOptions.getInstance().setDocumentTitle("Assessment Report");
		CucumberExtentOptions.getInstance().setReportName("Created BY Mean");
	}

	@AfterTest
	public void get() throws IOException {

		File htmlFile = new File(System.getProperty("user.dir") + "/target/cucumber-extent-reports/report.html");
		Desktop.getDesktop().browse(htmlFile.toURI());
	}
}
