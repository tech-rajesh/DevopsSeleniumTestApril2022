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

public class AlertTest2 {

	
	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		System.out.println("launch browser- app");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Switchto");
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
		driver.findElement(By.id("prompt")).click();
		
		Thread.sleep(4000);
		//handle alert
		//action
		//accept/dismiss/getText/sendKeys
		
		String name = "Abhishek";
		Alert ele_promptAlert = driver.switchTo().alert();
		
		//ele_simpleAlert.accept();			//click operation on OK button
		
		System.out.println(ele_promptAlert.getText());
		
		//sendkeys - enter value on alert
		ele_promptAlert.sendKeys(name);
		
		
		ele_promptAlert.accept();
		
		//validation step
		String actualAlertMessage = driver.findElement(By.id("demo")).getText();
		System.out.println(actualAlertMessage);
		Assert.assertTrue(actualAlertMessage.contains(name));
		
	}
	
	
	
	
	
	
}
