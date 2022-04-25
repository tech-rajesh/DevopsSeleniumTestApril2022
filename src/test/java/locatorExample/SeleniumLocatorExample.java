package locatorExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumLocatorExample extends BaseTest {

	@Test
	public void login() {

		// Identification
		WebElement editbox_User = driver.findElement(By.id("txtUsername"));

		// Action
		editbox_User.sendKeys("Admin");

		// Enter value in password field
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");

		
		//click on Login button
		driver.findElement(By.id("")).click();;
		
	}

}
