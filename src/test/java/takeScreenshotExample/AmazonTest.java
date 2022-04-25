package takeScreenshotExample;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

	
	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		System.out.println("launch browser- app");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {
		System.out.println("close browser");
		Thread.sleep(4000);
		driver.close();
	}
	
	@Test
	public void searchItems() throws Exception {
		
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		
		Thread.sleep(4000);
		//Take screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetLocation = new File("./screenshot_coforge/AmazonTest_iphone.png");
		
		FileUtils.copyFile(screenshotFile, targetLocation);
		
	}
	
	@Test(priority = 1)
	public void verifyAppTitle() {
		
		String actualAppTitle = driver.getTitle();
		String expectedTitle = "Amazon.in : iphone";
		
		//validation Step
		
//		if(actualAppTitle.equals(expectedTitle)) {
//			
//			System.out.println("passed");
//		}
//		else {
//			
//			System.out.println("failed");
//		}
		
		
		Assert.assertEquals(actualAppTitle, expectedTitle);
		
	}
	
	
	
	
}
