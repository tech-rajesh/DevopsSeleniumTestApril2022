package controlExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestSample {

	
	WebDriver driver;
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("http://only-testing-blog.blogspot.com/2013/11/new-test.html");
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		//
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void closeApp() {
		
		driver.close();
		
	}
}
