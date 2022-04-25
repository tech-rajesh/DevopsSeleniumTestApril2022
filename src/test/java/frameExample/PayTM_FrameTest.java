package frameExample;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
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

public class PayTM_FrameTest {

	
	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		System.out.println("launch browser- app");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://paytm.com/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {
		System.out.println("close browser");
		Thread.sleep(4000);
		driver.close();
	}
	
	
	
	
	@Test
	public void promptAlert() throws Exception {
		
		
		//Generate an alert
		driver.findElement(By.xpath("//span[contains(text(),'Sign')]")).click();
		
		Thread.sleep(4000);
		
		//Switch to frame
		driver.switchTo().frame(0);
		
		//watch videos - inside frame
		driver.findElement(By.xpath("//span[@ng-click=\"toggleIntroVideo()\"]")).click();
		
		
		String actualFrameHeading = driver.findElement(By.cssSelector(".heading")).getText();
		System.out.println(actualFrameHeading);
		
		//validation step
		Assert.assertEquals(actualFrameHeading, "To Login into your Paytm Web account");
		Assert.assertTrue(actualFrameHeading.contains("Paytm Web account"));
		
	}
	
	
	
	
	
	
}
