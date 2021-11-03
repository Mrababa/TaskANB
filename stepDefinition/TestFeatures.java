package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentTest;

import Utility.DataReader;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestFeatures {

	static WebDriver driver;
	ExtentTest logger;
	DataReader datareader = new DataReader();
	

	@Before
	public void intilizer() throws IOException, ParserConfigurationException, SAXException {

		
		if (System.getProperty("os.name").contains("Mac"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		}
		else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		}
		driver = new ChromeDriver();
		

	}

	@Given("^User on (.*) page$")
	public void I_visit_google(String PageTitle)
			throws IOException, ParserConfigurationException, SAXException, InterruptedException {

		System.out.println(PageTitle);

		driver.manage().window().maximize();
	
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		Assert.assertEquals(driver.getPageSource().contains(PageTitle), true, "The Page is not Displayed");
		

	}

	@When("^I search for (.*)$")
	public void search_for(String query) {

		Assert.assertEquals(true, false);
	}

	@And("^Chose (.*) as number of dependents$")
	public void FillNumberOfDependents(int Number) throws IOException, ParserConfigurationException, SAXException {

		new Select(driver.findElement(By.xpath(datareader.getElement("List_NumberOfDependants", "much-borrow"))))
				.selectByVisibleText(Number + "");

	}

	@And("^fill your income before tax field with (.*)$")
	public void FillYourIncome(String Amount) throws IOException, ParserConfigurationException, SAXException {

		driver.findElement(By.xpath(datareader.getElement("Txt_YourIncomeBeforeTax", "much-borrow"))).sendKeys(Amount);
	}

	@And("^fill Living Expenses field with (.*)$")
	public void FilLivingxpenses(String Amount) throws IOException, ParserConfigurationException, SAXException {

		driver.findElement(By.xpath(datareader.getElement("Txt_LivingExpenses", "much-borrow"))).sendKeys(Amount);
	}

	@And("^fill Other income field with (.*)$")
	public void FilOtherIncome(String Amount) throws IOException, ParserConfigurationException, SAXException {

		driver.findElement(By.xpath(datareader.getElement("Txt_YourOtherIncome", "much-borrow"))).sendKeys(Amount);
	}

	@And("^fill Current Home Loan Repayments field with (.*)$")
	public void FillCurrentHomeLoanRepayments(String Amount)
			throws IOException, ParserConfigurationException, SAXException {

		driver.findElement(By.xpath(datareader.getElement("Txt_CurrentHomeLoanRepayments", "much-borrow")))
				.sendKeys(Amount);
	}

	@And("^fill Other Loans repayments field with (.*)$")
	public void FillOtherLoans(String Amount) throws IOException, ParserConfigurationException, SAXException {

		driver.findElement(By.xpath(datareader.getElement("Txt_OtherLoans", "much-borrow"))).sendKeys(Amount);
	}

	@And("^fill other commitments field with (.*)$")
	public void FillotherCommitments(String Amount) throws IOException, ParserConfigurationException, SAXException {

		driver.findElement(By.xpath(datareader.getElement("Txt_OtherCommitments", "much-borrow"))).sendKeys(Amount);
	}

	@And("^fill Total credit card limits field with (.*)$")
	public void FillTotalCreditCardLimits(String Amount)
			throws IOException, ParserConfigurationException, SAXException, InterruptedException {

		driver.findElement(By.xpath(datareader.getElement("Txt_TotalCreditCardLimits", "much-borrow")))
				.sendKeys(Amount);
	}

	@And("^Chose Property type as (.*)$")
	public void ChoseHomeType(String ApplicationType) throws IOException, ParserConfigurationException, SAXException {

		driver.findElement(By.xpath(datareader.getElement("Radio_HomeToLiveIn", "much-borrow"))).click();
	}

	@Then("^borrowing estimate should be (.*)$")
	public void VerifyEstimationAMount(String Amount)
			throws IOException, ParserConfigurationException, SAXException, InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(driver
				.findElement(By.xpath(datareader.getElement("Label_borrowResultTextAmount", "much-borrow"))).getText(),
				Amount, "Amount miss match");

	}

	@Then("^call us message shouold appear$")
	public void VerifyCallUsMessage() throws IOException, ParserConfigurationException, SAXException {

		Assert.assertTrue(driver.findElement(By.xpath(datareader.getElement("Label_CallUsMessage", "much-borrow")))
				.isDisplayed());
	}

	@And("^Chose the application type as (.*)$")
	public void checkTitle(String ApplicationType) throws IOException, ParserConfigurationException, SAXException {

		if ("single".equalsIgnoreCase(ApplicationType)) {
			driver.findElement(By.xpath(datareader.getElement("Raido_application_type_single", "much-borrow"))).click();
		} else {
			driver.findElement(By.xpath(datareader.getElement("Radio_application_type_joint", "much-borrow"))).click();
		}

	}

	@Then("^Required field should be displayed$")
	public void VerfiyError() throws IOException, ParserConfigurationException, SAXException {

		Assert.assertEquals(
				driver.findElement(By.xpath(datareader.getElement("Error_Required", "much-borrow"))).isDisplayed(),
				true);

	}

	@When("^user click on work out how much i could borrow$")
	public void ClickOnHowMuchButton() throws IOException, ParserConfigurationException, SAXException {

		driver.findElement(By.xpath(datareader.getElement("Btn_WorkOutHowMuch", "much-borrow"))).click();
	}

	@After
	public void closeDriver() throws IOException {
		// driver.close();
	}
	
	

}
