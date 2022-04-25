package alertExample;

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

public class AlertTest {

	
	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		System.out.println("launch browser- app");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://only-testing-blog.blogspot.com/2013/11/new-test.html");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {
		System.out.println("close browser");
		Thread.sleep(4000);
		driver.close();
	}
	
	@Test
	public void simpleAlert() throws Exception {
		
		
		//Generic statement 
		//Alert/window/frame ----------SwitchTo
		//Alert
		
		//Generate an alert
		driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
		
		Thread.sleep(4000);
		//handle alert
		//action
		//accept/dismiss/getText/sendKeys
		
		Alert ele_simpleAlert = driver.switchTo().alert();
		
		//ele_simpleAlert.accept();			//click operation on OK button
		
		System.out.println(ele_simpleAlert.getText());
		ele_simpleAlert.dismiss();
		
		
	}
	
	
	@Test
	public void confirmAlert() throws Exception {
		
		
		//Generic statement 
		//Alert/window/frame ----------SwitchTo
		//Alert
		
		//Generate an alert
		driver.findElement(By.xpath("//button[text()='Show Me Confirmation']")).click();
		
		Thread.sleep(4000);
		//handle alert
		//action
		//accept/dismiss/getText/sendKeys
		
		Alert ele_confirmAlert = driver.switchTo().alert();
		
		//ele_simpleAlert.accept();			//click operation on OK button
		
		System.out.println(ele_confirmAlert.getText());
		ele_confirmAlert.accept();
		
		//validation step
		String actualAlertMessage = driver.findElement(By.cssSelector("div#demo")).getText();
		System.out.println(actualAlertMessage);
		Assert.assertTrue(actualAlertMessage.contains("OK"));
		
	}
	
	
	
	
	
	
}
