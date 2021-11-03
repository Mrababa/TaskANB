package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.xml.sax.SAXException;

import Utility.DataReader;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestFeatures {

	WebDriver driver;

	DataReader datareader = new DataReader();

	@Before
	public void intilizer() throws IOException, ParserConfigurationException, SAXException {
		System.out.println(datareader.getElement("Language_English", "LoginPage"));

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();

	}

	@Given("^I am on How (.*) page$")
	public void I_visit_google(String PageTitle) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
		
		System.out.println(PageTitle);
			
		driver.manage().window().maximize();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		
		driver.findElement(By.xpath(datareader.getElement("application_type_single","much-borrow"))).click();
		
		
		Assert.assertEquals(driver.getPageSource().contains(PageTitle), true, "The Page is not Displayed");
		
	}

	@When("I search for (.*)")
	public void search_for(String query) {

		Assert.assertEquals(true, false);
	}

	@Then("the page title should start with {string}")
	public void checkTitle(String titleStartsWith) {

	}

	@After
	public void closeDriver() throws IOException {
	 driver.close();
	}

}
