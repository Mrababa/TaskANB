package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class DriverManager {
	public static WebDriver driver;
	
	
	
	public static WebDriver getDriver() {
		if (System.getProperty("os.name").contains("Mac"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		}
		else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		}
		driver = new ChromeDriver();
		
		return driver;
	}
	
	public static String takeScreenshotAtEndOfTest() throws IOException {
	    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    String destination = System.getProperty("user.dir") + "/screenshots/" +  dateName
	            + ".png";
	   // String screenShot = System.getProperty("user.dir")+"\\Artifacts\\FileName.png";

        // Call Webdriver to click the screenshot.
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save the screenshot.
        FileUtils.copyFile(scrFile, new File(destination));
	    return destination;
	}

}
