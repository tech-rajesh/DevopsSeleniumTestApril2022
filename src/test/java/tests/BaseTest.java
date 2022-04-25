package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import configExample.ReadDataFromConfigExample;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class BaseTest {

	
	WebDriver driver;
	LoginPage lp;
	ReadDataFromConfigExample conf;

	@BeforeTest
	public void launchApp() throws Exception {

		System.out.println("launch browser- app");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		conf = new ReadDataFromConfigExample();
		System.out.println(conf.getAppURL());
		
		driver.get(conf.getAppURL());
		driver.manage().window().maximize();
		//Actions act = new Actions(driver);
		lp = new LoginPage(driver);

	}

	@AfterTest
	public void closeApp() throws Exception {
		System.out.println("close browser");
		Thread.sleep(4000);
		driver.close();
	}
	
	@AfterMethod
	public void delayAfterEachMethod() throws Exception {
		System.out.println("Executed after each method");
		Thread.sleep(2000);
		
	}
	
	
}
